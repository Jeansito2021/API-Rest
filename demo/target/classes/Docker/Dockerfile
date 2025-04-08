# Usar una imagen base con JDK y Spring Boot
FROM openjdk:17-jdk-slim

# Copiar el archivo .jar (tu archivo de Spring Boot) desde el directorio target
COPY target/demo-0.0.1-SNAPSHOT.jar demo-app.jar

# Exponer el puerto que usará la aplicación
EXPOSE 8080

# Ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "/demo-app.jar"]
