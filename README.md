# [Property Management API using Spring Boot with Spring Security]

[![Actions](https://github.com/gothinkster/spring-boot-realworld-example-app/workflows/Java%20CI/badge.svg)](https://github.com/mnreddy7/property-management-api.git)

> ### Spring boot + H2 DB containing real world examples (CRUD, auth and, etc)  

# Brief
Develop a simple Spring boot based application with RESTful API support.

# Feature: API Authorization
API's invocations are accepted ONLY if the client provides a valid API 
key which identifies a valid user in the system. Otherwise, the API will respond with HTTP error code 401.

# Property Management APIs
Property management APIs with the following functionality:
1. Create property
2. Update property
3. Approve property
4. Search property

# Libraries used
1. Spring boot 
2. Spring Security
3. Jwt
4. Spring Data JPA
5. Lombok
6. MapStruct
7. H2 DB In-Memory
8. Swagger for API Documentation
9. Maven for build and dependency Management

# Security

Integration with Spring Security and add other filter for jwt token process.

The secret key is stored in `application.properties`.

# Database

It uses a H2 in memory database (for now), can be changed easily in the `application.properties` for any other database.

# Getting started

You need Java 8 installed.

# How to run
mvn spring-boot:run

To test that it works, open a browser tab at .  

    curl http://localhost:8080/pma/api/v1/property

Alternatively, you can run

    curl http://localhost:8080/pma/api/v1/property

# API Swagger Documentation
    http://localhost:8080/pma/swagger-ui.html

The entry point address of the backend API is at http://localhost:8080, 

# Help

Please fork and PR to improve the code.