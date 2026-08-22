# Java Maven App

A small Spring Boot web application built with Maven and Java 21. The application serves a static welcome page at the root URL.

## Requirements

- Java 21
- Apache Maven 3.9 or newer
- Docker, if using the container workflow

Check the installed Java version:

```bash
java -version
```

## Run Locally

Start the application with Maven:

```bash
mvn spring-boot:run
```

Open [http://localhost:8080/](http://localhost:8080/) in a browser.

## Test

Run the test suite:

```bash
mvn test
```

## Build

Create the executable Spring Boot JAR:

```bash
mvn clean package
```

Run the packaged application:

```bash
java -jar target/java-maven-app-1.0.0.jar
```

## Docker

Build the image after packaging the application:

```bash
mvn clean package -DskipTests
docker build -t java-maven-app .
```

Run the container:

```bash
docker run --rm -p 8080:8080 java-maven-app
```

Open [http://localhost:8080/](http://localhost:8080/) in a browser.

## Project Layout

- `src/main/java/com/example/Application.java`: Spring Boot application entry point
- `src/main/resources/static/index.html`: static welcome page
- `src/test/java/AppTest.java`: unit test
- `Dockerfile`: container image definition
