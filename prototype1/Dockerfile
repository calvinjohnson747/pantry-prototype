FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container at the specified working directory
COPY target/spring-boot.jar /app/

# Expose the port that the application will run on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "spring-boot.jar"]