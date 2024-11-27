# Estágio de build
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Estágio final
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/software-0.0.1-SNAPSHOT.jar /app/software-0.0.1-SNAPSHOT.jar
# COPY src/main/resources/credentials.json /app/credentials.json
#ENV GOOGLE_APPLICATION_CREDENTIALS="/app/credentials.json"
EXPOSE 8080
CMD ["java", "-jar", "software-0.0.1-SNAPSHOT.jar"]