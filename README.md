Spring Boot CRUD APIs


This project demonstrates a simple CRUD (Create, Read, Update, Delete) API using Spring Boot, managing entities with standard endpoints. It utilizes Spring Data JPA and H2 Database for seamless database operations.
Features

    Create: Add new entities.
    Read: Retrieve entities.
    Update: Modify existing entities.
    Delete: Remove entities.
Technologies Used

    Spring Boot: Framework for building the API.
    Spring Data JPA: For database interactions.
    H2 Database: In-memory database for development and testing.
    Maven: Dependency management and build tool.
Getting Started

    Clone the repository: git clone https://github.com/yaminiii3023/Springboot_CRUD_APIs.git
    Navigate to the project directory: cd Springboot_CRUD_APIs
    Build the project: mvn clean install
    Run the application: mvn spring-boot:run
Database Configuration

    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=password
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    spring.h2.console.enabled=true
    spring.h2.console.path=/h2-console
    
    *Access the H2 console at http://localhost:8080/h2-console with the following settings:*

    JDBC URL: jdbc:h2:mem:testdb
    Username: sa
    Password: password

API Endpoints

    POST /api/entities: Create a new entity.
    GET /api/entities: Retrieve all entities.
    GET /api/entities/{id}: Retrieve an entity by ID.
    PUT /api/entities/{id}: Update an existing entity.
    DELETE /api/entities/{id}: Delete an entity by ID.

