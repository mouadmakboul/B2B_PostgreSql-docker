#FROM openjdk:17-jdk-alpine
#ADD target/demo3-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]


# Étape de construction
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Étape d'exécution
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/demo3-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
