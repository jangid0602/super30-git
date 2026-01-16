import java.util.Scanner;

public class Vehicle {
    String vehicleNumber, vehicleType;
    User user;
    Scanner userInput;
    Vehicle(String vehicleNumber, String vehicleType, User user) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.user = user;
        Input input = new Input();
        userInput = input.userInput();
    }

    Vehicle createVehicle() {
        if(vehicleType.equals("car")) {
            return new Car(vehicleNumber, user);
        } else if(vehicleType.equals("bike")) {
            return new Bike(vehicleNumber, user);
        } else {
            return new Cycle(vehicleNumber, user);
        }
    }
};

class Car extends Vehicle {
    Car(String vehicleNumber, User user) {
        super(vehicleNumber, "car", user);
        this.vehicleType = vehicleType;
    }
};

class Bike extends Vehicle {
    Bike(String vehicleNumber, User user) {
        super(vehicleNumber, "bike", user);
        this.vehicleType = vehicleType;
    }
};

class Cycle extends Vehicle {
    Cycle(String vehicleNumber, User user) {
        super(vehicleNumber, "cycle", user);
        this.vehicleType = vehicleType;
    }
};
    
