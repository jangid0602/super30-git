import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Ticket {
    private String tickedId;
    private User user;
    private Vehicle vehicle;
    private ParkingPass parkingPass;

    public Ticket(ParkingPass parkingPass, User user, Vehicle vehicle) {
        this.parkingPass = parkingPass;
        this.tickedId = generateId();
        this.user = user;
        this.vehicle = vehicle;
    }

    public String generateId(){
        Random rand = new Random();
        return "T".concat("GIT").concat(String.valueOf(rand.nextInt(100000)));
    }

    public void generateTicketDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        System.out.println("✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎\n");
        System.out.println("Ticket ID : ".concat(tickedId));
        System.out.println("Name : ".concat(user.name));
        System.out.println("User Type : ".concat(user.getUserType()));
        System.out.println("User ID : ".concat(user.Id));
        System.out.println("Vehicle Type : ".concat(vehicle.getVehicleType()));
        System.out.println("Vehicle Number : ".concat(vehicle.getVehicleNumber()));
        System.out.println("Pass Duration : ".concat(parkingPass.getDuration()));
        System.out.println("Fee Rs. : ".concat(parkingPass.getFee()));
        System.out.println("Issue Date : ".concat(parkingPass.getIssueDate().format(formatter)));
        System.out.println("Expiry Date : ".concat(parkingPass.getExpiryDate().format(formatter)));
        System.out.println("\n✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎✈︎");
    }
}
