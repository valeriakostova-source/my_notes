# my_notes
Secure Notes application built with Java &amp; Spring Boot featuring authentication, note management and admin role authorization.

# Secure Notes 🔐

Secure Notes is a secure note management application built with Java and Spring Boot.

The application allows users to register, authenticate, and manage personal notes, while admins have additional authorization to manage system-wide notes.

## Features

## Authentication & Security
- User registration
- Login authentication
- Password hashing with BCrypt
- Role-based authorization (USER / ADMIN)
- Change password functionality
- Input validation and error handling

## Notes Management
- Create notes
- View personal notes
- Edit notes
- Delete notes

## Admin Features
- View all notes in the system
- Delete other users' notes
- Admin role permissions

---

## Tech Stack

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Hibernate
- Maven
- BCrypt

---

## Architecture

Project follows layered architecture:

```bash
src/main/java
├── controller
├── service
├── repository
├── model
├── security
└── config
```

Layers:
- Controller → handles requests
- Service → business logic
- Repository → database access
- Security → authentication & authorization

---

## Database Schema

### Users
| Field | Type |
|------|------|
| id | Long |
| username | String |
| password | String (hashed) |
| role | Enum |

### Notes
| Field | Type |
|------|------|
| id | Long |
| content | Text |
| user_id | Foreign Key |

---

## Security Implementation

Implemented using Spring Security:

- BCrypt password encryption
- Authentication
- Authorization by roles
- Protected user data access
- Users can only access their own notes
- Admin has elevated permissions

---

## Installation

Clone repository

```bash
git clone https://github.com/yourusername/secure-notes.git
cd secure-notes
```

Configure:

```properties
application.properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```

Run application:

```bash
mvn spring-boot:run
```

---

## API / Functionality

User:
- Register account
- Login
- Create notes
- Update notes
- Delete notes

Admin:
- View all notes
- Delete users notes

---

## Assignment Requirements Covered

✅ User registration  
✅ Password hashing  
✅ Login authentication  
✅ Notes CRUD  
✅ Database integration  
✅ Error handling  
✅ USER and ADMIN roles  
✅ Admin privileges  

---

## Learning Goals

This project was built to practice:

- Spring Boot development
- Spring Security
- Secure authentication
- CRUD operations
- Database persistence with JPA
- Role-based access control (RBAC)

---

## Future Improvements
- REST API endpoints
- JWT authentication
- Unit tests
- Docker deployment

---

## Author
Valeria Kostova
