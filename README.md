# Java Maven App

A modern Spring Boot 4.1.0 web application built with Java 21 and containerized for cloud deployment.

## Features

- **Spring Boot 4.1.0** - Latest version with modern web framework
- **Java 21** - LTS version with latest language features
- **Cloud-Native Logging** - JSON logging with Logstash encoder
- **Docker Ready** - Containerized with Amazon Corretto JDK 21
- **CI/CD Pipeline** - Jenkins-ready with Groovy scripts

## Prerequisites

- Java 21 (JDK)
- Maven 3.8+
- Docker (optional, for containerization)

## Build

```bash
mvn clean package
```

## Run Locally

```bash
# Using Maven
mvn spring-boot:run

# Using Java directly
java -jar target/java-maven-app-1.0.0-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

## Docker

### Build Image

```bash
mvn clean package
docker build -t java-maven-app:latest .
```

### Run Container

```bash
docker run -p 8080:8080 java-maven-app:latest
```

## Project Structure

```
src/
├── main/
│   ├── java/com/example/
│   │   └── Application.java      # Spring Boot entry point
│   └── resources/
│       └── static/
│           └── index.html         # Web landing page
└── test/                          # Unit tests
```

## API Endpoints

- `GET /` - Landing page
- `GET /actuator/health` - Health check (if enabled)

## Technologies

- Spring Boot 4.1.0
- Java 21
- Maven
- Logstash Logback Encoder
- Jakarta Annotations
- Docker & Amazon Corretto

## CI/CD

- Jenkins pipeline configured in `Jenkinsfile`
- Groovy build scripts in `script.groovy`
