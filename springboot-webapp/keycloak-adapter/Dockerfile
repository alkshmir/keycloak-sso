FROM maven:3.8.6-openjdk-18-slim AS build
COPY src src
COPY pom.xml pom.xml
RUN  mvn -B package


FROM openjdk:20-ea-17-jdk-slim-bullseye
RUN addgroup --system spring && adduser --system --group spring
USER spring:spring

ARG JAR_FILE=target/*.jar
COPY --from=build ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]