package parking_system;

public abstract class Vehicle {
    
    String vehicleNumber;

    Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    } 

    public String getvehicleNumber() {
        return vehicleNumber;
    }

    abstract String getvehicleType();
}

     class Car extends Vehicle {

        Car(String vehicleNumber) {
        super(vehicleNumber);
        }

        @Override
        public String getvehicleType() {
             return "Car";
        }
    }

     class Bike extends Vehicle {

        Bike(String vehicleNumber) {
            super(vehicleNumber);
        }

        @Override
        public String getvehicleType() {
            return "Bike";
        }
    }

     class Cycle extends Vehicle {
        
        Cycle(String vehicleNumber) {
            super(vehicleNumber);
        }

        @Override
        public String getvehicleType() {
            return "Cycle";
        }
    }