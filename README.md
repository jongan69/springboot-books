# Spring Boot 3.0 Library with Security with JWT Implementation
This project demonstrates the implementation of security using Spring Boot 3.0 and JSON Web Tokens (JWT). It includes the following features:

## Features
* User registration and login with JWT authentication
* Password encryption using BCrypt
* Role-based authorization with Spring Security
* Customized access denied handling
* Logout mechanism
* Refresh token

## Technologies
* Spring Boot 3.0
* Spring Security
* JSON Web Tokens (JWT)
* BCrypt
* Maven
 
## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

* JDK 17+
* Maven 3+


To build and run the project, follow these steps:

* Clone the repository: `git clone`
* Navigate to the project directory: cd backend
* Create SQL Server in Azure and use `cp .env.example .env` and enter the sql server details
* Run `export $(cat .env | xargs)` in terminal to put .env variables in shell
* Build the project: `mvn clean install`
* Run the project: `mvn spring-boot:run`
* To Prepare for azure deploy: 
`export MAVEN_OPTS="--add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.io=ALL-UNNAMED" ./mvnw com.microsoft azure:azure-spring-apps-maven-plugin:1.18.0:config -DadvancedOptions`
* To Deploy to azure:
`./mvnw azure-spring-apps:deploy `

-> The application will be available at http://localhost:8080.