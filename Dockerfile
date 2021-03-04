FROM openjdk:11-jre-slim-sid

LABEL maintainer="Anderson Bastos"
LABEL version="1.0"

EXPOSE 8080

VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]