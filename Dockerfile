# Stage 1: Build the application
FROM maven:3.9.7-sapmachine-22 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests
RUN echo "done"

# Stage 2: Run the application
FROM openjdk:22-slim
WORKDIR /app
LABEL maintainer="foo@mail.com"
LABEL company="hehe"
COPY --from=build /app/target/*.jar app.jar
EXPOSE 3000
ENTRYPOINT ["java","-jar","app.jar"]