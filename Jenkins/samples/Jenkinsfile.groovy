
node('masterLin') {

    def ciConfig
    def ciConfigPath = "Config.yml"
    def ocCmdTool
    def uploadAppDeployment
    def uploadAppConfigMap
    def uploadPrometheus
    def deleteAppDeployment
    def deleteConfigMap
    def deletePrometheus
    env.openshiftDeploymentName = "DeploymentConfig.yml"
    env.openshiftConfigMapName = "ConfigMap.yml"


    stage("Обработка входящих параметров") {
        properties([
                parameters([
                        choice(
                                name: 'action',
                                choices: ['Установка или обновление', 'Удаление'],
                                description: "Что сделать"
                        ),
                        booleanParam(
                                name: 'unlock_mb_Deployment',
                                defaultValue: true,
                                description: 'Применить действие к ресурсам развертывания (Deployment, Route, Service) приложения unlock_mb'
                        ),
                        booleanParam(
                                name: 'unlock_mb_ConfigMap',
                                defaultValue: true,
                                description: 'Применить действие к ConfigMap и Secret приложения unlock_mb'
                        ),
                        booleanParam(
                                name: 'prometheus',
                                defaultValue: true,
                                description: 'Применить действие к prometheus'
                        ),
                        choice(
                                name: 'envName',
                                choices: ['dev', 'dev_2', 'ift', 'lt', 'psi', 'psi_2', 'prod_1', 'prod_2'],
                                description: "Окружение"
                        ),
                        booleanParam(
                                name: 'm36',
                                defaultValue: false,
                                description: 'Включить метрику m36'
                        ),
                        string(
                                name: 'distributionVersion',
                                defaultValue: 'D-02.000.00-11',
                                description: 'Версия артефакта дистрибутива приложения unlock_mb для установки (при удалении не используется)'
                        ),
                        string(
                                name: 'limitsCpu',
                                defaultValue: '500',
                                description: 'limits.cpu [m]'
                        ),
                        string(
                                name: 'limitsMemory',
                                defaultValue: '900',
                                description: 'limits.memory [Mi]'
                        ),
                        string(
                                name: 'requestCpu',
                                defaultValue: '500',
                                description: 'requests.cpu [m]'
                        ),
                        string(
                                name: 'requestMemory',
                                defaultValue: '900',
                                description: 'requests.memory [Mi]'
                        ),
                        string(
                                name: 'replicasCount',
                                defaultValue: '1',
                                description: 'Количество реплик приложения'
                        ),
                        string(
                                name: 'vaultPassword',
                                defaultValue: '',
                                description: 'Пароль от vault файла с секретными значениями приложения unlock_mb'
                        )
                ])
        ])

        if (params.action == "Установка или обновление" && params.unlock_mb_Deployment == true) {
            uploadAppDeployment = true
        }
        if (params.action == "Установка или обновление" && params.unlock_mb_ConfigMap == true) {
            deleteConfigMap = true //Secret нельзя менять, можно только пересоздать
            uploadAppConfigMap = true
        }
        if (params.action == "Установка или обновление" && params.prometheus == true) {
            uploadPrometheus = true
        }

        if (params.action == "Удаление" && params.unlock_mb_Deployment == true) {
            deleteAppDeployment = true
        }
        if (params.action == "Удаление" && params.unlock_mb_ConfigMap == true) {
            deleteConfigMap = true
        }
        if (params.action == "Удаление" && params.prometheus == true) {
            deletePrometheus = true
        }
    }


    stage('Скачивание конфига') {
        def scmVars = checkout(scm)
        println "scmVars: " + scmVars
    }

    stage('M36') {
        if (params.m36 == true) {
            wrap([$class: 'BuildUser']) {
                withEnv(["BUILD_USER_EMAIL=${BUILD_USER_EMAIL}", "BUILD_USER_ID=${BUILD_USER_ID}", "BUILD_USER=${BUILD_USER}"]) {
                    try {

                        def dp = library 'DeployPermission'
                        def dl = library 'devops_lib@1.9.0'
                        def dpm = library 'DPMPipelineUtils@1.3'


                        if (!fileExists(ciConfigPath))
                            failBuild "Error. Config file $ciConfigPath not found!"
                        ciConfig = readYaml file: ciConfigPath

                        def x = dp.DeployPermission.new()
                        def result = x.get_permission("""https://${ciConfig.nexusUrl}/content/repositories/${ciConfig.distributionGroupId}/${ciConfig.distributionGroupId}/${
                            ciConfig.distributionArtifactId
                        }/${params.distributionVersion}/${ciConfig.distributionArtifactId}-${params.distributionVersion}-distrib.zip""",
                                "Solntsev.B.V@mail.ca.sbrf.ru,Alabuzhev.A.Al@sberbank.ru,Kirillov.P.And@omega.sbrf.ru,Yastrebkova.S.A@sberbank.ru,Ermolov-KE@mail.ca.sbrf.ru,Salo.G.Al@sberbank.ru,ivr_platform@sberbank.ru")
                        println("CHECK RESULT = " + result);
                        if (result) {
                            println "Bars metrics successfully checked"
                        } else {
                            failBuild "Bars metrics checking FAILURE"
                        }
                    } catch (e) {
                        println "Bars metrics checking FAILURE: " + e
                        failBuild "Bars metrics checking FAILURE"
                    }
                }
            }
        }
    }

    stage('Подготовка конфига') {
        currentBuild.displayName = "unlock-mb: $params.action:$params.envName:$distributionVersion"

        if (!fileExists(ciConfigPath))
            throw new Exception("Error. Config file $ciConfigPath not found!")
        ciConfig = readYaml file: ciConfigPath
        print ciConfig

        ocCmdTool = tool name: 'oc-3.11', type: 'oc'

        if (uploadAppDeployment == true) {
            def imageFromNexus = getDockerImageFromNexusDeploymentConfig(ciConfig, params.distributionVersion)
            configureDeploymentConfig(params.envName, imageFromNexus)
        }
        if (uploadAppConfigMap == true) {
            def applicationSecrets = getApplicationSecrets(params.vaultPassword)
            configureConfigMap(params.envName, applicationSecrets)
        }
        configurePrometheusResources(ciConfig."$params.envName".openshiftNamespace)
    }

    stage('Авторизация в OpenShift') {
        withEnv(["PATH+OC=${ocCmdTool}"]) {
            def openShiftUrl = ciConfig."$params.envName".openshiftUrl
            def openShiftNamespace = ciConfig."$params.envName".openshiftNamespace
            def openShiftCredentials = ciConfig."$params.envName".openshiftCredentials

            openShiftAuth(openShiftUrl, openShiftNamespace, openShiftCredentials)
        }
    }

    stage('Выполнение задач в OpenShift') {
        withEnv(["PATH+OC=${ocCmdTool}"]) {
            if (deleteAppDeployment) {
                deleteAppDeploymentOpenShiftResources(params.envName)
            }
            if (deleteConfigMap) {
                deleteAppConfigMapOpenShiftResources(params.envName)
            }
            if (deletePrometheus) {
                deletePrometheusOpenShiftResources()
            }

            if (uploadAppDeployment) {
                uploadAppDeploymentOpenShiftResources(params.envName)
            }
            if (uploadAppConfigMap) {
                uploadAppConfigMapOpenShiftResources(params.envName)
            }
            if (uploadPrometheus) {
                uploadPrometheusOpenShiftResources()
            }
        }
    }
}


