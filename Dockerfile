FROM openjdk:20-slim-buster
COPY target/sync-hack-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
