# Banking API

A robust RESTful API built with **Spring Boot** and **MySQL** that simulates core banking operations. This project demonstrates backend development best practices, including entity relationships, exception handling, and secure database architecture.

User Login Details
Email: deepesh@test.com
Pass:  password123

## 🚀 Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot 3
* **Database:** MySQL (Relational Data Management)
* **Persistence:** Spring Data JPA / Hibernate
* **Build Tool:** Maven
* **Tools:** IntelliJ IDEA, Postman, MySQL Workbench

## ✨ Key Features

* **User Management:** Register new users with secure unique email validation.
* **Account Operations:** Create multiple bank accounts (Savings/Current) for a user.
* **Transaction System:** Perform Deposits, Withdrawals, and Fund Transfers between accounts.
* **Data Integrity:** Uses `@Transactional` to ensure ACID properties for financial records.
* **Error Handling:** Global exception handling for insufficient funds or invalid accounts.

## 🗄️ Database Schema

The project uses a relational database with the following structure:
* **Users:** Stores customer details (`id`, `name`, `email`, `password`).
* **Accounts:** Links to Users. Stores balance and account numbers (`DECIMAL` precision used for financial accuracy).
* **Transactions:** Records every movement of funds (linked to Accounts).

## ⚙️ Getting Started

### Prerequisites
* Java Development Kit (JDK) 17 or higher
* MySQL Server installed and running
* Maven

### Installation Steps

1.  **Clone the repository**
    ```bash
    git clone [https://github.com/deepesh-suthar/banking-api.git](https://github.com/deepesh-suthar/banking-api.git)
    cd banking-api
    ```

2.  **Configure the Database**
    * Open MySQL Workbench or your terminal.
    * Create the database:
        ```sql
        CREATE DATABASE banking_api;
        ```
    * Open `src/main/resources/application.properties` and update your MySQL credentials:
        ```properties
        spring.datasource.username=root
        spring.datasource.password=YOUR_PASSWORD
        ```

3.  **Run the Application**
    ```bash
    mvn spring-boot:run
    ```
    The server will start on `http://localhost:8080`.

## 🔌 API Endpoints (Examples)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/users` | Create a new user |
| `POST` | `/api/accounts/{userId}` | Create an account for a user |
| `GET` | `/api/accounts/{accountId}/balance` | Check account balance |
| `POST` | `/api/accounts/{accountId}/deposit` | Deposit funds |
| `POST` | `/api/accounts/{accountId}/withdraw` | Withdraw funds |
| `POST` | `/api/accounts/transfer` | Transfer funds between accounts |

## 🔮 Future Improvements

* [ ] Add **Spring Security** with JWT Authentication.
* [ ] Implement **Docker** support for easy containerization.
* [ ] Add **JUnit 5** test cases for critical transaction logic.

---
*Developed by Deepesh Suthar*

