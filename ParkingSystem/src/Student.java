public class Student extends User {
    public Student(String name) {
        super(name, "Student");
    }


    @Override
    public double calculateFee(String vehicleType, String duration) {
        if (vehicleType.equals("Two Wheeler")) {
            return switch (duration) {
                case "1 Day" -> 20.0;
                case "1 Week" -> 100.0;
                case "1 Month" -> 300.0;
                default -> 0.0;
            };
        } else if (vehicleType.equals("Four Wheeler")) {
            return switch (duration) {
                case "1 Day" -> 50.0;
                case "1 Week" -> 250.0;
                case "1 Month" -> 700.0;
                default -> 0.0;
            };
        }
        return 0.0;
    }
}