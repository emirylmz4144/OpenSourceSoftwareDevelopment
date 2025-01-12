# Base image olarak OpenJDK 22 kullanıyoruz
FROM openjdk:22-jdk-slim

# Çalışma dizinini ayarlıyoruz
WORKDIR /app

# Jar dosyasını kopyalıyoruz
COPY target/CalculatorRestApi-0.0.1-SNAPSHOT.jar app.jar

# Uygulamayı çalıştırıyoruz
ENTRYPOINT ["java", "-jar", "app.jar"]
