# Define a imagem base
FROM amazoncorretto:17.0.7

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da aplicação para o diretório de trabalho
COPY target/fiap-lanches-0.0.1-SNAPSHOT.jar app.jar

# Comando a ser executado quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]
