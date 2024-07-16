# Forum Hub

## Description

This is a REST API built with Spring Boot for managing Forum topics. It allows users to create questions to be solved.

## Features

1. CRUD of topic
2. View topic details
3. Validation of users

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL Database

## Environment Configuration

To test the application, you will need to set the following properties (if you don't have environment variables, try changing the inputs itself):

```properties
resources>>application.properties

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.error.include-stacktrace=never

api.security.token.secret=${JWT_SECRET}
```

## How to Run the Application

1. **Clone the repository**:
    ```sh
    https://github.com/jamillalobo/forum-hub.git
    ```
2. **Navigate to the project directory**:
    ```sh
    cd your-repository
    ```
3. **Create and configure the `application.properties` file** as mentioned above.
4. **Run the application via terminal (it only works if you make the application properties file)**:
    ```sh
    ./mvnw spring-boot:run
    ```

## Contributions

Contributions are welcome! Feel free to open issues and submit pull requests.

---

Developed by Jamilla Lobo <♡︎/>
