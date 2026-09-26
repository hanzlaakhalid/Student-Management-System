# 🎓 SMS: Student Management System

A web application for managing student records with full **CRUD** (Create, Read, Update, Delete) operations. It is built with **Java Servlets (Jakarta EE)**, **JDBC** and **MySQL**, and has a responsive HTML/CSS front end. It runs on **Apache Tomcat**.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Jakarta EE](https://img.shields.io/badge/Jakarta%20Servlets-007396?style=for-the-badge&logo=jakartaee&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/Apache%20Tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)

---

## 📑 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Architecture](#-architecture)
- [Getting Started](#-getting-started)
- [Usage](#-usage)
- [Servlet Endpoints](#-servlet-endpoints)
- [Known Limitations & Future Improvements](#-known-limitations--future-improvements)
- [Author](#-author)

---

## ✨ Features

| Operation | Page | Description |
|-----------|------|-------------|
| ➕ **Create** | `registration.html` | Register a new student with name, email, course and country |
| 📋 **Read** | `/read` | View all student records as styled cards |
| ✏️ **Update** | `update.html` | Edit a student's name, course and country, looked up by email |
| 🗑️ **Delete** | `delete.html` | Permanently remove a student by email |

- Responsive dashboard that works on desktop, tablet and mobile
- Modern UI with gradients, hover animations and the Google *Poppins* font
- Database access is kept in a single **DAO** (Data Access Object) class

---

## 🛠 Tech Stack

| Layer | Technology |
|-------|------------|
| Front end | HTML5, CSS3 |
| Back end | Java Servlets (`jakarta.servlet`) |
| Database | MySQL |
| Database driver | MySQL Connector/J 9.3.0 (bundled in `WEB-INF/lib`) |
| Server | Apache Tomcat 10+ |

---

## 📁 Project Structure

```
Student-Management-System/
├── index.html               # Dashboard (home page)
├── registration.html        # Form: add a new student
├── update.html              # Form: update a student
├── delete.html              # Form: delete a student
├── database/
│   └── schema.sql           # MySQL database and table setup
├── docs/
│   └── hierarchy.png        # Diagram of the project hierarchy
└── WEB-INF/
    ├── web.xml              # Deployment descriptor (servlet mappings)
    ├── lib/
    │   └── mysql-connector-j-9.3.0.jar
    └── classes/
        ├── DAO.java         # Database access (insert, read, update, delete)
        ├── Input.java       # Servlet: create
        ├── Read.java        # Servlet: read
        ├── Update.java      # Servlet: update
        └── Delete.java      # Servlet: delete
```

---

## 🏗 Architecture

```
 Browser (HTML forms)
        │  HTTP GET / POST
        ▼
 Servlets (Input, Read, Update, Delete)   ← mapped in WEB-INF/web.xml
        │
        ▼
 DAO.java  ── JDBC ──►  MySQL (student_management_system.student)
```

1. The user fills in a form on one of the HTML pages.
2. The form sends the data to the servlet mapped to it in `web.xml`.
3. The servlet calls the matching `DAO` method, which runs the SQL query over JDBC.
4. The servlet writes the result back to the browser.

---

## 🚀 Getting Started

### Prerequisites

- [Java JDK 11+](https://adoptium.net/)
- [Apache Tomcat 10+](https://tomcat.apache.org/). Tomcat 10 or later is required because the project uses the `jakarta.servlet` namespace.
- [MySQL Server 8+](https://dev.mysql.com/downloads/mysql/)

### 1. Clone the repository

```bash
git clone https://github.com/hanzlaakhalid/Student-Management-System.git
```

### 2. Set up the database

```bash
mysql -u root -p < database/schema.sql
```

This creates the `student_management_system` database and the `student` table:

| Column | Type |
|--------|------|
| `id` | `INT AUTO_INCREMENT PRIMARY KEY` |
| `name` | `VARCHAR(100)` |
| `email` | `VARCHAR(150) UNIQUE` |
| `course` | `VARCHAR(100)` |
| `country` | `VARCHAR(100)` |

### 3. Configure the database connection

The connection settings are in [`WEB-INF/classes/DAO.java`](WEB-INF/classes/DAO.java):

```java
String url = "jdbc:mysql://127.0.0.1/student_management_system";
con = DriverManager.getConnection(url, "root", "root");
```

Change the username and password to match your MySQL setup.

### 4. Deploy to Tomcat

Copy the project folder into Tomcat's `webapps` directory and rename it to `SMS`:

```
<TOMCAT_HOME>/webapps/SMS/
```

### 5. Compile the servlets

From inside `webapps/SMS/WEB-INF/classes`:

```bash
javac -cp "<TOMCAT_HOME>/lib/servlet-api.jar" *.java
```

On Windows, for example:

```bash
javac -cp "C:\Program Files\Apache Software Foundation\Tomcat 10.1\lib\servlet-api.jar" *.java
```

### 6. Start Tomcat and open the app

```
http://localhost:8080/SMS/
```

---

## 💻 Usage

1. Open the **Student Dashboard** at `http://localhost:8080/SMS/`.
2. Click **Add Student** to register a new student.
3. Click **View Records** to see every student in the database.
4. Click **Edit Student**, enter the student's email, and fill in the new details.
5. Click **Delete Student** and enter an email to remove that record.

---

## 🔌 Servlet Endpoints

| URL | Servlet | Parameters | Action |
|-----|---------|------------|--------|
| `/Input` | `Input` | `name1`, `email`, `course`, `country` | Insert a new student |
| `/read` | `Read` | none | List all students |
| `/Update` | `Update` | `name1`, `email`, `course`, `country` | Update the student with this email |
| `/Delete` | `Delete` | `email` | Delete the student with this email |

All endpoints accept both `GET` and `POST`.

---

## 🔮 Known Limitations & Future Improvements

This is an academic project. The following improvements would be needed before using it in production:

- [ ] Use `PreparedStatement` instead of string concatenation to prevent **SQL injection**
- [ ] Move database credentials out of the source code into a config file or environment variables
- [ ] Use a connection pool (e.g. a Tomcat JNDI DataSource) and close connections after each request
- [ ] Use `POST` for requests that change data
- [ ] Add server-side input validation
- [ ] Add authentication for administrators
- [ ] Use JSP or a template engine to render the output pages
- [ ] Add a Maven/Gradle build and package the app as a `.war`

---

## 👤 Author

**Hanzla Khalid**

- GitHub: [@hanzlaakhalid](https://github.com/hanzlaakhalid)

---

⭐ If you found this project helpful, please give it a star!
