package parking_system;

import java.util.*;
public class Main {
    public static void main(String[] args) {
    
    Scanner UserInput = new Scanner(System.in);

    System.out.println(" ----- Welcome to CODEUP Parking System -----");

    System.out.print("Enter your name: ");
    String name = UserInput.nextLine();

    System.out.print("Enter your id: ");
    String id = UserInput.nextLine();

    System.out.println("Enter (ex. 1 or 2): ");
    System.out.println("1. Student: ");
    System.out.println("2. Faculty: ");

    User user;
    int uChoice = UserInput.nextInt();

    if(uChoice == 1) {
        user = new Student(name, id);
    } else {
        user = new Faculty(name, id);
    }

    UserInput.nextLine();

    System.out.print("Enter your Vehicle Number:");
    String vho = UserInput.nextLine();

    System.out.println("Enter (ex. 1/2/3) Type ");
    System.out.println("1. Bike");
    System.out.println("2. Car");
    System.out.println("3. Cycle");

    Vehicle vehicle;
    int vChoice = UserInput.nextInt();

    if(vChoice == 1) {
        vehicle = new Bike(vho);
    } else if(vChoice == 2) {
        vehicle = new Car(vho);
    } else {
        vehicle = new Cycle(vho);
    }

    String vehicleType = vehicle.getvehicleType();

    Pass daily = new DailyPass();
    Pass Weekly = new WeeklyPass();
    Pass monthly = new MonthlyPass();

    System.out.println("Select Pass Type: ");
    System.out.println("1. Daily -> Rs."+daily.getPrice(vehicleType));
    System.out.println("2. Weekly -> Rs."+Weekly.getPrice(vehicleType));
    System.out.println("3. Monthly -> Rs."+monthly.getPrice(vehicleType));

    int pChoice = UserInput.nextInt();

    Pass pass;

    if(pChoice == 1) {
        pass = new DailyPass();
    } else if (pChoice == 2) {
        pass = new WeeklyPass();
    } else {
        pass = new MonthlyPass();
    }

    double amount = pass.getPrice(vehicle.getvehicleType());

    double finalamount = user.calculateFinalamount(amount);


    System.out.println(" ---------- YOUR TICKET ----------- ");

    System.out.println("Name: "+user.name);

    System.out.println("Id: "+user.id);

    System.out.println("Type: "+user.getUserType());

    System.out.println("VehicleNumber: "+vehicle.getvehicleNumber());
    System.out.println("VehicleType: "+vehicle.getvehicleType());

    System.out.println("Pass Type: "+pass.getPassType());
    System.out.println("Orignal amount: "+amount);
    System.out.println("Final amount: "+user.calculateFinalamount(amount));

    System.out.println(" ---------- Thank you for visiting us ---------- ");
   
    }
}