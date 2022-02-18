FROM openjdk:18-ea-11-jdk-alpine3.15

COPY target/mock-service.jar app.jar

EXPOSE 30100

ENTRYPOINT ["java", "-jar", "/app.jar"]