FROM openjdk:18-alpine
WORKDIR workspace
#ADD build/libs/sgpymes-1.0-snapshot.jar sgpymes-1.0-snapshot.jar
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} sgpymes-1.0-snapshot.jar
ENTRYPOINT ["java", "-jar","sgpymes-1.0-snapshot.jar"]
#EXPOSE 8080

