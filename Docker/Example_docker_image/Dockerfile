FROM ubuntu:18.04
RUN mkdir /test_app
COPY . /test_app/testService.jar
WORKDIR /test_app
CMD java -jar testService.jar

# перейти в директорию Example_service, выполнить команду: mvn install
# перейти в директорию Example_docker_image, выполнить команду: docker build -t test_image:1.0 .

# выполнив команду: docker images можно посмотреть собравшийся образ