//=========================== FUNCTIONS ===========================

/**
 * Заваливатель сборки
 */
def failBuild(def message) {
    echo message
    currentBuild.result = 'FAILURE'
    throw new Exception(message)
}


/**
 * Расшифровка файла с секретами приложения secrets-vault.yml
 */
def getApplicationSecrets(def vaultPassword) {
    wrap([$class: 'MaskPasswordsBuildWrapper', varMaskRegexes: [[regex: vaultPassword]]]) {
        sh """ echo "${vaultPassword}" > vault_password.txt """

        if (params.envName.equals('dev') || params.envName.equals('dev_2') || params.envName.equals('ift') || params.envName.equals('lt')) {
            sh """ ansible-vault decrypt secrets-vault-dev-ift-lt.yml --vault-password-file vault_password.txt"""
            def applicationSecrets = readYaml file: 'secrets-vault-dev-ift-lt.yml'
            return applicationSecrets
        }
        sh """ ansible-vault decrypt secrets-vault-psi-prom.yml --vault-password-file vault_password.txt"""
        def applicationSecrets = readYaml file: 'secrets-vault-psi-prom.yml'
        return applicationSecrets
    }
}


/**
 * Конфигурация файлов приложения: DeploymentConfig.yml.
 * В DeploymentConfig.yml подставляется image.
 */
def configureDeploymentConfig(def envName, def imageFromNexus) {
    println "configureDeploymentConfig"

    // В ресурсе Deployment меняем значение image, на значение полученное из Nexus, ставим лимиты cpu, memory, количество реплик
    sh """sed -i 's#\${umb.image}#${imageFromNexus}#' $envName/openshift/$env.openshiftDeploymentName  """

    sh """sed -i 's#\${limits.cpu}#${params.limitsCpu}#' $envName/openshift/$env.openshiftDeploymentName  """
    sh """sed -i 's#\${limits.memory}#${params.limitsMemory}#' $envName/openshift/$env.openshiftDeploymentName  """
    sh """sed -i 's#\${requests.cpu}#${params.requestCpu}#' $envName/openshift/$env.openshiftDeploymentName  """
    sh """sed -i 's#\${requests.memory}#${params.requestMemory}#' $envName/openshift/$env.openshiftDeploymentName  """
    sh """sed -i 's#\${replicasCount}#${params.replicasCount}#' $envName/openshift/$env.openshiftDeploymentName  """
    sh """sed -i 's#\${app.version}#${params.distributionVersion}#' $envName/openshift/$env.openshiftDeploymentName  """
}


