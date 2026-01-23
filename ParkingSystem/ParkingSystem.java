import java.util.Scanner;
public class ParkingSystem {
    void createPass(User user, Vehicle vehicle, int cost) { // To print the pass
        System.out.println("########################################");
        System.out.println("#           PARKING  PASS             #");
        System.out.println("########################################");
        System.out.printf("#  %-15s : %-18s #\n", "Name", user.name);
        System.out.printf("#  %-15s : %-18s #\n", "ID", user.userId);
        System.out.printf("#  %-15s : %-18s #\n", "Vehicle", vehicle.vehicleType);
        System.out.printf("#  %-15s : %-18s #\n", "Vehicle Number", vehicle.vehicleNumber);
        System.out.printf("#  %-15s : %-18d #\n", "Cost", (user.type.equals("faculty") ? 0 : cost));
        System.out.println("########################################");
    }

    void parkingSystem() {
        Scanner userInput = new Scanner(System.in);
        String name, userId, type, vehicleType, vehicleNumber;

        // Taking users inputs such as- Name, id, type, etc.
        System.out.print("Enter Your Name:");
        name = userInput.nextLine();
        System.out.print("Enter Your Id:");
        userId = userInput.nextLine();
        System.out.print("Enter Your Type(Student/Faculty):");
        type = userInput.nextLine();
        type = type.toLowerCase();


        // Creating a new user with these informations
        User user = new User();
        user = user.createUser(name, userId, type);

        // Taking details about vehicle
        System.out.print("Enter Vehicle Number:");
        vehicleNumber = userInput.nextLine();
        System.out.print("Enter Your VehicleType(Car/Bike/Cycle):");
        vehicleType = userInput.nextLine();
        vehicleType = vehicleType.toLowerCase();

        // Creating a new vehicle object
        Vehicle vehicle = new Vehicle();
        vehicle = vehicle.createVehicle(vehicleNumber, vehicleType, user);

        // Creating a new pass
        Pass pass = new Pass();
        int cost = pass.selectPass(vehicleType, userInput);
        this.createPass(user, vehicle, cost);
    }
}
