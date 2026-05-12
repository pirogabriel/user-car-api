# Vehicle Management API

Spring Boot REST API for managing users and cars.

## Features

- User CRUD
- Car ownership relationship
- JWT authentication
- Role-based authorization
- DTOs
- Validation
- Global exception handling
- Pagination and sorting
- Swagger/OpenAPI documentation
- H2 database for development

## Technologies

- Java
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- H2 Database
- Maven
- Swagger/OpenAPI

## Main Endpoints

### Auth

POST /auth/login  
POST /auth/refresh

### Users

GET /api/users  
GET /api/users/{id}  
POST /api/users  
PUT /api/users/{id}  
DELETE /api/users/{id}

### Cars

GET /api/users/{userId}/cars  
POST /api/users/{userId}/cars

### Swagger

/swagger-ui/index.html