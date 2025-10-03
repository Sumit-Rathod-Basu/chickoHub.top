# Stage 1: Build
FROM maven:3.9.3-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build jar without tests
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk-slim
WORKDIR /app
VOLUME /tmp

# Copy the specific jar from build stage
COPY --from=build /app/target/harpale-0.0.1-SNAPSHOT.jar app.jar

# Expose port (dynamic PORT for Clever Cloud)
EXPOSE 8090

# Start the app with dynamic port
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8090} -jar app.jar"]
