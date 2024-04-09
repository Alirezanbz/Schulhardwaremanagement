# SchulHardwareManagement Project

## Project Overview
The SchulHardwareManagement system is a comprehensive web application designed to facilitate the management of hardware resources within educational institutions. It allows for the tracking, borrowing, and return of items, ensuring efficient utilization of resources. The application features a user-friendly interface for both students and teachers, with authentication mechanisms ensuring secure access to the system.

## Features
- **User Authentication**: Secure login and logout functionality.
- **Hardware Catalog Management**: Add, update, delete, and list hardware items.
- **Borrowing System**: Users can borrow items, adding them to their cart, and manage borrowings.
- **User Management**: Search users by email or chip ID for borrowing items.
- **Role-Based Access Control**: Different levels of access for students and teachers.
- **RFID Integration**: Track user interactions with hardware items via RFID chip ID.
- **Real-time Status Updates**: Last scanned user and item status updates.
- **Responsive Design**: Accessible on various devices with a user-friendly interface.

## Technologies Used
- **Spring Boot**: For creating the RESTful backend.
- **Spring Security**: For authentication and authorization.
- **Hibernate and JPA**: For ORM and database interactions.
- **MySQL**: As the relational database.
- **jSerialComm**: For serial communication with RFID readers.
- **Bootstrap and jQuery**: For front-end development.

## How to Run
1. **Environment Setup**:
   - Ensure Java JDK 11 or later is installed.
   - Install MySQL and create a database named `schul_hardware_management`.
   - Install Maven for dependency management.

2. **Configuration**:
   - Update `src/main/resources/application.properties` with your database credentials.
   - Configure the COM port in `SerialPortReader.java` if using RFID functionality.

3. **Build and Run**:
   - Navigate to the project root directory in the terminal.
   - Execute `mvn spring-boot:run` to start the application.
   - The application will be available at `http://localhost:8080`.

## Usage
- **Login**: Access the system using your credentials. Different features are available based on the user role.
- **Managing Hardware Items**: Navigate to `Add Item` to add new hardware or use the main table to update or delete existing items.
- **Borrowing**: Select items from the list and add them to your cart. Complete the borrowing process by checking out.
- **Returning Items**: Access the `Warenkorb` to view borrowed items and return them.

## Development and Contributions
- The project is open for development and contributions. Please follow standard coding conventions and submit pull requests for review.
- For new features or bug fixes, create an issue before proceeding with implementation.

## Contact
- For support or queries, please contact the project maintainers at [it3z.team3@itech.de](mailto:it3z.team3@itech.de).


