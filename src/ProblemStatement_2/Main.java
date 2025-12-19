package ProblemStatement_2;

public class Main {
    public static void main(String[] args) {

        Library lib = new Library();

        lib.addBook("War");
        lib.search("War");

        lib.addBook("Data");
        lib.addBook("Database");
        lib.search("Data", true);

        lib.removeBook("A");
        lib.search("A", true);

    }
}
