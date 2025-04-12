# Start with a Java 21 image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port 8080 (or whatever your app uses)
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "target/foodapi-0.0.1-SNAPSHOT.jar"]