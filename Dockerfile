FROM adoptopenjdk/openjdk11:alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} sheremetyevo_server.jar
ENTRYPOINT ["java","-jar","/sheremetyevo_server.jar"]
