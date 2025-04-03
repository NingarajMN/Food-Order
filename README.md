# Food-Order

Food-Order is an e-commerce application designed for seamless food ordering and management. Built using Java, Spring Boot, and Thymeleaf, it provides a robust platform for users to browse menus, place orders, and manage deliveries efficiently.

**Features**
User Management: Add, update, and delete user profiles.

Product Management: Manage food items, including adding, updating, and deleting products.

Order Management: Handle order creation, updates, and tracking.

Secure Authentication: Login functionality for users and administrators.

Dynamic Views: Interactive and responsive templates using Thymeleaf.

Database Integration: Persistent data storage with MySQL.

**Technology Stack**
Backend:

Java

Spring Boot

Spring MVC

Spring Data JPA

Frontend:

Thymeleaf

HTML, CSS, JavaScript

Database:

MySQL

Development Tools:

Maven

Spring Tool Suite (STS) or Eclipse

Project Structure
The project is organized into a modular structure for better maintainability:


src/
├── main/
│   ├── java/
│   │   └── com.NMN.foodorder/
│   │       ├── controllers/   # Controllers for handling HTTP requests
│   │       ├── entities/      # Entity classes representing database tables
│   │       ├── repositories/  # Repository interfaces for database operations
│   │       └── services/      # Service layer containing business logic
│   ├── resources/
│   │   ├── templates/         # Thymeleaf templates for views
│   │   ├── static/            # Static assets (CSS, JavaScript)
│   │   └── application.properties # Configuration settings
└── test/                      # Unit test cases



**Setup and Installation**
Follow these steps to set up and run the project locally:

Prerequisites
Java 8 or higher

MySQL

Maven

Spring Tool Suite (STS) or Eclipse

Steps
Clone the Repository:

bash
git clone https://github.com/NingarajMN/Food-Order.git
Navigate to the Project Directory:

bash
cd Food-Order
Configure MySQL Database:

Create a new database in MySQL (e.g., foodorder).

Update application.properties with your MySQL credentials:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/foodorder
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
Build and Run the Project:

bash
mvn spring-boot:run
Access the Application:

Open your browser and navigate to:

http://localhost:8080
