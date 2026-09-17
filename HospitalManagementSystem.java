import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class HospitalManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static ArrayList<MedicalRecord> records = new ArrayList<>();
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Bill> bills = new ArrayList<>();
    static ArrayList<Staff> staffMembers = new ArrayList<>();

    static DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("       WELCOME TO HOSPITAL MANAGEMENT");
        System.out.println("==============================================");

        while (true) {

            displayMainMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    patientManagement();
                    break;

                case 2:
                    doctorManagement();
                    break;

                case 3:
                    appointmentManagement();
                    break;

                case 4:
                    medicalRecordManagement();
                    break;

                case 5:
                    roomManagement();
                    break;

                case 6:
                    billingManagement();
                    break;

                case 7:
                    staffManagement();
                    break;

                case 8:
                    System.out.println("\nThank you for using Hospital Management System!");
                    System.out.println("Program ended successfully.");
                    return;

                default:
                    System.out.println("Invalid choice! Please select from 1 to 8.");
            }
        }
    }

    static void displayMainMenu() {

        System.out.println("\n==============================================");
        System.out.println("           HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("1. Patient Management");
        System.out.println("2. Doctor Management");
        System.out.println("3. Appointment Management");
        System.out.println("4. Medical Records");
        System.out.println("5. Room Management");
        System.out.println("6. Billing");
        System.out.println("7. Staff Management");
        System.out.println("8. Exit");
        System.out.println("==============================================");
    }

    static void patientManagement() {

        while (true) {

            System.out.println("\n----------------------------------------------");
            System.out.println("             PATIENT MANAGEMENT");
            System.out.println("----------------------------------------------");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Back to Main Menu");
            System.out.println("----------------------------------------------");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    searchPatient();
                    break;

                case 4:
                    updatePatient();
                    break;

                case 5:
                    deletePatient();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addPatient() {

        System.out.println("\n--- Add New Patient ---");

        String id = readString("Enter Patient ID: ");

        if (findPatient(id) != null) {
            System.out.println("Patient ID already exists!");
            return;
        }

        String name = readString("Enter Patient Name: ");
        int age = readIntRange("Enter Age: ", 1, 120);
        String gender = readString("Enter Gender: ");
        String phone = readPhone();
        String address = readString("Enter Address: ");

        Patient patient = new Patient(
                id, name, age, gender, phone, address
        );

        patients.add(patient);

        System.out.println("\nPatient added successfully!");
    }

    static void viewPatients() {

        System.out.println("\n--- Patient List ---");

        if (patients.size() == 0) {
            System.out.println("No patients registered.");
            return;
        }

        for (Patient p : patients) {
            p.display();
        }
    }

    static void searchPatient() {

        String id = readString("Enter Patient ID to search: ");

        Patient patient = findPatient(id);

        if (patient == null) {
            System.out.println("Patient not found!");
        } else {
            System.out.println("\nPatient found:");
            patient.display();
        }
    }

    static void updatePatient() {

        String id = readString("Enter Patient ID to update: ");

        Patient patient = findPatient(id);

        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.println("\nEnter new details:");

        patient.name = readString("Enter Name: ");
        patient.age = readIntRange("Enter Age: ", 1, 120);
        patient.phone = readPhone();
        patient.address = readString("Enter Address: ");

        System.out.println("Patient information updated successfully!");
    }

    static void deletePatient() {

        String id = readString("Enter Patient ID to delete: ");

        Patient patient = findPatient(id);

        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        patients.remove(patient);

        System.out.println("Patient deleted successfully.");
    }

    static Patient findPatient(String id) {

        for (Patient p : patients) {

            if (p.id.equalsIgnoreCase(id)) {
                return p;
            }
        }

        return null;
    }

    static void doctorManagement() {

        while (true) {

            System.out.println("\n----------------------------------------------");
            System.out.println("              DOCTOR MANAGEMENT");
            System.out.println("----------------------------------------------");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Search Doctor");
            System.out.println("4. Back to Main Menu");
            System.out.println("----------------------------------------------");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addDoctor();
                    break;

                case 2:
                    viewDoctors();
                    break;

                case 3:
                    searchDoctor();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addDoctor() {

        System.out.println("\n--- Add New Doctor ---");

        String id = readString("Enter Doctor ID: ");

        if (findDoctor(id) != null) {
            System.out.println("Doctor ID already exists!");
            return;
        }

        String name = readString("Enter Doctor Name: ");
        String specialization = readString("Enter Specialization: ");
        String phone = readPhone();
        String availability = readString("Enter Availability: ");
        double fee = readPositiveDouble("Enter Consultation Fee: ");

        Doctor doctor = new Doctor(
                id, name, specialization,
                phone, availability, fee
        );

        doctors.add(doctor);

        System.out.println("Doctor added successfully!");
    }

    static void viewDoctors() {

        System.out.println("\n--- Doctor List ---");

        if (doctors.size() == 0) {
            System.out.println("No doctors registered.");
            return;
        }

        for (Doctor d : doctors) {
            d.display();
        }
    }

    static void searchDoctor() {

        String id = readString("Enter Doctor ID to search: ");

        Doctor doctor = findDoctor(id);

        if (doctor == null) {
            System.out.println("Doctor not found!");
        } else {
            doctor.display();
        }
    }

    static Doctor findDoctor(String id) {

        for (Doctor d : doctors) {

            if (d.id.equalsIgnoreCase(id)) {
                return d;
            }
        }

        return null;
    }

    static void appointmentManagement() {

        while (true) {

            System.out.println("\n----------------------------------------------");
            System.out.println("           APPOINTMENT MANAGEMENT");
            System.out.println("----------------------------------------------");
            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Complete Appointment");
            System.out.println("5. Back to Main Menu");
            System.out.println("----------------------------------------------");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    bookAppointment();
                    break;

                case 2:
                    viewAppointments();
                    break;

                case 3:
                    cancelAppointment();
                    break;

                case 4:
                    completeAppointment();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void bookAppointment() {

        System.out.println("\n--- Book Appointment ---");

        String appointmentId =
                readString("Enter Appointment ID: ");

        if (findAppointment(appointmentId) != null) {
            System.out.println("Appointment ID already exists!");
            return;
        }

        String patientId =
                readString("Enter Patient ID: ");

        if (findPatient(patientId) == null) {
            System.out.println("Patient not found!");
            return;
        }

        String doctorId =
                readString("Enter Doctor ID: ");

        if (findDoctor(doctorId) == null) {
            System.out.println("Doctor not found!");
            return;
        }

        LocalDate date = readDate();

        for (Appointment a : appointments) {

            if (a.doctorId.equalsIgnoreCase(doctorId)
                    && a.date.equals(date)
                    && a.status.equals("Booked")) {

                System.out.println(
                        "Doctor already has an appointment on this date!"
                );

                return;
            }
        }

        Appointment appointment = new Appointment(
                appointmentId,
                patientId,
                doctorId,
                date
        );

        appointments.add(appointment);

        System.out.println("Appointment booked successfully!");
    }

    static void viewAppointments() {

        System.out.println("\n--- Appointment List ---");

        if (appointments.size() == 0) {
            System.out.println("No appointments available.");
            return;
        }

        for (Appointment a : appointments) {
            a.display();
        }
    }

    static void cancelAppointment() {

        String id =
                readString("Enter Appointment ID: ");

        Appointment appointment = findAppointment(id);

        if (appointment == null) {
            System.out.println("Appointment not found!");
            return;
        }

        if (!appointment.status.equals("Booked")) {
            System.out.println("This appointment is already "
                    + appointment.status.toLowerCase() + ".");
            return;
        }

        appointment.status = "Cancelled";

        System.out.println("Appointment cancelled successfully.");
    }

    static void completeAppointment() {

        String id =
                readString("Enter Appointment ID: ");

        Appointment appointment = findAppointment(id);

        if (appointment == null) {
            System.out.println("Appointment not found!");
            return;
        }

        if (!appointment.status.equals("Booked")) {
            System.out.println("Appointment cannot be completed.");
            return;
        }

        appointment.status = "Completed";

        System.out.println("Appointment marked as completed.");
    }

    static Appointment findAppointment(String id) {

        for (Appointment a : appointments) {

            if (a.id.equalsIgnoreCase(id)) {
                return a;
            }
        }

        return null;
    }

    static void medicalRecordManagement() {

        while (true) {

            System.out.println("\n----------------------------------------------");
            System.out.println("             MEDICAL RECORDS");
            System.out.println("----------------------------------------------");
            System.out.println("1. Add Medical Record");
            System.out.println("2. View All Records");
            System.out.println("3. View Patient Records");
            System.out.println("4. Back to Main Menu");
            System.out.println("----------------------------------------------");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addMedicalRecord();
                    break;

                case 2:
                    viewRecords();
                    break;

                case 3:
                    viewPatientRecords();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addMedicalRecord() {

        System.out.println("\n--- Add Medical Record ---");

        String recordId =
                readString("Enter Record ID: ");

        if (findRecord(recordId) != null) {
            System.out.println("Record ID already exists!");
            return;
        }

        String patientId =
                readString("Enter Patient ID: ");

        if (findPatient(patientId) == null) {
            System.out.println("Patient not found!");
            return;
        }

        String doctorId =
                readString("Enter Doctor ID: ");

        if (findDoctor(doctorId) == null) {
            System.out.println("Doctor not found!");
            return;
        }

        String diagnosis =
                readString("Enter Diagnosis: ");

        String prescription =
                readString("Enter Prescription: ");

        String remarks =
                readString("Enter Remarks: ");

        MedicalRecord record = new MedicalRecord(
                recordId,
                patientId,
                doctorId,
                diagnosis,
                prescription,
                remarks
        );

        records.add(record);

        System.out.println("Medical record added successfully!");
    }

    static void viewRecords() {

        System.out.println("\n--- Medical Records ---");

        if (records.size() == 0) {
            System.out.println("No medical records available.");
            return;
        }

        for (MedicalRecord r : records) {
            r.display();
        }
    }

    static void viewPatientRecords() {

        String patientId =
                readString("Enter Patient ID: ");

        boolean found = false;

        for (MedicalRecord r : records) {

            if (r.patientId.equalsIgnoreCase(patientId)) {

                r.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No records found for this patient.");
        }
    }

    static MedicalRecord findRecord(String id) {

        for (MedicalRecord r : records) {

            if (r.id.equalsIgnoreCase(id)) {
                return r;
            }
        }

        return null;
    }

    static void roomManagement() {

        while (true) {

            System.out.println("\n----------------------------------------------");
            System.out.println("              ROOM MANAGEMENT");
            System.out.println("----------------------------------------------");
            System.out.println("1. Add Room");
            System.out.println("2. View Rooms");
            System.out.println("3. Assign Room");
            System.out.println("4. Release Room");
            System.out.println("5. Back to Main Menu");
            System.out.println("----------------------------------------------");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addRoom();
                    break;

                case 2:
                    viewRooms();
                    break;

                case 3:
                    assignRoom();
                    break;

                case 4:
                    releaseRoom();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addRoom() {

        System.out.println("\n--- Add Room ---");

        int number =
                readInt("Enter Room Number: ");

        if (findRoom(number) != null) {
            System.out.println("Room already exists!");
            return;
        }

        String type =
                readString("Enter Room Type: ");

        double charge =
                readPositiveDouble("Enter Daily Charge: ");

        Room room = new Room(number, type, charge);

        rooms.add(room);

        System.out.println("Room added successfully!");
    }

    static void viewRooms() {

        System.out.println("\n--- Room List ---");

        if (rooms.size() == 0) {
            System.out.println("No rooms available.");
            return;
        }

        for (Room r : rooms) {
            r.display();
        }
    }

    static void assignRoom() {

        int number =
                readInt("Enter Room Number: ");

        Room room = findRoom(number);

        if (room == null) {
            System.out.println("Room not found!");
            return;
        }

        if (room.occupied) {
            System.out.println("Room is already occupied!");
            return;
        }

        String patientId =
                readString("Enter Patient ID: ");

        if (findPatient(patientId) == null) {
            System.out.println("Patient not found!");
            return;
        }

        room.occupied = true;
        room.patientId = patientId;

        System.out.println("Room assigned successfully!");
    }

    static void releaseRoom() {

        int number =
                readInt("Enter Room Number: ");

        Room room = findRoom(number);

        if (room == null) {
            System.out.println("Room not found!");
            return;
        }

        if (!room.occupied) {
            System.out.println("Room is already available.");
            return;
        }

        room.occupied = false;
        room.patientId = "";

        System.out.println("Room released successfully!");
    }

    static Room findRoom(int number) {

        for (Room r : rooms) {

            if (r.number == number) {
                return r;
            }
        }

        return null;
    }

    static void billingManagement() {

        while (true) {

            System.out.println("\n----------------------------------------------");
            System.out.println("                 BILLING");
            System.out.println("----------------------------------------------");
            System.out.println("1. Generate Bill");
            System.out.println("2. View All Bills");
            System.out.println("3. Search Bill");
            System.out.println("4. Back to Main Menu");
            System.out.println("----------------------------------------------");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    generateBill();
                    break;

                case 2:
                    viewBills();
                    break;

                case 3:
                    searchBill();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void generateBill() {

        System.out.println("\n--- Generate Bill ---");

        String billId =
                readString("Enter Bill ID: ");

        if (findBill(billId) != null) {
            System.out.println("Bill ID already exists!");
            return;
        }

        String patientId =
                readString("Enter Patient ID: ");

        if (findPatient(patientId) == null) {
            System.out.println("Patient not found!");
            return;
        }

        double consultation =
                readPositiveDouble("Consultation Charge: ");

        double room =
                readPositiveDouble("Room Charge: ");

        double medicine =
                readPositiveDouble("Medicine Charge: ");

        double tests =
                readPositiveDouble("Test Charge: ");

        double total =
                consultation + room + medicine + tests;

        Bill bill = new Bill(
                billId,
                patientId,
                consultation,
                room,
                medicine,
                tests,
                total
        );

        bills.add(bill);

        System.out.println("\nBill generated successfully!");
        System.out.println("Total Amount: Rs. " + total);
    }

    static void viewBills() {

        System.out.println("\n--- Bill List ---");

        if (bills.size() == 0) {
            System.out.println("No bills available.");
            return;
        }

        for (Bill b : bills) {
            b.display();
        }
    }

    static void searchBill() {

        String id =
                readString("Enter Bill ID: ");

        Bill bill = findBill(id);

        if (bill == null) {
            System.out.println("Bill not found!");
        } else {
            bill.display();
        }
    }

    static Bill findBill(String id) {

        for (Bill b : bills) {

            if (b.id.equalsIgnoreCase(id)) {
                return b;
            }
        }

        return null;
    }

    static void staffManagement() {

        while (true) {

            System.out.println("\n----------------------------------------------");
            System.out.println("             STAFF MANAGEMENT");
            System.out.println("----------------------------------------------");
            System.out.println("1. Add Staff");
            System.out.println("2. View Staff");
            System.out.println("3. Back to Main Menu");
            System.out.println("----------------------------------------------");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStaff();
                    break;

                case 2:
                    viewStaff();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addStaff() {

        System.out.println("\n--- Add Staff ---");

        String id =
                readString("Enter Staff ID: ");

        if (findStaff(id) != null) {
            System.out.println("Staff ID already exists!");
            return;
        }

        String name =
                readString("Enter Staff Name: ");

        String role =
                readString("Enter Role: ");

        String department =
                readString("Enter Department: ");

        String phone =
                readPhone();

        Staff staff = new Staff(
                id,
                name,
                role,
                department,
                phone
        );

        staffMembers.add(staff);

        System.out.println("Staff added successfully!");
    }

    static void viewStaff() {

        System.out.println("\n--- Staff List ---");

        if (staffMembers.size() == 0) {
            System.out.println("No staff members available.");
            return;
        }

        for (Staff s : staffMembers) {
            s.display();
        }
    }

    static Staff findStaff(String id) {

        for (Staff s : staffMembers) {

            if (s.id.equalsIgnoreCase(id)) {
                return s;
            }
        }

        return null;
    }

    static String readString(String message) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty!");
        }
    }

    static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        sc.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a number."
                );
            }
        }
    }

    static int readIntRange(
            String message,
            int min,
            int max) {

        while (true) {

            int value = readInt(message);

            if (value >= min && value <= max) {
                return value;
            }

            System.out.println(
                    "Please enter a value between "
                            + min + " and " + max + "."
            );
        }
    }

    static double readPositiveDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                double value =
                        Double.parseDouble(
                                sc.nextLine().trim()
                        );

                if (value >= 0) {
                    return value;
                }

                System.out.println(
                        "Amount cannot be negative!"
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid amount! Please enter a number."
                );
            }
        }
    }

    static String readPhone() {

        while (true) {

            String phone =
                    readString("Enter Phone Number (10 digits): ");

            if (phone.matches("\\d{10}")) {
                return phone;
            }

            System.out.println(
                    "Invalid phone number! Enter exactly 10 digits."
            );
        }
    }

    static LocalDate readDate() {

        while (true) {

            try {

                String input =
                        readString(
                                "Enter Date (dd-MM-yyyy): "
                        );

                LocalDate date =
                        LocalDate.parse(
                                input,
                                dateFormatter
                        );

                if (date.isBefore(LocalDate.now())) {

                    System.out.println(
                            "Appointment date cannot be in the past!"
                    );

                } else {

                    return date;
                }

            } catch (DateTimeParseException e) {

                System.out.println(
                        "Invalid date format!"
                );

                System.out.println(
                        "Example: 25-09-2026"
                );
            }
        }
    }
}

class Patient {

    String id;
    String name;
    int age;
    String gender;
    String phone;
    String address;

    Patient(String id, String name, int age,
            String gender, String phone, String address) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    void display() {

        System.out.println("\n--------------------------------");
        System.out.println("Patient ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Gender     : " + gender);
        System.out.println("Phone      : " + phone);
        System.out.println("Address    : " + address);
        System.out.println("--------------------------------");
    }
}

class Doctor {

    String id;
    String name;
    String specialization;
    String phone;
    String availability;
    double fee;

    Doctor(String id, String name,
           String specialization, String phone,
           String availability, double fee) {

        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
        this.availability = availability;
        this.fee = fee;
    }

    void display() {

        System.out.println("\n--------------------------------");
        System.out.println("Doctor ID      : " + id);
        System.out.println("Name           : " + name);
        System.out.println("Specialization : " + specialization);
        System.out.println("Phone          : " + phone);
        System.out.println("Availability   : " + availability);
        System.out.println("Consultation   : Rs. " + fee);
        System.out.println("--------------------------------");
    }
}

class Appointment {

    String id;
    String patientId;
    String doctorId;
    LocalDate date;
    String status;

    Appointment(String id, String patientId,
                String doctorId, LocalDate date) {

        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.status = "Booked";
    }

    void display() {

        System.out.println("\n--------------------------------");
        System.out.println("Appointment ID : " + id);
        System.out.println("Patient ID     : " + patientId);
        System.out.println("Doctor ID      : " + doctorId);
        System.out.println("Date           : " + date);
        System.out.println("Status         : " + status);
        System.out.println("--------------------------------");
    }
}

class MedicalRecord {

    String id;
    String patientId;
    String doctorId;
    String diagnosis;
    String prescription;
    String remarks;

    MedicalRecord(String id, String patientId,
                  String doctorId, String diagnosis,
                  String prescription, String remarks) {

        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.remarks = remarks;
    }

    void display() {

        System.out.println("\n--------------------------------");
        System.out.println("Record ID    : " + id);
        System.out.println("Patient ID   : " + patientId);
        System.out.println("Doctor ID    : " + doctorId);
        System.out.println("Diagnosis    : " + diagnosis);
        System.out.println("Prescription : " + prescription);
        System.out.println("Remarks      : " + remarks);
        System.out.println("--------------------------------");
    }
}

class Room {

    int number;
    String type;
    double charge;
    boolean occupied;
    String patientId;

    Room(int number, String type, double charge) {

        this.number = number;
        this.type = type;
        this.charge = charge;
        this.occupied = false;
        this.patientId = "";
    }

    void display() {

        System.out.println("\n--------------------------------");
        System.out.println("Room Number : " + number);
        System.out.println("Room Type   : " + type);
        System.out.println("Daily Charge: Rs. " + charge);

        if (occupied) {

            System.out.println("Status      : Occupied");
            System.out.println("Patient ID  : " + patientId);

        } else {

            System.out.println("Status      : Available");
        }

        System.out.println("--------------------------------");
    }
}

class Bill {

    String id;
    String patientId;

    double consultation;
    double room;
    double medicine;
    double tests;
    double total;

    Bill(String id, String patientId,
         double consultation, double room,
         double medicine, double tests,
         double total) {

        this.id = id;
        this.patientId = patientId;
        this.consultation = consultation;
        this.room = room;
        this.medicine = medicine;
        this.tests = tests;
        this.total = total;
    }

    void display() {

        System.out.println("\n--------------------------------");
        System.out.println("Bill ID             : " + id);
        System.out.println("Patient ID          : " + patientId);
        System.out.println("Consultation Charge : Rs. " + consultation);
        System.out.println("Room Charge         : Rs. " + room);
        System.out.println("Medicine Charge     : Rs. " + medicine);
        System.out.println("Test Charge         : Rs. " + tests);
        System.out.println("--------------------------------");
        System.out.println("TOTAL               : Rs. " + total);
        System.out.println("--------------------------------");
    }
}

class Staff {

    String id;
    String name;
    String role;
    String department;
    String phone;

    Staff(String id, String name,
          String role, String department,
          String phone) {

        this.id = id;
        this.name = name;
        this.role = role;
        this.department = department;
        this.phone = phone;
    }

    void display() {

        System.out.println("\n--------------------------------");
        System.out.println("Staff ID    : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Role        : " + role);
        System.out.println("Department  : " + department);
        System.out.println("Phone       : " + phone);
        System.out.println("--------------------------------");
    }
}
