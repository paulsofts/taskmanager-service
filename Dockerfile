FROM openjdk:21
EXPOSE 9090
ADD target/taskmanager-service.jar taskmanager-service.jar
ENTRYPOINT ["java", "-jar", "/taskmanager-service.jar"]