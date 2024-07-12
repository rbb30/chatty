# backend/Dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy Gradle wrapper and settings
COPY gradlew gradlew.bat ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

# Copy project source
COPY src ./src

# Ensure gradlew has execute permission
RUN chmod +x gradlew

# Build the project
RUN ./gradlew build -x test

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["./gradlew", "bootRun"]