/**
 * Конфигурация файлов приложения: ConfigMap.yml.
 */
def configureConfigMap(def envName, def applicationSecrets) {
    println "configureConfigMap"
    //Получаем секретные значения из объекта applicationSecrets
    def springDatasourcePassword = applicationSecrets."$envName".spring.datasource.password
    def serverSslKeyStorePassword = applicationSecrets."$envName".server.ssl."key-store-password"
    def serverSslTrustStorePassword = applicationSecrets."$envName".server.ssl."trust-store-password"
    def pomApiAuthLogin = applicationSecrets."$envName".pom.api.auth.login
    def pomApiAuthPassword = applicationSecrets."$envName".pom.api.auth.password
    def logbackKafkaClientJksPassword = applicationSecrets."$envName".logback.kafkaClientJksPassword
    def pomApiTrustStore = applicationSecrets."$envName".pom.api.trustStore

    if (springDatasourcePassword == null) {
        throw new Exception("secret value springDatasourcePassword is null")
    }
    if (serverSslKeyStorePassword == null) {
        throw new Exception("secret value serverSslKeyStorePassword is null")
    }
    if (serverSslTrustStorePassword == null) {
        throw new Exception("secret value serverSslTrustStorePassword is null")
    }
    if (pomApiAuthLogin == null) {
        throw new Exception("secret value pomApiAuthLogin is null")
    }
    if (pomApiAuthPassword == null) {
        throw new Exception("secret value pomApiAuthPassword is null")
    }
    if (logbackKafkaClientJksPassword == null) {
        throw new Exception("secret value logbackKafkaClientJksPassword is null")
    }
    if (pomApiTrustStore == null) {
        throw new Exception("secret value pomApiTrustStore is null")
    }

    //В ConfigMap.yaml подставляем значения из секретов
    wrap([$class: 'MaskPasswordsBuildWrapper', varMaskRegexes: [[regex: springDatasourcePassword],
                                                                [regex: serverSslKeyStorePassword],
                                                                [regex: serverSslTrustStorePassword],
                                                                [regex: pomApiAuthLogin],
                                                                [regex: pomApiAuthPassword],
                                                                [regex: logbackKafkaClientJksPassword],
                                                                [regex: pomApiTrustStore]]]) {

        sh """sed -i 's/\${spring.datasource.password}/${springDatasourcePassword}/' $envName/openshift/$env.openshiftConfigMapName  """
        sh """sed -i 's/\${server.ssl.key-store-password}/${serverSslKeyStorePassword}/' $envName/openshift/$env.openshiftConfigMapName  """
        sh """sed -i 's/\${server.ssl.trust-store-password}/${serverSslTrustStorePassword}/' $envName/openshift/$env.openshiftConfigMapName  """
        sh """sed -i 's/\${pom.api.auth.login}/${pomApiAuthLogin}/' $envName/openshift/$env.openshiftConfigMapName  """
        sh """sed -i 's/\${pom.api.auth.password}/${pomApiAuthPassword}/' $envName/openshift/$env.openshiftConfigMapName  """
        sh """sed -i 's#\${logback-kafka-client-jks-password}#${logbackKafkaClientJksPassword}#' $envName/openshift/$env.openshiftConfigMapName  """
        sh """sed -i 's#\${pom.api.trustStore}#${pomApiTrustStore}#' $envName/openshift/$env.openshiftConfigMapName  """
    }
}


/**
 * Конфигурация файлов Prometheus: prometheus-projects.yaml, prometheus-sa.yaml
 */
def configurePrometheusResources(def openshiftNamespace) {
    sh """ sed -i 's/\${namespace.name}/${openshiftNamespace}/' common/prometheus-projects.yaml """
    sh """ sed -i 's/\${namespace.name}/${openshiftNamespace}/' common/prometheus-sa.yaml """
}


/**
 * Удаляет ресурсы приложения в OpenShift:  Route, Deployment, Service
 */
def deleteAppDeploymentOpenShiftResources(def envName) {
    println "deleteAppDeployment"
    sh """oc delete -f $envName/openshift/$env.openshiftDeploymentName --ignore-not-found=true"""
}


/**
 * Удаляет ресурсы приложения в OpenShift: Secrets, ConfigMap
 */
