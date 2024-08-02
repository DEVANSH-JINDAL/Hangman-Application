# Use a newer version of OpenJDK as base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Expose the port that the application uses
EXPOSE 8080

# Copy the packaged JAR file into the container
COPY target/game-docker2.jar /app/game-docker2.jar

# Specify the command to run your application
ENTRYPOINT ["java", "-jar", "game-docker2.jar"]