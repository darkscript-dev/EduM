# EduM - Educational Management System

This is a Java Swing application for managing students, teachers, courses, and schedules.

For demonstration and testing purposes, the application uses the following default credentials:

*   Username: `admin`
*   Password: `admin`

---  ## Table of Contents

- [Software Requirements](#software-requirements)
- [Project Setup](#project-setup)
- [Database Setup](#database-setup)
- [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [Author](#author)

## Software Requirements

To build and run this application, you will need the following software:

- **Java Development Kit (JDK) 23:** Get it from [https://adoptium.net/](https://adoptium.net/).
- **NetBeans IDE:** (Or any IDE capable of building Java Swing applications).
- **MySQL Server:** (Version 8.0 or higher recommended).

## Project Setup

1. **Clone the Repository:**
   - Open a terminal or Git Bash.
   - Navigate to your desired project location.
   - Run: `git clone https://github.com/savindukeshara/EduM.git`

2. **Open in NetBeans:**
   - Open NetBeans.
   - "File" -> "Open Project..."
   - Select the `EduM` project folder.

3. **Add Libraries (if not automatically recognized):**
   - In NetBeans, right-click on the project -> "Properties" -> "Libraries".
   - If the libraries under "Compile-time Libraries" show errors (red icons), you may need to re-add them. The JAR files are located in the `lib` folder of the project. Use "Add JAR/Folder..." to add them.

## Database Setup

1. **Create Database:**
   - Open your MySQL client (MySQL Workbench, command-line, etc.).
   - Connect to your MySQL server.
   - Run: `CREATE DATABASE schooldb;`

2. **Import Schema:**
   - In your MySQL client, select the `schooldb` database.
   - Run the `schooldb.sql` script (located in the project root) to create the tables. In MySQL Workbench, open the file and click the Execute button. In the command line client, you can use `SOURCE /path/to/schooldb.sql;` (replace `/path/to/` with the actual path).

3. **Configure Connection:**
   - Open the `config.properties` file in the `project` package (`src/project/config.properties`).
   - Update the database connection details with *your* MySQL username and password.

## Running the Application

1. In NetBeans, right-click on the main application file (e.g., `main.java` in the `management` package).
2. Select "Run File."

## Application Backup

If you have any issues cloning the repository or setting up the project, you can download a pre-packaged version of the application from the following drive link:

[Download EduM Application (ZIP)](https://drive.google.com/drive/folders/1KhsluVZH5J4EK8l5DCCKq1IoGyAzba06?usp=sharing)

**Note:** This ZIP file contains all the necessary files, including the libraries and the database schema. Please refer to the instructions above for database setup and running the application.

## Author

savindu keshara