def deleteAppConfigMapOpenShiftResources(def envName) {
    println "deleteAppConfigMap"
    sh """oc delete secret umb --ignore-not-found=true """
    sh """oc delete -f $envName/openshift/$env.openshiftConfigMapName --ignore-not-found=true"""
}


/**
 * Удаляет ресурсы Prometheus в OpenShift: ServiceAccount, RoleBinding, Secret, Deployment, ConfigMap, Service, Route
 */
def deletePrometheusOpenShiftResources() {
    sh """oc delete -f common/prometheus-projects.yaml --ignore-not-found=true"""
    //на пси и пром нельзя удалять service account, но он уже создан
    if ( !(params.envName.equals('psi') || params.envName.equals('psi_2') || params.envName.equals('prod') || params.envName.equals('prod_2'))) {
        sh """oc delete -f common/prometheus-sa.yaml --ignore-not-found=true"""
    }
}


/**
 * Загружает ресурсы приложения в OpenShift: Route, Deployment, Service
 */
def uploadAppDeploymentOpenShiftResources(def envName) {
    println "uploadAppDeployment"
    sh """oc apply -f $envName/openshift/$env.openshiftDeploymentName  """
}


/**
 * Загружает ресурсы приложения в OpenShift: Secrets, ConfigMap
 */
def uploadAppConfigMapOpenShiftResources(def envName) {
    println "uploadAppConfigMap"
    //upload Secret umb. Маунтится в 'директорию приложения'.
    sh """oc create secret generic umb --from-file=$envName/application_config/$envName-umb.jks \
                                       --from-file=$envName/application_config/$envName-truststorePom.jks \
                                       --from-file=$envName/application_config/user_ivr.jaas \
                                       --from-file=$envName/application_config/user_ivr.keytab \
                                       --from-file=$envName/application_config/krb5.conf \
                                       --from-file=$envName/application_config/$envName-umb-client.jks """

    sh """oc apply -f $envName/openshift/$env.openshiftConfigMapName  """
}


/**
 * Загружает ресурсы Prometheus в OpenShift: ServiceAccount, RoleBinding, Secret, Deployment, ConfigMap, Service, Route
 */
def uploadPrometheusOpenShiftResources() {
    sh """oc apply -f common/prometheus-projects.yaml  """
    //на пси и пром нельзя создавать service account, но он уже создан
    if ( !(params.envName.equals('psi') || params.envName.equals('psi_2') || params.envName.equals('prod') || params.envName.equals('prod_2'))) {
        sh """oc apply -f common/prometheus-sa.yaml  """
    }
}


/**
 * Скачивает DeploymentConfig.yml из Nexus и возвращает значение image
 */
def getDockerImageFromNexusDeploymentConfig(def ciConfig, def version) {
    println "clone config from nexus"
    def nexusUrl = ciConfig.nexusUrl
    def distributionGroupId = ciConfig.distributionGroupId
    def distributionArtifactId = ciConfig.distributionArtifactId

    withCredentials([usernamePassword(credentialsId: ciConfig.nexusCredentials, usernameVariable: 'NEXUS_USER', passwordVariable: 'NEXUS_PASSWORD')]) {
        sh """
        curl -k -u $NEXUS_USER:$NEXUS_PASSWORD https://${nexusUrl}/content/repositories/${distributionGroupId}/${distributionGroupId}/${
            distributionArtifactId
        }/${version}/${distributionArtifactId}-${version}-distrib.yml > deploymentConfigFromNexus.yml
      """
    }

    sh """ cat deploymentConfigFromNexus.yml """

    def deploymentConfigFromNexus = readYaml file: 'deploymentConfigFromNexus.yml'
    def imageFromNexus = deploymentConfigFromNexus.items[0].spec.template.spec.containers[0].image
    print 'image from nexus: ' + imageFromNexus
    return imageFromNexus
}


/**
 * Авторизация в OpenShift c помощью логина и пароля или токена находящихся в секретах Jenkins.
 */
def openShiftAuth(def openShiftUrl, def openShiftNamespace, def credentialsId) {
    sh """
        oc version
        export KUBECONFIG=./kubeconfig
        """
    try {
        withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'OPENSHIFT_USER', passwordVariable: 'OPENSHIFT_PASSWORD')]) {
            println "Using username & password authentication to OpenShift"
            sh """ oc login https://$openShiftUrl --insecure-skip-tls-verify -u $OPENSHIFT_USER -p $OPENSHIFT_PASSWORD """
        }
    } catch (Exception e) {
        withCredentials([string(credentialsId: credentialsId, variable: 'OPENSHIFT_TOKEN')]) {
            println "Using token authentication to OpenShift"
            sh """ oc login https://$openShiftUrl --insecure-skip-tls-verify --token $OPENSHIFT_TOKEN """
        }
    }
    sh """ oc project $openShiftNamespace """
}