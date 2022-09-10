# AS <NAME> to name this stage as maven
FROM maven:3.6.3 AS maven
LABEL MAINTAINER="https://github.com/starfreck"

WORKDIR /usr/src/app
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn package

# For Java 11,
FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=flixzone-api.jar

WORKDIR /opt/app

# Copy the spring-boot-api-tutorial.jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

ARG DB_URL
ARG DB_USER_NAME
ARG DB_USER_PASSWORD
ARG TMDB_API_KEY
ARG JWT_SECRET_KEY

ENTRYPOINT ["java","-jar","-Dspring.datasource.url=${DB_URL} -Dspring.datasource.username=${DB_USER_NAME} -Dspring.datasource.password=${DB_USER_PASSWORD} -Dtmdb.api.key=${TMDB_API_KEY} -Djwt.secret=${JWT_SECRET_KEY}","flixzone-api.jar"]
