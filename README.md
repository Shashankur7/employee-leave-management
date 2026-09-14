# Employee Leave Management System

A Spring Boot REST API for managing employees and employee leave requests, with MySQL persistence, validation, centralized error handling, role-based API access, and automated service-layer tests.

## Overview

This project demonstrates a layered Java backend architecture suitable for an internal HR leave-management workflow.

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
Spring Data JPA
  |
  v
MySQL
```

## Features

- Employee CRUD operations
- Leave request creation and retrieval
- Employee-specific leave history
- Leave approval/rejection restricted to administrators
- Input validation with clear error responses
- Centralized exception handling
- HTTP Basic authentication for development
- `ADMIN` and `EMPLOYEE` roles
- BCrypt password encoding
- JUnit + Mockito service-layer tests

## Technology Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Security
- Spring Data JPA / Hibernate
- MySQL
- Maven
- Jakarta Bean Validation
- JUnit 5
- Mockito

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
| GET | `/api/leaves/employee/{employeeId}` | ADMIN / EMPLOYEE | List an employee's leave requests |
| PATCH | `/api/admin/leaves/{id}/status?status=APPROVED` | ADMIN | Approve or reject a leave request |

## Local Setup

### Prerequisites

- Java 17
- Maven
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

Set your local MySQL credentials and development-only Basic Auth credentials. `application.properties` is ignored by Git and must not be committed.

### 3. Run

```bash
mvn spring-boot:run
```

The API runs on `http://localhost:8080` by default.

## Authentication

The project currently uses development-only in-memory users configured through environment/local properties.

- `ADMIN` — can access employee/leave APIs and update leave status
- `EMPLOYEE` — can access employee/leave APIs but cannot update leave status

Use the credentials configured in your local `application.properties`. Never use real passwords in source control.

## Testing

Run the automated tests with:

```bash
mvn test
```

Current tests cover leave-request status initialization and invalid date-range validation at the service layer.

## Project Structure

```text
src/
├── main/
│   ├── java/com/shashank/leave/
│   │   ├── config/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── exception/
│   │   ├── repository/
│   │   └── service/
│   └── resources/
│       └── application.properties.example
└── test/
    └── java/com/shashank/leave/service/
```

## Engineering Focus

This project is being developed incrementally to demonstrate practical backend engineering concepts: REST API design, layered architecture, persistence, validation, security, exception handling, and automated testing.

## Future Improvements

- DTO-based response models and mapping
- Pagination and filtering
- OpenAPI / Swagger documentation
- Integration tests with a test database
- Frontend dashboard
- Containerized deployment and CI/CD

## Author

**Shashank Bhoyar** — Java Full Stack Developer | B.Tech Information Technology

- GitHub: https://github.com/Shashankur7
- LinkedIn: https://www.linkedin.com/in/shashank-bhoyar/
- Email: bhoyarshashank4@gmail.com
