FROM openjdk:18-ea-11-jdk-alpine3.15

EXPOSE 8080

ARG JAR_FILE=target/queryapp-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

ENTRYPOINT exec java -jar /app.jar