import java.util.Random;

abstract class User {
    protected String Id;
    protected String name;
    protected String userType;


    public User(String name, String userType) {
        this.name = name;
        this.userType = userType;
        this.Id = generateId();
    }

    public String generateId() {
        Random rand = new Random();
        return userType.substring(0, 1).toUpperCase().concat("GIT").concat(String.valueOf(rand.nextInt(1000)));
    }

    public abstract double calculateFee(String vehicleType, String duration);

    public String getUserID() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getUserType() {
        return userType;
    }
}
