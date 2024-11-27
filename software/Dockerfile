# Estágio de build
FROM ubuntu:latest AS build

# Atualizar pacotes e instalar dependências necessárias
RUN apt-get update
RUN apt-get install openjdk-17-jdk maven -y

# Copiar todo o conteúdo do diretório atual para o contêiner
COPY . /software

# Verificar se o pom.xml foi copiado corretamente
RUN ls -la /software

# Definir o diretório de trabalho para onde o código foi copiado
WORKDIR /software

# Executar o Maven para construir o projeto
RUN mvn clean install

# Estágio final
FROM openjdk:17-jdk-slim

# Expor a porta 8080
EXPOSE 8080

# Copiar o JAR gerado no estágio de build para a imagem final
COPY --from=build /software/target/*.jar app.jar

# Definir o comando de entrada para rodar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
