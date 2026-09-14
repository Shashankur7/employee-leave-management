# Employee Leave Management System

A Spring Boot REST API for managing employees and employee leave requests, with MySQL persistence, validation, centralized error handling, role-based API access, and automated service-layer tests.

## Overview

This project demonstrates a layered Java backend architecture for an internal HR leave-management workflow.

```text
Client -> REST Controllers -> Service Layer -> Spring Data JPA -> MySQL
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
- JUnit 5 + Mockito service-layer tests

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
| GET | `/api/leaves/employee/{employeeId}` | ADMIN / EMPLOYEE | List employee leave requests |
| PATCH | `/api/admin/leaves/{id}/status?status=APPROVED` | ADMIN | Approve or reject a leave request |

## Local Setup

1. Install Java 17, Maven, and MySQL 8+.
2. Create a database named `employee_leave_db`.
3. Copy `src/main/resources/application.properties.example` to `application.properties`.
4. Set local MySQL and development-only authentication credentials.
5. Run `mvn spring-boot:run`.

The API runs on port `8080` by default.

## Authentication

Development-only in-memory users are configured through local properties. `ADMIN` can update leave status; `EMPLOYEE` cannot. Never commit real passwords or database credentials.

## Testing

```bash
mvn test
```

Current tests cover leave-request status initialization and invalid date-range validation at the service layer.

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

## Future Improvements

- DTO-based response models and mapping
- Pagination and filtering
- OpenAPI / Swagger documentation
- Integration tests with a test database
- Frontend dashboard
- Containerized deployment and CI/CD

## Author

**Shashank Bhoyar** — Java Full Stack Developer | B.Tech Information Technology

GitHub: https://github.com/Shashankur7
LinkedIn: https://www.linkedin.com/in/shashank-bhoyar/
Email: bhoyarshashank4@gmail.com
