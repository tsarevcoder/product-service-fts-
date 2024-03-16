FROM bellsoft/liberica-openjdk-debian:17

WORKDIR /app

COPY target/spring-0.0.1-SNAPSHOT.jar ./application.jar

ENTRYPOINT["java", "-jar", "./application.jar"]
