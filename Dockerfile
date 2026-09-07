FROM eclipse-temurin:21-jre

WORKDIR /app

RUN useradd -r appuser
USER appuser

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
