FROM java:8
RUN mkdir /test_app
COPY testService.jar /test_app/testService.jar
WORKDIR /test_app
ENTRYPOINT ["java","-jar","testService.jar"]
