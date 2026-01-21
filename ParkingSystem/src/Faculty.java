public class Faculty extends User {
    public Faculty(String name){
        super(name,"Faculty");
    }

    @Override
    public double calculateFee(String vehicleType, String duration){
        return 0.0;
    }
}
