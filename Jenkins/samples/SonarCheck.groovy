/**
 * Проверка maven-проекта в SonarQube
 */


configFileProvider([configFile(fileId: config.maven.jenkinsConfigMapCredentialsId, variable: 'MAVEN_SETTINGS', targetLocation: config.maven.jenkinsSettingsPath)]) {
    withMaven(
            maven: "${config.maven?.toolName}",
            mavenSettingsFilePath: config.maven?.jenkinsSettingsPath,
            jdk: config.maven?.jdk,
            options: [
                    junitPublisher(disabled: config.junitPublisher.disabled),
                    pipelineGraphPublisher(disabled: config.pipelineGraphPublisher.disabled),
                    artifactsPublisher(disabled: config.artifactsPublisher.disabled),
                    openTasksPublisher(disabled: config.openTasksPublisher.disabled),
                    dependenciesFingerprintPublisher(disabled: config.dependenciesFingerprintPublisher.disabled)
            ]) {

        sh """
            mvn \
            sonar:sonar \
            -Dsonar.projectKey=${config.sonar.projectKey} \
            -Dsonar.login=${config.sonar.credentialsId} \
            -Dsonar.host.url=${config.sonar.host} \
            ${config.maven.options}
           """

        timeout(5) {
            waitForQualityGate(config.sonar.credentialsId)
            echo "Sonar QG success."
        }
    }
}

//=========================== FUNCTIONS ===========================

/**
 *
 */
def waitForQualityGate(def jenkinsCredentialsIdForScripts) {
    def sonarTaskProp
    def TaskIdFilePath
    def scannerwork = ".scannerwork/report-task.txt"
    def maven = 'target/sonar/report-task.txt'
    def exists = fileExists scannerwork
    if (exists) {
        TaskIdFilePath = scannerwork
    } else {
        def pom = readMavenPom file: 'pom.xml'
        if (pom.build.directory) {
            TaskIdFilePath = pom.build.directory + '/report-task.txt'
        } else {
            TaskIdFilePath = maven
        }
    }
    sonarTaskProp = readProperties file: TaskIdFilePath
    def taskUrl = sonarTaskProp["ceTaskUrl"]
    echo "SonarQube task URL: ${taskUrl}"

    //Проверяем завершился ли анализ в SonarQube
    //Если статус 'SUCCESS' - продолжаем, если 'FAILURE' или 'CANCELED' - прерываемся и фейлим сборку
    def completed = false
    def qgAvailable = false

    def analysisId
    while (!completed) {
        def url = new URL(taskUrl)
        URLConnection urlConnection = url.openConnection()
        def auth = jenkinsCredentialsIdForScripts + ":"
        urlConnection.setRequestProperty("Authorization", "Basic " + auth.bytes.encodeBase64().toString())
        InputStream inputStream = urlConnection.getInputStream()

        println "Request sonar result: " + urlConnection.getResponseCode()
        if (urlConnection.getResponseCode() == 200) {
            def data = readJSON text: inputStream.getText()
            def status = data.task.status
            echo "SonarQube task status: ${status}"
            switch (status) {
                case 'SUCCESS':
                    println "SonarQube task completed successfully"
                    completed = true
                    qgAvailable = true
                    break
                case 'FAILED':
                case 'CANCELED':
                    /*TODO: Завернуть в отдельную функцию failBuild('message')*/
                    echo "SonarQube background task failed"
                    /*конец TODO*/
                    completed = true
                    break
                default:
                    break
            }
            analysisId = data.task.analysisId
            echo "SonarQube task analysis ID: ${analysisId}"
        } else {
            echo "Something went wrong. Check http client logs"
            completed = true
        }
        sleep time: 5, unit: 'SECONDS'
    }

    // Если фоновая задача отработала успешно, можно проверять состояние Quality Gate
    if (qgAvailable) {

        // URL сервера, на котором запускалась задача
        def sonarServerUrl = sonarTaskProp["serverUrl"]
        echo "SonarQube server URL: ${sonarServerUrl}"

        def url = new URL("${sonarServerUrl}/api/qualitygates/project_status?analysisId=$analysisId")
        URLConnection urlConnection = url.openConnection()
        def auth = jenkinsCredentialsIdForScripts + ":"
        urlConnection.setRequestProperty("Authorization", "Basic " + auth.bytes.encodeBase64().toString())

        println "Request sonar result: " + urlConnection.getResponseCode()
        if (urlConnection.getResponseCode() == 200) {
            def data = readJSON text: urlConnection.getInputStream().getText()
            def status = data.projectStatus.status
            echo "SonarQube Quality Gate status: ${status}"
            if (status == 'OK' || status == 'WARN') {
                echo "SonarQube Quality Gate PASSED"
                //qgPassed = true
            } else {
                echo "SonarQube Quality Gate FAILED. Check SonarQube for more details"
                throw new Exception("SonarQube Quality Gate FAILED. Check SonarQube for more details")
            }
        } else {
            echo "Something went wrong. Check http client logs"
            echo "Response: " + urlConnection.getErrorStream().getText()
            throw new Exception("Something went wrong. Check http client logs")
        }
    } else {
        throw new Exception("Задача отработала неудачно, что то не вышло, но было уже поздно...")
    }
}