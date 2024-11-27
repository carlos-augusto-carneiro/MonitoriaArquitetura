# Estágio de build
FROM maven:3.9.8-eclipse-temurin-17-alpine AS builder
WORKDIR /app
RUN mvn dependency:go-offline
COPY . .
RUN mvn clean package -DskipTests


# Estágio final
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]