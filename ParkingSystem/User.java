class User {
    String name, userId, type;
    User createUser(String name, String userId, String type) {
        if(type.equals("faculty")) {
            return new Faculty(name, userId, type);
        } else {
            return new Student(name, userId, type);
        }
    }
}

class Faculty extends User {
    Faculty(String name, String userId, String type) {
        this.name = name;
        this.userId = userId;
        this.type = type;
    }
}

class Student extends User {
    Student(String name, String userId, String type) {
        this.name = name;
        this.userId = userId;
        this.type = type;
    }
}