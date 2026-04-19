# 🎓 Landmine Soft College – Student Portal (LMS)

A **full‑stack Learning Management System (LMS)** built using **Spring Boot 3** for managing students, faculty, courses, attendance, marks, fees, and notices in a college environment.

This project is developed as part of **Java Developer Assignment (LMS‑A‑003)** by **Landmine Soft**.

---

## 📌 Features Overview

### 🔐 Authentication & Roles

* JWT‑based authentication
* Role‑based access control: **STUDENT, FACULTY, ADMIN**
* Secure password storage using **BCrypt**

### 👨‍🎓 Student Module

* Student registration & login
* View and update own profile
* Enroll in courses
* View enrolled & available courses
* View attendance
* View internal & exam marks
* Pay semester fees & view fee history
* View notices

### 👩‍🏫 Faculty Module

* Faculty login
* View assigned subjects & courses
* Mark student attendance
* Enter internal marks
* View course‑wise student lists

### 🧑‍💼 Admin Module

* Create faculty & admin accounts
* Manage students
* Create subjects & courses
* Assign subjects to faculty
* Define fee structure
* Generate grade sheets
* Post notices
* View fee collection reports

---

## 🛠 Tech Stack

### Backend

* **Java 17**
* **Spring Boot 4+**
* Spring Data JPA (Hibernate)
* Spring Security + JWT
* Bean Validation
* Swagger / OpenAPI

### Database

* **PostgreSQL** 
* MySQL (Used)

### Tools

* Maven
* Postman
* Git & GitHub

### Frontend 

* Basic React 

---

## 📂 Project Structure

```
src/main/java/com/hospital/
│
├── controller/     # REST Controllers
├── dto/            # Request / Response DTOs
├── entity/         # JPA Entities
├── repository/     # JpaRepository Interfaces
├── service/        # Business Logic
├── exception/      # Custom Exceptions
└── security/       # JWT & Security Config
```

---

## 🗄 Database Design

### Core Tables

* STUDENT
* FACULTY_PERSONAL
* FACULTY
* ADMIN
* SUBJECT
* COURSE
* ENROLLMENT
* ATTENDANCE
* INTERNAL_MARKS
* EXAM_MARKS
* FEE_STRUCTURE
* FEE_PAYMENT
* NOTICE

### Relationships

* Student ↔ Enrollment ↔ Course
* Faculty ↔ Subject ↔ Course
* Student ↔ Attendance / Marks / Fees

---

## 🔑 Authentication APIs

### Student Register

```
POST /api/auth/student/register
```

### Student Login

```
POST /api/auth/student/login
```

### Faculty Login

```
POST /api/auth/faculty/login
```

### Admin Login

```
POST /api/auth/admin/login
```

All secured APIs require:

```
Authorization: Bearer <JWT_TOKEN>
```

---

## 📚 Key APIs

### Student

* GET `/api/students/{roll_number}`
* PATCH `/api/students/{roll_number}`
* POST `/api/students/{roll}/enroll`
* GET `/api/students/{roll}/courses`
* GET `/api/students/{roll}/marks/course/{code}`
* GET `/api/students/{roll}/fees-due`

### Faculty

* GET `/api/faculty/{employee_id}`
* GET `/api/faculty/{id}/subjects`
* POST `/api/faculty/{facultyId}/attendance/{courseId}`
* POST `/api/faculty/{id}/marks/internal/{courseId}`

### Admin

* GET `/api/admin/students`
* POST `/api/admin/courses`
* POST `/api/admin/faculty/{facultyId}/subjects`
* POST `/api/admin/fee-structure`
* GET `/api/admin/grades/semester/{semester}`
* POST `/api/admin/notices`

---

## 🚀 Getting Started

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/student-portal-lms.git
cd student-portal-lms
```

### 2️⃣ Configure Database

Create database:

```sql
CREATE DATABASE hospital_db;
```

Update `application.yml` or `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hospital_db
spring.datasource.username=postgres
spring.datasource.password=your_password
```

### 3️⃣ Run Application

```bash
mvn spring-boot:run
```

---

## 📖 API Documentation

Swagger UI available at:

```
http://localhost:8080/swagger-ui.html
```

---

## 🔐 Security Highlights

* JWT token with role claim
* Method‑level authorization
* Students can update **only their own** profile
* Faculty can access **only assigned courses**

---

## 📅 Project Duration

**Jan 8 – Feb 15 (6 weeks, Full‑time)**

---

## 👨‍💻 Author

**Nikhil Kute**
Java Developer
SpringBoot Developer

---

## 📜 License

This project is for **educational & assignment purposes**.

---

⭐ If you like this project, give it a star on GitHub!
