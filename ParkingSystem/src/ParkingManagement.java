/*
Project :- Parking Management System
Task perform :-
   1. Generate Ticket
   2. Search Ticket
   3. Delete Ticket

Author Name :- Abhay
Date :- 19/01/2026
 */

import java.util.HashMap;
import java.util.Scanner;
public class ParkingManagement {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        HashMap<String, Ticket> userData = new HashMap<>();
        while (true) {
            System.out.println("=== Parking Management System ===");
            String parkingSystem = """
                    { ------------ Operation Menu ---------------}
                    1 -> Generated Ticket
                    2 -> Search Ticket
                    3 -> Delete Ticket
                    4 -> Exit
                    """;

            int choice;
            while (true) {
                System.out.println(parkingSystem);
                System.out.print("Enter a value according to menu: ");
                String value = userInput.nextLine().trim();
                try {
                    choice = Integer.parseInt(value);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
            if (choice == 4) {
                System.out.println("Thank you, Have a Nice Day ");
                break;
            }
            switch (choice) {
                case 1 -> {
                    String userType;
                    while (true) {
                        System.out.print("Enter User Type (Student/Faculty) : ");
                        userType = userInput.nextLine().trim();
                        try {
                            if (userType.equals("Student") || userType.equals("Faculty")) break;
                            else System.out.println("Invalid, (Exact : (Student/Faculty)");

                        } catch (Error e) {
                            System.out.println("Invalid");
                        }
                    }

                    String userName;
                    while (true) {
                        System.out.print("Enter User Name : ");
                        userName = userInput.nextLine().trim();
                        if (userName.length() > 2 ) break;
                        else System.out.println("Invalid :- ".concat(userName));
                    }

                    String vehicleType;
                    while (true) {
                        System.out.print("Enter Vehicle Type (Two Wheeler/Four Wheeler) : ");
                        vehicleType = userInput.nextLine().trim();
                        if (vehicleType.equals("Two Wheeler") || vehicleType.equals("Four Wheeler")) break;
                        else System.out.println("Invalid : ".concat(vehicleType).concat(", Exact : (Two Wheeler/Four Wheeler"));
                    }

                    String vehicleNumber;
                    while (true) {
                        System.out.print("Enter Vehicle Number (like :- RJ02AB2309): ");
                        vehicleNumber = userInput.nextLine().trim().toUpperCase();
                        if (vehicleNumber.length() == 10 && !userData.containsKey(vehicleNumber)) break;
                        else System.out.println("Invalid Vehicle Number ".concat(vehicleNumber));
                    }
                    String duration;
                    while (true) {
                        System.out.print("Enter Pass Duration (1 Day/1 Week/1 Month) : ");
                        duration = userInput.nextLine().trim();
                        if (duration.equals("1 Day") || duration.equals("1 Week") || duration.equals("1 Month"))
                            break;
                        else System.out.println("Invalid : ".concat(duration).concat(",  Exact : (1 Day/1 Week/1 Month)"));
                    }

                    User user;
                    if (userType.equals("Student")) {
                        user = new Student(userName);
                    } else {
                        user = new Faculty(userName);
                    }
                    Vehicle vehicle = new Vehicle(vehicleNumber, vehicleType);
                    double fee = user.calculateFee(vehicleType, duration);
                    ParkingPass parkingPass = new ParkingPass(duration, fee);
                    userData.put(vehicleNumber, new Ticket(parkingPass, user, vehicle));
                    System.out.println("\n🫱🏻‍🫲🏼Ticket Generated Successfully 🫱🏻‍🫲\n");

                }

                case 2 -> {
                    System.out.print("Enter Vehicle Number to Find your vehicle details : ");
                    String vehicleNumber = userInput.nextLine();
                    if (userData.containsKey(vehicleNumber)) {
                        Ticket ticket = userData.get(vehicleNumber);
                        ticket.generateTicketDetails();
                        System.out.println("\n🫱🏻‍🫲🏼Ticket Search Successfully 🫱🏻‍🫲\n");
                    } else {
                        System.out.println("No Ticket Found");
                    }
                }

                case 3 -> {
                    System.out.print("Enter Vehicle Number to Delete your vehicle details : ");
                    String vehicleNumber = userInput.nextLine();
                    if (userData.containsKey(vehicleNumber)) {
                        userData.remove(vehicleNumber);
                        System.out.println("\n🫱🏻‍🫲🏼Ticket Delete Successfully 🫱🏻‍🫲\n");

                    } else {
                        System.out.println("No Ticket Found");
                    }
                }

                default -> System.out.println("Invalid operation");
            }
        }
    }
}
