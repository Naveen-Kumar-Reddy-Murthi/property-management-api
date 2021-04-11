# [Property Management API using Spring Boot with Spring Security]

[![Actions](https://github.com/gothinkster/spring-boot-realworld-example-app/workflows/Java%20CI/badge.svg)](https://github.com/mnreddy7/property-management-api.git)

> ### Spring boot + H2 DB containing real world examples (CRUD, auth, etc)  

# Brief
Develop a simple Spring boot based application with RESTful API support.

# Feature: API Authorization
API's invocations are accepted ONLY if the client provides a valid API 
key which identifies a valid user in the system. Otherwise, the API will respond with HTTP error code 401.

# Property Management APIs
Property management APIs with the following functionality:
1. authenticate
2. Create property
3. Update property
4. Approve property
5. Search property

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

To access the api first, you need to authenticate in the application. You can do that by 
using below post request with following hardcoded username and password. If the token expires, one
need to hit the below endpoint again and get the token to access the api.
`http://localhost:8080/pma/authenticate`

Request:

`{
"username" : "jwtusername",
"password" : "password"
}
`

Response:

`
{
"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqd3R1c2VybmFtZSIsImV4cCI6MTYxNzk2Mjc0MiwiaWF0IjoxNjE3OTQ0NzQyfQ.ImIabf448QChdr9PF8-gHue075i0UVqhE9HKxp9tmFhWJBAGO46YBEML9PDrYrxa6f9bPfyiGp6tDu8l9aHzEQ"
}
`
# Database

It uses a H2 in memory database (for now), can be changed easily in the `application.properties` for any other database.
You can access the web console using following endpoint
`http://localhost:8080/pma/h2`

# Getting started

You need Java 8 installed.

# How to test
Make sure you update the JWT token in the test file before running tests because
it for running tests authentication is required. Otherwise, tests will fail

mvn test

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