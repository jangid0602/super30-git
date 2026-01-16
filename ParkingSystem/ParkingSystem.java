import java.util.Scanner;

public class ParkingSystem {
    Scanner userInput;
    void createTicket(User user, Vehicle vehicle, int cost) {
        System.out.println("########################################");
        System.out.println("#           PARKING  TICKET             #");
        System.out.println("########################################");

        System.out.printf("#  %-15s : %-18s #\n", "Name", user.name);
        System.out.printf("#  %-15s : %-18s #\n", "ID", user.Id);
        System.out.printf("#  %-15s : %-18s #\n", "Vehicle Number", vehicle.vehicleNumber);
        System.out.printf("#  %-15s : %-18d #\n", "Cost", (user.type.equals("faculty") ? 0 : cost));

        System.out.println("########################################");
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

        User user = new User();
        user = user.createUser(name, Id, type);

        System.out.print("Enter Vehicle Number:");
        vehicleNumber = userInput.nextLine();

        System.out.print("Enter Your VehicleType(Car/Bike/Cycle):");
        vehicleType = userInput.nextLine();
        vehicleType = vehicleType.toLowerCase();
        Vehicle vehicle = new Vehicle();
        vehicle = vehicle.createVehicle(vehicleNumber, vehicleType, user);

        Pass pass = new Pass();
        int cost = pass.selectPass(vehicleType);
        this.createTicket(user, vehicle, cost);
    }
}
