# Use an official OpenJDK runtime as a base image
FROM amd64/openjdk:17-jdk-slim

 # Set the working directory inside the container
 WORKDIR /app

 # Copy the JAR file from the target/build directory to the container # Make sure to adjust the JAR name if necessary

 COPY target/inventory-0.0.1-SNAPSHOT.jar /app/flight-service.jar

 # Expose the port your application will run on

 EXPOSE 8080

 # Command to run the JAR file

 ENTRYPOINT ["java", "-jar", "flight-service.jar"]