# Hotel Management Project

## Table Of Content
- [Frameworks and Language Used](#frameworks-and-language-used)
- [Data Flow](#data-flow)
  1. [Controller](#controller)
  2. [Services](#services)
  3. [Repository](#repository)
  4. [Database Design](#database-design)
- [Data Structure Used](#data-structure-used)
- [Project Summary](#project-summary)
- [Getting Started](#getting-started)
- [Testing Endpoints](#testing-endpoints)
- [License](#license)

## Frameworks and Language Used
- Java
- Spring Boot
- Maven
- Dependencies -
  - Spring Web
  - Validation
  - Lombok
  - Hibernate (JPA)
  - H2 (Database)

## Data Flow

### Controller
The `RoomController` class handles HTTP requests related to hotel rooms. It is responsible for handling the following operations:
- Get all rooms
- Add a room
- Get a room by ID
- Check if a room exists
- Count total number of rooms
- Delete a room by ID
- Add a list of rooms
- Update a room's type by ID
- Find rooms by status and type
- Find rooms by status, type, and price range
- Find rooms by type and sorted descending by price
- Find budgeted AC or Non-AC rooms within a price range

### Services
The `RoomService` class contains business logic for managing hotel rooms. It communicates with the repository layer to perform CRUD operations. The following operations are implemented in this service:
- Get all rooms
- Add a room
- Add a list of rooms
- Get a room by ID
- Check if a room exists
- Count total number of rooms
- Delete a room by ID
- Update a room's type by ID
- Find rooms by status
- Find rooms by status and type
- Find rooms by status, type, and price range
- Find rooms by type and sorted descending by price
- Find budgeted AC or Non-AC rooms within a price range

### Repository
The `IRoomRepo` interface is a JPA repository that handles database interactions for the `HotelRoom` entity. It includes the following custom query methods:
- Find a room by ID
- Find rooms by status
- Find rooms by status and type
- Find rooms by status, type, and price range
- Find rooms by type and sorted descending by price
- Find budgeted AC or Non-AC rooms within a price range

### Database Design
The `HotelRoom` entity represents a hotel room and has the following properties:
- `roomId` (Primary Key)
- `roomNumber` (Unique)
- `roomType` (Enum - AC or Non-AC)
- `roomPrice`
- `roomStatus`

## Data Structure Used
- Java List (in RoomController and RoomService) for handling collections of rooms.

## Project Summary
This project is a Hotel Management system that allows managing hotel rooms. It includes functionalities to add, update, delete, and retrieve rooms based on various criteria such as room status, type, and price range.

## Getting Started
To get started with the project, follow these steps:
1. Clone the repository.
2. Set up the database configuration in the application.properties file.
3. Run the application using `mvn spring-boot:run`.

## Testing Endpoints
Once the application is running, you can test the endpoints using tools like Postman or cURL. The available endpoints are as follows:
- GET /rooms
- POST /room
- GET /room/{id}
- GET /room/{id}/exists
- GET /rooms/count
- DELETE /room/{id}
- POST /rooms
- PUT /room/{id}/{type}
- GET /rooms/status/{status}
- GET /rooms/status/{status}/type/{type}
- GET /rooms/status/{status}/type/{type}/priceRange
- GET /rooms/type/{roomType}
- GET /rooms/type1/{roomType1}/type2/{roomType2}

## License
This project is licensed under the [MIT License](LICENSE).

