public class Vehicle {
    private final String vehicleNumber;
    private final String vehicleType;

    public Vehicle(String vehicleNumber,String vehicleType){
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
}
