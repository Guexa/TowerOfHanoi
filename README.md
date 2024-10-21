# Tower of Hanoi

## Project Description

The **Tower of Hanoi API** is a Spring Boot-based backend service designed to solve the classic **Towers of Hanoi** puzzle. The service provides two main functionalities:
1. Calculating the sequence of moves required to solve the Towers of Hanoi puzzle for a given number of disks.
2. Computing the minimum number of moves required to solve the puzzle.

This API exposes endpoints that return the calculated moves or the total number of moves, and it uses JSON as the format for the request and response bodies.

## Endpoints

### 1. Solve the Towers of Hanoi Puzzle
- **Method**: `GET`
- **Path**: `/hanoi/solve-tower`
- **Description**: This endpoint calculates the sequence of moves required to solve the Towers of Hanoi for a given number of disks.

#### Request:
- **Query Parameter**: 
  - `numDisks` (integer) - The number of disks in the puzzle.
  
#### Example Request:
`GET http://localhost:8081/hanoi/solve-tower?numDisks=3`

#### Response:
- **200 OK**: Successfully returns the list of moves.
  - **Response Body**:
    ```json
    [
      { "disk": 1, "fromRod": "A", "toRod": "C" },
      { "disk": 2, "fromRod": "A", "toRod": "B" },
      { "disk": 1, "fromRod": "C", "toRod": "B" },
      { "disk": 3, "fromRod": "A", "toRod": "C" },
      { "disk": 1, "fromRod": "B", "toRod": "A" },
      { "disk": 2, "fromRod": "B", "toRod": "C" },
      { "disk": 1, "fromRod": "A", "toRod": "C" }
    ]
    ```
  
- **400 Bad Request**: If the `numDisks` parameter is missing or invalid (less than or equal to 0), it returns a **400** status.
  - **Response Body**: 
    ```json
    {
      "error": "Invalid number of disks"
    }
    ```

- **500 Internal Server Error**: If an unexpected error occurs during processing.

### 2. Get Minimum Moves for the Towers of Hanoi
- **Method**: `GET`
- **Path**: `/hanoi/calculate-moves`
- **Description**: This endpoint returns the minimum number of moves required to solve the Towers of Hanoi puzzle for a given number of disks.

#### Request:
- **Query Parameter**:
  - `numDisks` (integer) - The number of disks in the puzzle.

#### Example Request:
`GET http://localhost:8081/hanoi/calculate-moves?numDisks=3`

#### Response:
- **200 OK**: Successfully returns the minimum number of moves.
  - **Response Body**:
    ```json
    {
      "minMoves": 7
    }
    ```

- **400 Bad Request**: If the `numDisks` parameter is missing or invalid (less than or equal to 0), it returns a **400** status.
  - **Response Body**: 
    ```json
    {
      "error": "Invalid number of disks"
    }
    ```

- **500 Internal Server Error**: If an unexpected error occurs during processing.

## Technologies Used
- **Spring Boot**: Java-based framework used to build the backend API.
- **Swagger (Springfox)**: Used for API documentation.
- **Maven**: Dependency management and build tool.
- **Java 11**: Programming language used for the backend.
- **H2 Database** (optional): In-memory database for testing (if required).
- **Postman**: Used to test and consume the APIs.

## How to Run the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/hanoi-puzzle-api.git

2. Navigate to the project directory:
`cd hanoi-puzzle-api`

3. Build the project using Maven:
`mvn clean install`

4. Run the application:
`mvn spring-boot:run`

The application will run on http://localhost:8081 by default.
