"# College-Management-System-Console-Based-" 

A robust Java application designed to manage student records and administrative access through a command-line interface. This project utilizes JDBC (Java Database Connectivity) to perform CRUD operations on a MySQL database, featuring a secure login system for administrators.

FeaturesAdministrator ModuleSecure Sign-Up: Register new admin credentials into the system.

Authentication: Multi-attempt login system (3 chances) to verify admin identity before granting access to student data.

Student Management ModuleCreate: Add new student records including Roll No, Name, Age, Branch, Percentage, and Phone Number.

Read: Retrieve all student records or search for a specific student by their unique Roll ID.

Update: Modify existing student information (Branch, Name, etc.).

Delete: Remove specific students by ID or wipe the entire database table for a fresh start.

Tech StackLanguage: Java (JDK 8+)

Database: MySQL

Driver: MySQL Connector/J

API: JDBC (Java Database Connectivity)

Database SetupTo run this project, you need to create a database named jdbc and the following tables:
SQL

CREATE DATABASE jdbc;

USE jdbc;

-- Table for Admin Credentials
CREATE TABLE collegeadmin (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50) NOT NULL
);

-- Table for Student Records
CREATE TABLE student (
    rollno INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    branch VARCHAR(50),
    percentage DOUBLE,
    phoneno VARCHAR(15)
);

Project Structure---
CollegeManagementMainApp--> The entry point containing the main menu logic.
DBConnection--> Centralized utility class to manage database connections.
AdminLogin / SignUp--> Handles administrative registration and credential input.
AdminVerification--> Logic to validate credentials against the database.
StudentManagement--> The internal menu for all student-related operations.
AddNewStudent--> Handles the INSERT logic for new records.
GetAllStudents--> Executes SELECT * to display all registered students.
Delete...Classes dedicated to removing records safely.

How to RunClone the repository to your local machine.Add the MySQL Connector JAR to your project's build path.

Update DBConnection.java with your local MySQL username and password.

Compile and Run CollegeManagementMainApp.java.
