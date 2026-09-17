# Hospital Management System

### 1. Project Overview

Welcome to the Hospital Management System! This is a Java-based console application designed to manage common hospital activities in a simple and organized way.

Instead of handling patient details, doctor information, appointments, medical records, rooms, billing, and staff information manually, this system provides a structured menu-based workflow where users can add, search, update, view, and manage hospital records.

The project is designed as a simple Java application suitable for managing the basic operations of a hospital.

### 2. Key Features

This project is built with different classes and menu-based functions to handle specific tasks:

* **Patient Management:** Add, view, search, update, and delete patient information such as patient ID, name, age, gender, phone number, and address.

* **Doctor Management:** Add and view doctor details including specialization, phone number, availability, and consultation fee.

* **Appointment Management:** Book, view, cancel, and complete appointments by selecting a patient, doctor, and appointment date.

* **Appointment Validation:** The system prevents duplicate appointment IDs and does not allow the same doctor to be booked for two appointments on the same date.

* **Medical Records:** Store and view patient medical records including diagnosis, prescription, and remarks.

* **Room Management:** Add hospital rooms, view room availability, assign rooms, and release rooms when they are no longer occupied.

* **Billing:** Generate and view patient bills by calculating consultation, room, medicine, and test charges.

* **Staff Management:** Add and view hospital staff information such as staff ID, name, role, department, and phone number.

* **Input Validation:** The system checks user input such as numbers, age, phone numbers, charges, and dates to reduce invalid entries.

* **Error Handling:** Invalid inputs are handled without stopping the program, and the user is asked to enter valid information.

### 3. Technologies Used

* **Language:** Java

* **Libraries:** Java Standard Library

* **Concepts:** Classes and Objects, ArrayList, Methods, Encapsulation, Conditional Statements, Loops, Exception Handling, Input Validation, and Date Handling.

* **Input:** Scanner class for taking user input.

* **Date Handling:** LocalDate and DateTimeFormatter for appointment dates.

The project does not require any external programming language, database, framework, or third-party library.

### 4. How to Install & Run

Follow these simple steps to get the project running on your local machine:

1. **Prerequisites:** Make sure Java is installed on your computer. You can check by typing:

```text
java --version
```

2. **Download:** Clone this repository or download the `HospitalManagementSystem.java` file.

3. **Open Terminal:** Navigate to the folder containing the Java file.

4. **Compile the Program:**

```text
javac HospitalManagementSystem.java
```

5. **Run the Program:**

```text
java HospitalManagementSystem
```

6. **Interact:** Follow the on-screen menu instructions to manage patients, doctors, appointments, medical records, rooms, billing, and staff.

### 5. How to Test (Walkthrough)

To verify that the system is working as expected, try these scenarios:

* **Test 1: Adding a Patient**

  * Start the program.
  * Select **Patient Management**.
  * Select **Add Patient**.
  * Enter valid patient details.
  * Result: The system should display a successful patient addition message.

* **Test 2: Searching for a Patient**

  * Add a patient with a specific patient ID.
  * Select **Search Patient**.
  * Enter the patient ID.
  * Result: The system should display the patient's details.

* **Test 3: Booking an Appointment**

  * Add a patient and doctor first.
  * Select **Appointment Management**.
  * Choose **Book Appointment**.
  * Enter the patient ID, doctor ID, and a valid date.
  * Result: The appointment should be created successfully.

* **Test 4: Duplicate Appointment Prevention**

  * Try to create another appointment using the same appointment ID.
  * Result: The system should reject the duplicate appointment ID.

* **Test 5: Doctor Availability**

  * Book an appointment for a doctor on a particular date.
  * Try to book the same doctor again on the same date.
  * Result: The system should prevent the duplicate booking.

* **Test 6: Room Management**

  * Add a hospital room.
  * Select **Assign Room**.
  * Enter the room number.
  * Result: The room status should change from available to occupied.

* **Test 7: Billing**

  * Select **Billing**.
  * Enter consultation, room, medicine, and test charges.
  * Result: The system should calculate and display the total bill correctly.

* **Test 8: Input Safety**

  * When asked for a menu option, enter an invalid value such as a letter instead of a number.
  * Result: The program should handle the invalid input and ask for a valid value instead of crashing.

### 6. Future Enhancements

Currently, this system runs as a console-based Java application. In the future, it can be expanded by:

* Connecting the system to a database such as MySQL to save hospital records permanently.
* Adding a login system for administrators, doctors, and staff.
* Creating a graphical user interface (GUI).
* Adding medicine and laboratory management.
* Adding automatic bill generation and printing.
* Adding patient discharge management.
* Adding backup and data recovery features.

## About

It is a Java-based Hospital Management System designed to manage basic hospital operations through a simple console interface.

The system allows users to manage patient details, doctors, appointments, medical records, rooms, billing, and staff information using a structured menu-driven workflow.

The project was developed using Java and standard Java libraries, with a focus on basic programming concepts, classes and objects, collections, input validation, and exception handling.
# Hospital-Management-System
A Java-based console Hospital Management System for managing patients, doctors, appointments, medical records, rooms, billing, and staff. It uses core Java concepts such as classes, objects, ArrayList, input validation, exception handling, and date handling to provide a simple and organized hospital workflow.
