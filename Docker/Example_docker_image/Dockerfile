FROM java:8
RUN mkdir /test_app
COPY testService.jar /test_app/testService.jar
WORKDIR /test_app
ENTRYPOINT ["java","-jar","testService.jar"]

# перейти в директорию Example_service, выполнить команду: mvn clean install
# перенести testService.jar из taget в директорию Example_docker_image

# перейти в директорию Example_docker_image, выполнить команду: 'docker build -t test_image:1.0 .'  (с точкой)
# посмотреть собравшийся образ: 'docker images'
# запустить контейнер: 'docker run --name testContainer -d --rm -it -p 8080:8080 test_image:1.0'
# посмотреть работающие контейнеры: docker ps
# подключться к контейнеру 'docker exec -it testContainer bash'
# проверить работу можно по ссылке http://localhost:8080/user/get
# остановить все контейнеры: 'docker stop $(docker ps -qa)'