import java.util.Scanner;

public class Vehicle {
    String vehicleNumber, vehicleType;
    User user;
    Scanner userInput;
    Vehicle() {
        // loading scanner
        Input input = new Input();
        userInput = input.userInput();
    }

    Vehicle createVehicle(String vehicleNumber, String vehicleType, User user) {
        if(vehicleType.equals("car")) {
            return new Car(vehicleNumber, vehicleType, user);
        } else if(vehicleType.equals("bike")) {
            return new Bike(vehicleNumber, vehicleType, user);
        } else {
            return new Cycle(vehicleNumber, vehicleType, user);
        }
    }
};

class Car extends Vehicle {
    Car(String vehicleNumber, String vehicleType, User user) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.user = user;
    }
};

class Bike extends Vehicle {
    Bike(String vehicleNumber, String vehicleType, User user) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.user = user;
    }
};

class Cycle extends Vehicle {
    Cycle(String vehicleNumber, String vehicleType, User user) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.user = user;
    }
};