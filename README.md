# 📦 SoftLearning – Java Spring Boot Project

## ℹ Overview

**SoftLearning** is a Java-based project built with the **Spring Boot** framework. It focuses on defining and managing entities, organizing their logical order, and performing unit tests to ensure entity integrity and behavior.

---

## 🧰 Technologies Used

- ☕ **Java 17+**
- 🌱 **Spring Boot**
- 🔬 **JUnit** for unit testing
- 📦 **Maven** for dependency and build management

---

## 📁 Project Structure

softlearning/
├── src/
│ ├── main/
│ │ └── java/com/example/softlearning/
│ │ ├── entity/ # Domain entities
│ │ ├── repository/ # JPA repositories
│ │ └── SoftlearningApplication.java
│ └── test/
│ └── java/com/example/softlearning/
│ └── entity/ # Entity unit tests
├── pom.xml # Maven configuration
└── README.md


---

## 🧍 Entities

The project contains multiple Java classes annotated with `@Entity`, representing the core domain models. These entities are logically structured and demonstrate common JPA relationships, including:

- `@OneToMany`
- `@ManyToOne`
- `@ManyToMany`

The design ensures a clear and maintainable entity hierarchy that aligns with real-world use cases.

---

## ✔ Testing

Unit tests are included to verify:

- Entity creation and structure
- Proper configuration of relationships
- Persistence behavior


