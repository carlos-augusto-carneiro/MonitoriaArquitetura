# Use uma imagem base que suporte Java 17
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo JAR do projeto para o contêiner
COPY target/software-0.0.1-SNAPSHOT.jar /app/software-0.0.1-SNAPSHOT.jar

# Copie as credenciais da API do Google para o contêiner
COPY src/main/resources/credentials.json /app/credentials.json

# Defina a variável de ambiente para as credenciais da API do Google
ENV GOOGLE_APPLICATION_CREDENTIALS="/app/credentials.json"

# Exponha a porta que a aplicação irá rodar
EXPOSE 8080

# Defina o comando de entrada para iniciar a aplicação
CMD ["java", "-jar", "software-0.0.1-SNAPSHOT.jar"]