FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests


FROM eclipse-temurin:17-jre-alpine
WORKDIR /app


RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring


COPY --from=build /app/target/*.jar app.jar


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "app.jar"]