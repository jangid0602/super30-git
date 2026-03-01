package parking_system;

public abstract class User {

    String name, id;

    User (String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public String getId() {
        return id;
    }

    abstract String getUserType();

    abstract double calculateFinalamount(double amount);
}
    class Student extends User {

        Student(String name, String id) {
            super(name,id);
        }

        @Override
        public String getUserType() {
            return "Student";
        }

        @Override
        public double calculateFinalamount(double amount) {
            return amount;
        }
    }

    class Faculty extends User {

        Faculty(String name, String id) {
            super(name,id);
        }

        @Override
        public String getUserType() {
            return "Faculty";
        }

        @Override
        public double calculateFinalamount(double amount) {
            return 0;
        }
    }
