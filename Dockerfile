# Utilisez une image Alpine Linux avec une JVM (par exemple, OpenJDK)
FROM eclipse-temurin:17-jre-alpine

# Copiez le fichier JAR de votre application dans le répertoire de travail du conteneur
COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar

EXPOSE 8080

# Commande pour exécuter votre application Java
CMD ["java", "-jar", "demo.jar"]
