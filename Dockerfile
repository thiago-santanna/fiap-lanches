# Define a imagemEntity base usada para o maven
FROM amazoncorretto:17-alpine3.17-jdk as builder

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiando oarquivo pom.xml e tudo que preciso para executar o Maven para a pasta do container
COPY pom.xml .
COPY mvnw .
COPY .mvn .
RUN ./mvnw dependency:go-offline -B
COPY src src
RUN ./mvnw package -DskipTests

# Etapa para executar o sistema
FROM amazoncorretto:17.0.7-alpine

WORKDIR /app

# Copia o arquivo JAR do container de cima
COPY --from=builder app/target/fiap-lanches-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8080
# Comando a ser executado quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]
