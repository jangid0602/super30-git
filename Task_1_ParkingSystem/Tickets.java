package Codeup.Oops_task.Task_1_ParkingSystem;

import java.util.Scanner;

public class Tickets {
    String vehicleType;
    Scanner userInput;
    Tickets(String vechicleType) {
        this.vehicleType = vechicleType;
        Input input = new Input();
        userInput = input.userInput();
    }
    int selectPass() {
        int choice;
        Daily daily = new Daily(vehicleType);
        Weekly weekly = new Weekly(vehicleType);
        Monthly monthly = new Monthly(vehicleType);
        Yearly yearly = new Yearly(vehicleType);

        System.out.println("Select a pass:");
        System.out.println("1. 1-Day pass " + daily.cost());
        System.out.println("2. 1-Week pass " + weekly.cost());
        System.out.println("3. 1-Month pass " + monthly.cost());
        System.out.println("4. 1-Year pass " + yearly.cost());
        choice = userInput.nextInt();
        if(choice == 1) {
            return daily.cost();
        } else if(choice == 2) {
            return weekly.cost();
        } else if(choice == 3) {
            return monthly.cost();
        } else {
            return yearly.cost();
        }
    }
};

class Daily extends Tickets {
    Daily(String vehicleType) {
        super(vehicleType);
    }

    int cost() {
        if(vehicleType.equals("cycle")) {
            return 10;
        } else if(vehicleType.equals("bike")) {
            return 20;
        } else {
            return 50;
        }
    }
}

class Weekly extends Tickets {
    Weekly(String vehicleType) {
        super(vehicleType);
    }
    int cost() {
        if(vehicleType.equals("cycle")) {
            return 50;
        } else if(vehicleType.equals("bike")) {
            return 100;
        } else {
            return 350;
        }
    }
}

class Monthly extends Tickets {
    Monthly(String vehicleType) {
        super(vehicleType);
    }
    int cost() {
        if(vehicleType.equals("cycle")) {
            return 200;
        } else if(vehicleType.equals("bike")) {
            return 400;
        } else {
            return 1200;
        }
    }
}

class Yearly extends Tickets {
    Yearly(String vehicleType) {
        super(vehicleType);
    }
    int cost() {
        if(vehicleType.equals("cycle")) {
            return 2000;
        } else if(vehicleType.equals("bike")) {
            return 4000;
        } else {
            return 10000;
        }
    }
}
