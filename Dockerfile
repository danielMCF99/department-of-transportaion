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

USER 1001

# Run the application
FROM eclipse-temurin:17-jdk-jammy

# Update package list and install Python 3.12
RUN apt-get update && \
  apt-get install -y \
  software-properties-common && \
  add-apt-repository ppa:deadsnakes/ppa && \
  apt-get update && \
  apt-get install -y python3.12 && \
  apt-get clean

# Verify Python installation
# RUN python3.12 --version

# Install pip for Python 3.12
RUN curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py && \
  python3.12 get-pip.py && \
  rm get-pip.py

# Set Python 3.12 as the default python3
RUN update-alternatives --install /usr/bin/python3 python3 /usr/bin/python3.12 1

RUN pip install geopy

# Set environment variables
ENV JAVA_OPTS=""
ENV APP_HOME=/app

# Create directory for python script
WORKDIR $APP_HOME/scripts

COPY --from=build /app/scripts/generate-data.py generate-data.py

# Ensure /app/scripts is writable and accessible
RUN chmod -R 777 /app/scripts

# Create app directory
WORKDIR $APP_HOME

# Copy the Spring Boot jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

USER 1001

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]