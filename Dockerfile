# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the target directory into the container
COPY target/Polls_System-0.0.1-SNAPSHOT.jar /app/Polls_System-0.0.1-SNAPSHOT.jar

# Expose the port the Spring Boot application runs on
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "Polls_System-0.0.1-SNAPSHOT.jar"]