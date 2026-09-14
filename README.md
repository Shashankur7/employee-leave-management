# Employee Leave Management System

A Spring Boot REST API for managing employees and leave requests with MySQL persistence, validation, centralized error handling, role-based API access, BCrypt authentication, OpenAPI documentation, and service-layer tests.

## Overview

This project demonstrates a layered Java backend for an internal HR leave-management workflow.

```text
Client
  |
  v
REST Controllers
  |
  v
Service Layer
  |
  v
Spring Data JPA / Hibernate
  |
  v
MySQL
```

## Key Features

- Employee CRUD operations
- Leave request creation and retrieval
- Employee-specific leave history
- Admin-only leave approval/rejection
- Request validation and centralized exception handling
- HTTP Basic authentication for development
- `ADMIN` and `EMPLOYEE` roles
- BCrypt password encoding
- JUnit 5 + Mockito service-layer tests
- OpenAPI / Swagger UI documentation
- GitHub Actions CI for Maven test and package verification

## Technology Stack

| Category | Technology |
| --- | --- |
| Language | Java 17 |
| Framework | Spring Boot 3.5.5 |
| Web | Spring Web / REST |
| Security | Spring Security, HTTP Basic, BCrypt |
| Persistence | Spring Data JPA / Hibernate |
| Database | MySQL |
| Validation | Jakarta Bean Validation |
| API Docs | SpringDoc OpenAPI / Swagger UI |
| Build | Maven |
| Testing | JUnit 5, Mockito |
| CI | GitHub Actions |

## API Endpoints

### Employees

| Method | Endpoint | Access | Purpose |
| --- | --- | --- | --- |
| POST | `/api/employees` | ADMIN / EMPLOYEE | Create employee |
| GET | `/api/employees` | ADMIN / EMPLOYEE | List employees |
| GET | `/api/employees/{id}` | ADMIN / EMPLOYEE | Get employee |
| PUT | `/api/employees/{id}` | ADMIN / EMPLOYEE | Update employee |
| DELETE | `/api/employees/{id}` | ADMIN / EMPLOYEE | Delete employee |

### Leave Requests

| Method | Endpoint | Access | Purpose |
| --- | --- | --- | --- |
| POST | `/api/leaves` | ADMIN / EMPLOYEE | Create leave request |
| GET | `/api/leaves` | ADMIN / EMPLOYEE | List leave requests |
| GET | `/api/leaves/{id}` | ADMIN / EMPLOYEE | Get leave request |
| GET | `/api/leaves/employee/{employeeId}` | ADMIN / EMPLOYEE | List employee leave requests |
| PATCH | `/api/admin/leaves/{id}/status?status=APPROVED` | ADMIN | Approve or reject a leave request |

## API Documentation

After starting the application, Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI JSON is available at:

```text
http://localhost:8080/v3/api-docs
```

The API uses HTTP Basic authentication for development. Use the configured local `ADMIN` or `EMPLOYEE` credentials when calling protected endpoints.

## Local Setup

### Prerequisites

- Java 17+
- Maven 3.9+
- MySQL 8+

### 1. Create the database

```sql
CREATE DATABASE employee_leave_db;
```

### 2. Configure the application

Copy:

```text
src/main/resources/application.properties.example
```

to:

```text
src/main/resources/application.properties
```

Then set your local MySQL credentials and development-only authentication passwords. Never commit real credentials.

### 3. Run the application

```bash
mvn spring-boot:run
```

The API runs on port `8080` by default.

## Testing

Run the test suite with:

```bash
mvn test
```

GitHub Actions also runs the Maven test suite and package step on pushes to `main` and pull requests targeting `main`.

## Project Structure

```text
src/
├── main/java/com/shashank/leave/
│   ├── config/
│   ├── controller/
│   ├── dto/
│   ├── entity/
│   ├── exception/
│   ├── repository/
│   └── service/
└── test/java/com/shashank/leave/service/
```

## Engineering Highlights

- Layered controller-service-repository architecture
- Constructor-based dependency injection
- Validation at the REST boundary
- Centralized REST exception handling
- Role-based endpoint authorization
- BCrypt password encoding
- Repository abstraction through Spring Data JPA
- Automated Maven tests
- CI workflow for repeatable build verification
- API documentation through OpenAPI / Swagger UI

## Future Improvements

- DTO-based response models and mapping
- Pagination and filtering
- Integration tests with a test database
- Frontend dashboard
- Dockerized local environment
- Production-grade authentication with JWT/OAuth2

## Project Status

Portfolio / learning project focused on demonstrating Java backend and Spring Boot development practices. It is not presented as a production HR system.

## Author

**Shashank Bhoyar** — Java Full Stack Developer | B.Tech Information Technology

GitHub: https://github.com/Shashankur7
LinkedIn: https://www.linkedin.com/in/shashank-bhoyar/
Email: bhoyarshashank4@gmail.com
