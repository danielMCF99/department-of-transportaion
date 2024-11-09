# Build the application
FROM maven:3.8.8-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the entire project and build it
COPY . .
RUN mvn clean package -DskipTests

# Run the application
FROM eclipse-temurin:17-jdk-jammy

# Set environment variables
ENV JAVA_OPTS=""
ENV APP_HOME=/app

# Create app directory
WORKDIR $APP_HOME

# Copy the Spring Boot jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]