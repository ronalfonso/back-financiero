FROM openjdk:17-alpine as maven
LABEL authors="raalf"

WORKDIR /app

ARG JAR_FILE=target/cuentas_ms.jar

COPY ${JAR_FILE} /app/cuentas_ms.jar

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 8002

ENTRYPOINT ["java", "-jar", "clientes_ms.jar"]