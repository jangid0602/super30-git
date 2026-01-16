import java.util.Scanner;

public class Main {
    Scanner userInput;

    void createTicket(User user, Vehicle vehicle, int cost) {
        System.out.println("---------- Your Ticket ----------");
        System.out.println("Your Name: " + user.name);
        System.out.println("Your Id: " + user.id);
        System.out.println("Your Vehicle-Number: " + vehicle.vehicleNumber);
        System.out.println("Your Cost: " + (user.type.equals("faculty") ? 0 : cost));
        System.out.println("---------- Thank you for visiting us ----------);
    }
    void parkingSystem() {
        String name, Id, type, vehicleType, vehicleNumber;
        Input input = new Input();
        userInput = input.userInput();

        System.out.print("Enter Your Name:");
        name = userInput.nextLine();
        System.out.print("Enter Your Id:");
        Id = userInput.nextLine();
        System.out.print("Enter Your Type(Student/Faculty):");
        type = userInput.nextLine();
        type = type.toLowerCase();

        User user = new User(name, Id, type);
        user = user.createUser();

        System.out.print("Enter Vehicle Number:");
        vehicleNumber = userInput.nextLine();

        System.out.print("Enter Your VehicleType(Car/Bike/Cycle):");
        vehicleType = userInput.nextLine();
        vehicleType = vehicleType.toLowerCase();
        Vehicle vehicle = new Vehicle(vehicleNumber, vehicleType, user);
        vehicle = vehicle.createVehicle();

        Pass pass = new Pass(vehicleType);
        int cost = pass.selectPass();

        this.createTicket(user, vehicle, cost);
    }
    public static void main(String[] args) {
        System.out.println("Welcome To GIT:");
        Main main = new Main();
        main.parkingSystem();
    }

}
