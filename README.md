# Spring boot Lat long service

This is a simple Spring boot service that returns the latitude and longitude of a given postcode.

# Project structure
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


```bash
gradle bootRun
```

Build with Gradle:

```bash
gradle clean build
```
Run jar:

```bash
java -jar build/libs/latlong-spring-boot-service-1.0.0.jar
```

## Swagger UI:

http://localhost:8080/api-docs/

http://localhost:8080/swagger-ui/index.html


### Actuator info endpoint

Actuator health endpoint

http://localhost:8080/actuator/health

