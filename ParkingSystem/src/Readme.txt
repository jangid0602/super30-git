

🚗 Parking Management System (Mini Project)
📌 Project Overview

The Parking Management System is a console-based Java mini project designed to manage vehicle parking records for students and faculty members.
The system allows users to generate parking tickets, search for existing tickets, and delete tickets using vehicle numbers as unique identifiers.

This project demonstrates the use of Object-Oriented Programming (OOP) concepts such as inheritance, abstraction, polymorphism, and collections in Java.

🎯 Features

 -> Accepts user input for parking details
 -> Supports Student and Faculty user types
 -> Generates unique Ticket ID and User ID
 -> Stores parking data using HashMap
 -> Allows searching and deleting tickets
 -> Uses Date API to format date and time
 -> Supports different parking durations

🧑‍💼 User Input Details

The system collects the following details from the user:

    Username
    User Type (Student / Faculty)
    Vehicle Number (Unique key)
    Vehicle Type
    Two Wheeler
    Four Wheeler

    Parking Duration
    1 Day
    1 Week
    1 Month

🧱 Project Structure (Classes Used)
1️⃣ ParkingManagement (Main Class)

    Entry point of the application
    Takes user input
    Displays menu options
    Uses HashMap to store parking records

    Key: Vehicle Number
    Value: Ticket Object
    Handles operations:
    Generate Ticket
    Search Ticket
    Delete Ticket

2️⃣ User (Abstract Class)

    Common properties for all users
    Abstract class for code reusability
    Base class for:
    Student
    Faculty

3️⃣ Student Class

    Extends User
    Generates Student-specific User ID
     Stores student parking details

4️⃣ Faculty Class

    Extends User
    Generates Faculty-specific User ID
    Stores faculty parking details

5️⃣ Vehicle Class

    Stores vehicle-related information:
    Vehicle Number
    Vehicle Type

🧠 Core Concepts Used

    Object-Oriented Programming (OOP)

    Abstraction
    Inheritance
    Polymorphism
    Java Collections (HashMap)
    Date and Time API
    User Input Handling

String Formatting

🛠 Operations Supported
        Option	Operation
    1	Generate Parking Ticket
    2	Search Ticket
    3	Delete Ticket
    4	Exit

Ticket ID is generated automatically using date and random values

    User ID is generated based on user type:
    STU-XXXX for Students
    FAC-XXXX for Faculty

🗓 Date Handling

    Uses Java Date and SimpleDateFormat
    Formats date into readable string format
    Stores parking entry date and duration

🧪 Sample Workflow

    User selects Generate Ticket
    Enters personal and vehicle details
    System generates Ticket ID and User ID
    Data is stored in HashMap
    User can search or delete ticket using vehicle number

🖥️ Technology Used

    Language: Java
    Concepts: OOP, Collections, Date Package
    IDE: Any Java IDE (IntelliJ)

📚 Conclusion

    This Parking Management System mini project is a practical implementation of Java fundamentals and object-oriented programming concepts. It efficiently manages parking records and demonstrates real-world use of data structures and class design.