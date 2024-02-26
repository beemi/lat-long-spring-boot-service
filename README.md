# Spring boot Lat long service

This is a simple Spring boot service that returns the latitude and longitude of a given postcode.

## 📋 Requirements

- ☕ Java 17
- 🏗️ Gradle
- 🐬 MySQL
- 🐘 Spring Boot
- 🐬Liquibase
- 🐳 Docker
- 🧩 Docker-compose
- 📬 Postman

# Project structure :file_folder:
```angular2html
.
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── README.md
├── settings.gradle
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── latlong
│   │               config
│   │               ├── LatLongConfig.java
│   │               ├── LatLongSwaggerConfig.java
│   │               ├── LatLongApplication.java
│   │               ├── controller
│   │               │   └── LatLongController.java
│   │               ├── model
│   │               │   ├── LatLong.java
│   │               │   └── Postcode.java
│   │               ├── service
│   │               │   ├── LatLongService.java
│   │               │   └── PostcodeService.java
│   │               └── util
│   │                   └── LatLongUtil.java
│   └── resources
│       ├── application.properties
```

### 🐳 Run the Application with Docker-compose

This application uses MySQL as the backend database. To run the application along with MySQL in Docker containers, use
the following command:


### ▶️ Run the Application Locally

```shell
docker-compose up -d
```

```bash
gradle bootRun
```

Build with Gradle:

```bash
gradle clean build
```

Run test with Gradle:

```bash
gradle test
```

Run jar:

```bash
java -jar build/libs/latlong-spring-boot-service-1.0.0.jar
```

## Swagger UI :books:

http://localhost:80890/api-docs/

http://localhost:8090/swagger-ui/index.html


### Actuator info endpoint :thumbsup:

Actuator health endpoint

http://localhost:8090/actuator/health

