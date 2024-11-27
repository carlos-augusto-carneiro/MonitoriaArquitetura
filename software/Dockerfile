# Estágio de build
FROM maven:3.9.8-eclipse-temurin-17-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY app/src ./src
RUN ls -al /app
RUN mvn clean package -DskipTests

# Estágio final
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/software-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "software-0.0.1-SNAPSHOT.jar"]