import java.util.*;;

class User {
    String name, id, type;
    User(String name, String id, String type) {
        this.name = name;
        this.id = id;
        this.type = type;
    }

    User createUser() {
        if(type.equals("faculty")) {
            return new Faculty(name, id, type);
        } else {
            return new Faculty(name, id, type);
        }
    }


    class Faculty extends User {
        Faculty(String name, String id, String type){
            super(name, id, type);
        }
    }

    class Student extends User {
        Student(String name, String id, String type) {
            super(name,id,type);
        }
    }


    // void generateTicket(int cost) {
    //     System.out.println("--------- Your Ticket ----------");
    //     System.out.println("Name: "+name);
    //     System.out.println("Id: "+id);
    //     System.out.println("vehicle-Number: "+vehicleNumber);
    //     System.out.println("Vehicle-Type: "+vehicleType);
    //     System.out.println("cost " +cost);
    //     System.out.println("---------- Thank you for visiting us ----------");
    // }
} 