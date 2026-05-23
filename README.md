# Job Application Tracker API

A RESTful backend API built with Spring Boot and PostgreSQL for tracking job applications throughout the hiring process.

Built as a learning project to demonstrate backend development skills including REST API design, database integration, and professional Git workflow.

---

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 25 | Programming language |
| Spring Boot 4 | Backend framework |
| Spring Data JPA | Database integration layer |
| Hibernate | ORM — maps Java objects to database tables |
| PostgreSQL | Relational database |
| Maven | Dependency management and build tool |

---

## Prerequisites

Before running this project make sure you have the following installed:

- [JDK 21 or higher](https://adoptium.net)
- [PostgreSQL 16](https://www.postgresql.org/download/windows)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Postman](https://www.postman.com/) (for testing the API)

---

## Database Setup

1. Open pgAdmin and connect to your PostgreSQL server
2. Create a new database named `jobtracker`
3. Spring Boot creates the tables automatically on first run

---

## Configuration

Open `src/main/resources/application.properties` and update the following with your PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/jobtracker
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD_HERE
```

---

## Running the Application

1. Clone the repository:
```bash
git clone https://github.com/EthanLev/job-application-tracker.git
```

2. Open the project in IntelliJ IDEA

3. Wait for Maven to finish downloading dependencies

4. Run `JobTrackerApplication.java`

5. The API will be available at `http://localhost:8080`

---

## API Endpoints

### Base URL

---

### Get All Job Applications

Returns a list of all job applications.

**Response — 200 OK**
```json
[
  {
    "id": 1,
    "company": "Google",
    "jobTitle": "Software Engineer",
    "status": "APPLIED",
    "dateApplied": "2024-01-15",
    "notes": "Referred by a friend"
  }
]
```

---

### Get Job Application by ID

Returns a single job application by its ID.

**Response — 200 OK**
```json
{
  "id": 1,
  "company": "Google",
  "jobTitle": "Software Engineer",
  "status": "APPLIED",
  "dateApplied": "2024-01-15",
  "notes": "Referred by a friend"
}
```

**Response — 404 Not Found**
Returned when no job application exists with the given ID.

---

### Create Job Application

Returns a single job application by its ID.

**Response — 200 OK**
```json
{
  "id": 1,
  "company": "Google",
  "jobTitle": "Software Engineer",
  "status": "APPLIED",
  "dateApplied": "2024-01-15",
  "notes": "Referred by a friend"
}
```

**Response — 404 Not Found**
Returned when no job application exists with the given ID.

---

### Create Job Application

Updates all fields of an existing job application.

**Request Body**
```json
{
  "company": "Google",
  "jobTitle": "Senior Software Engineer",
  "status": "INTERVIEW",
  "dateApplied": "2024-01-15",
  "notes": "Technical interview scheduled"
}
```

**Response — 200 OK**
```json
{
  "id": 1,
  "company": "Google",
  "jobTitle": "Senior Software Engineer",
  "status": "INTERVIEW",
  "dateApplied": "2024-01-15",
  "notes": "Technical interview scheduled"
}
```

**Response — 404 Not Found**
Returned when no job application exists with the given ID.

---

### Delete Job Application

Deletes a job application by its ID.

**Response — 204 No Content**
Returned on successful deletion.

**Response — 404 Not Found**
Returned when no job application exists with the given ID.

---

## Valid Status Values

| Status | Meaning |
|---|---|
| `APPLIED` | Application submitted |
| `INTERVIEW` | Interview scheduled or completed |
| `OFFER` | Job offer received |
| `REJECTED` | Application rejected |

---

## Author

Ethan Levesque — [GitHub](https://github.com/EthanLev)