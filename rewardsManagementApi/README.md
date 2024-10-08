# Rewards Management API for Balanceè

The Rewards Management API is a Spring Boot application designed to manage customer reward balances and
cashback transaction history. This API provides endpoints for retrieving a customer's current cashback
balance and viewing their cashback transaction history. The application integrates security, allowing for
secure access to resources through JWT (JSON Web Token) authentication.


## Project Setup
### Prerequisites
- Java 17 and higher
- Maven
- A database (MySQL/PostgreSQL)
- Postman (optional for testing)

### Database Configuration
Update the application.properties file with your database credentials:
#### properties
      spring.datasource.url=jdbc:mysql://localhost:3306/rewards_db
      spring.datasource.username=your_username
      spring.datasource.password=your_password


## Project Structure
### Packages
#### Config
- MapperConfig: Configures the ModelMapper to handle entity-to-DTO conversions. Mappers
  Uses MapStruct for mapping between entities and DTOs.


#### Controllers
- Contains a single controller that exposes two endpoints:
    -  Get Rewards Balance: Retrieves the total cashback and current balance for a specific customer.
    -  Get Cashback History: Returns the transaction history, including cashback earned.


#### Data
This package contains:
1. Entities: Classes representing database tables.
2.  Repositories: Spring JPA repositories that interface with the database.


#### DTOs
Contains Data Transfer Objects used to send data to the frontend instead of raw database entities.


#### Exceptions
Includes an exception used throughout the application for error handling.


#### Security
Contains all security-related configurations and components:
- JWTAuthFilter: Intercepts HTTP requests and extracts JWT tokens for authentication.
- PasswordConfig: Manages password encoding and decoding.
- SecurityConfig: Configures Spring Security 6, including protected routes, filters, and exception handling.
- UserAuthenticationEntryPoint: Handles unauthorized access exceptions.
- UserAuthenticationProvider: Manages JWT generation and validation.
- UsernamePasswordAuthFilter: Extracts username and password for authentication during login.
- WebConfig: Configures CORS (Cross-Origin Resource Sharing) for the API.


#### Services
Contains two services:
- Authentication Service: Manages customer authentication, credential verification, and new customer registration.
- Rewards Service: Handles retrieving customer reward balances and cashback transaction history.


### Endpoints
1. #### Get Rewards Balance
- Endpoint: /api/rewards/balance
- Method: GET
- Request Parameters: customerId (as query parameter or path variable)
- Response: Returns a JSON object containing:
    - customerId: The unique identifier of the customer.
    - totalCashback: The total amount of cashback earned.
    - currentBalance: The available balance for cashout.

2. #### Get Cashback History
- Endpoint: /api/rewards/history
- Method: GET
- Request Parameters: customerId (as query parameter or path variable)
- Response: Returns a JSON array of transactions, where each transaction includes:
    - transactionId
    - transactionDate
    - amountEarned
    - description


### Authentication
The application uses JWT for stateless authentication. Every request to a protected endpoint must include a JWT in the Authorization header. JWT tokens are generated and returned upon successful login and registration.

Login and Registration endpoints are the only ones that do not require a token to access. After successful login or registration, the API will return a JWT that the client can use for subsequent requests.

#### Security Configuration
- Stateless Application: No session is maintained by Spring. All protected resources must include a valid JWT for access.
- JWT Structure: The JWT includes user details and is sent as a Bearer token in the request header.


## How to Run the Project**
### Clone the repository
      git clone https://github.com/love-ara/RewardsManagementApi

### Navigate to the project directory:
      cd rewards-management-api

### Run the application using Maven:
mvn spring-boot:run


### API Testing:
You can test the API using Postman. After a successful login or registration, use the returned JWT token for subsequent requests.

For detailed API documentation and testing, you can refer to the Postman collection: https://documenter.getpostman.com/view/33708307/2sAXjRW9X1



### Contributions
We welcome contributions! If you wish to contribute:
- Fork the repository.
- Create a new branch for your feature or bugfix.
- Submit a pull request when ready