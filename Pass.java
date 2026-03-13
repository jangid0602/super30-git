package parking_system;
public interface Pass {
    
    String getPassType();
    double getPrice(String vehicleType);
}

     class DailyPass implements Pass {

        @Override
        public String getPassType() {
         return "Daily";
        }
      
        @Override
        public double getPrice(String vehicleType) {
            if(vehicleType.equalsIgnoreCase("Bike")) {
                return 20;
            } else if(vehicleType.equalsIgnoreCase("Car")) {
                return 50;
            } else {
                return 10;
            }
        }
    }

     class WeeklyPass implements Pass {

        @Override
        public String getPassType() {
            return "Weekly";
        }

        @Override
        public double getPrice(String vehicleType) {
            if(vehicleType.equalsIgnoreCase("Bike")) {
                return 100;
            } else if (vehicleType.equalsIgnoreCase("Car")) {
                return 300;
            } else {
                return 50;
            }
        }
    }

   class MonthlyPass implements Pass {

        @Override
        public String getPassType() {
            return "Monthly";
        }

        @Override
        public double getPrice(String vehicleType) {
            if(vehicleType.equalsIgnoreCase("Bike")) {
                return 300;
            } else if(vehicleType.equalsIgnoreCase("Car")) {
                return 1000;
            } else {
                return 200;
            }
        }
    }
