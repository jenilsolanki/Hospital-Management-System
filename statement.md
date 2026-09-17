# Hospital Management System

## 1. Problem Statement

Managing hospital information manually can become difficult when the number of patients, doctors, appointments, rooms, medical records, and bills increases. Searching for information, updating records, managing appointments, and calculating bills manually can take time and may lead to errors.

The Hospital Management System is developed to provide a simple and organized way to manage these basic hospital activities through a Java-based console application.

The system allows users to manage patient and doctor information, book and manage appointments, maintain medical records, manage rooms, generate bills, and store basic staff information during program execution.

---

## 2. Scope of the Project

The project focuses on the basic management of hospital operations using Java.

The current scope includes:

* Adding, viewing, searching, updating, and deleting patient records.
* Adding and viewing doctor information.
* Booking, viewing, cancelling, and completing appointments.
* Maintaining basic medical records.
* Adding, assigning, viewing, and releasing hospital rooms.
* Generating and viewing patient bills.
* Adding and viewing staff information.
* Validating user inputs and handling invalid entries.
* Providing a simple menu-driven workflow for accessing different modules.

The application is currently designed as a console-based Java program. Data is maintained using Java ArrayList collections during program execution. A graphical interface and permanent database storage are outside the scope of the current version.

---

## 3. Target Users

The system is intended for:

* Hospital reception staff
* Hospital administrative staff
* Nurses and support staff
* Small healthcare facilities for basic record management
* Students learning Java programming and object-oriented programming concepts

The current version is primarily designed as an educational project demonstrating how Java programming concepts can be applied to a real-world hospital management problem.

---

## 4. High-Level Features

### Patient Management

* Add patient
* View patients
* Search patient
* Update patient
* Delete patient

### Doctor Management

* Add doctor
* View doctors
* Search doctor

### Appointment Management

* Book appointment
* View appointments
* Cancel appointment
* Complete appointment
* Prevent duplicate appointment IDs
* Prevent booking the same doctor on the same date

### Medical Records

* Add medical record
* View medical records
* View records by patient

### Room Management

* Add room
* View rooms
* Assign room
* Release room
* Track room availability

### Billing

* Generate bill
* View bills
* Search bill
* Calculate total charges automatically

### Staff Management

* Add staff
* View staff information

### Validation and Error Handling

* Validate menu choices
* Validate numerical input
* Validate phone numbers
* Validate age
* Validate charges
* Validate appointment dates
* Handle invalid input without terminating the program
