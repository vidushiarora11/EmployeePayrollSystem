# Employee Payroll System

This is a Java-based Employee Payroll System with a GUI and database connectivity.
It allows adding employee details, calculating salary, and generating salary slips in PDF format.

Technologies used:
- Java
- Swing (GUI)
- MySQL
- JDBC

## 📌 Overview
The **Employee Payroll System** is a Java-based desktop application designed to manage employee salary details.  
It provides a graphical user interface (GUI) where employee information can be entered, salary can be calculated, and salary slips can be generated in **PDF format**.

This project was developed as a **training/college project** to demonstrate:
- Java GUI development
- Database connectivity
- File (PDF) generation
- Proper project structuring

---

## ✨ Features
- GUI-based application using Java Swing
- Add and manage employee details
- Salary calculation logic
- Generate salary slips as PDF files
- Database connectivity using MySQL
- Organised code structure using DAO pattern

---

## 🛠️ Technologies Used
- **Java**
- **Java Swing** (for GUI)
- **MySQL** (database)
- **JDBC** (Java Database Connectivity)
- **External JAR libraries** (for PDF generation)

---

## 📂 Project Structure
EmployeePayrollSystem/
│
├── src/ # All Java source code
│ ├── ui/ # GUI-related classes
│ ├── dao/ # Database access classes
│ └── main/ # Main application entry point
│
├── lib/ # External JAR files (PDF library, etc.)
│
├── output/ # Generated salary slip PDFs
│
├── .vscode/ # VS Code configuration (optional)
│
└── README.md # Project documentation


---

## ▶️ How to Run the Project

### ✅ Prerequisites
Make sure the following are installed on your system:
- Java JDK (version 17 or above recommended)
- MySQL Server
- VS Code / IntelliJ / Eclipse (any Java IDE)

---

### 📌 Step 1: Database Setup
1. Open MySQL
2. Create a database (example):
   ```sql
   CREATE DATABASE employeepayroll;
3. Create the required tables as per the project’s DAO classes.
   ```sql
   CREATE TABLE employee (
    ->     emp_id INT PRIMARY KEY AUTO_INCREMENT,
    ->     name VARCHAR(100) NOT NULL,
    ->     designation VARCHAR(50) NOT NULL,
    ->     department VARCHAR(50) NOT NULL,
    ->     basic_salary DOUBLE NOT NULL
    -> );
   
   CREATE TABLE payroll (
    ->     payroll_id INT PRIMARY KEY AUTO_INCREMENT,
    ->     emp_id INT NOT NULL,
    ->     hra DOUBLE NOT NULL,
    ->     da DOUBLE NOT NULL,
    ->     pf DOUBLE NOT NULL,
    ->     tax DOUBLE NOT NULL,
    ->     net_salary DOUBLE NOT NULL,
    ->     month VARCHAR(20) NOT NULL,
    ->     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ->     FOREIGN KEY (emp_id) REFERENCES employee(emp_id)
    -> );
5. Update database credentials (username, password) inside the database connection file- DBConnection.java in util folder.

📌 Step 2: Add External JAR Files

This project uses external JAR files (MYSQL connector, PDF generation).

Go to the lib/ folder
Ensure all required JAR files are present
Add them to your project’s classpath:

In VS Code:
Right click project → Add to Referenced Libraries

Simple steps to download MySQL Connector JAR (beginner-friendly)

Step 1: Open browser

Step 2: Go to MySQL website

MySQL Connector J download

Step 3: Open the official MySQL page

Click the result that says MySQL Connector/J

Step 4: Download the JAR

Scroll down

Click Operating System: Platform Independent (for windows)

Download the ZIP file (or JAR if shown)

Step 5: Extract the file

Right-click the ZIP → Extract

Inside, you will find a file like:

mysql-connector-j-8.x.x.jar

Step 6: Add it to the project

Copy the JAR file

Paste it into your project’s lib/ folder

Add it to classpath (Referenced Libraries)

Refer to this link to download iText jar file for pdf generation:
https://mvnrepository.com/search?q=itextpdf ( I used the 5.5.13.3 version and downloaded it's JAR file)

⚠️ Important:
If JAR files are missing or not added properly, the project may compile but PDF generation will fail.

📌 Step 3: Run the Application
Locate the main class:
MainApp.java
Run the file
The Payroll GUI window will open

📄 PDF Output
Generated salary slips are saved inside the output/ folder
File name format is based on employee details

⚠️ Important Notes
Ensure MySQL server is running before starting the application
Database name must match the one used in the code
JAR files must be correctly linked
This project is intended for learning and academic purposes

🚀 Future Improvements
User authentication
Better error handling
Export reports in Excel
Improved UI design
Deployment as a standalone executable

👤 Author
Vidushi Arora
