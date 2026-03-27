import java.util.Scanner;

class DigitalLibrary {

    // Method for searching books
    static void searchBook(String[] books, String search, int choice) {

        boolean found = false;

        for (int i = 0; i < books.length; i++) {

            if (choice == 1) {
                // Exact match
                if (books[i].equals(search)) {
                    System.out.println("Found: " + books[i]);
                    found = true;
                    break;
                }
            } else {
                // Partial match
                if (books[i].contains(search)) {
                    System.out.println("Found: " + books[i]);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Book not found");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        String[] books = new String[n];

        System.out.println("Enter book titles:");
        for (int i = 0; i < n; i++) {
            books[i] = sc.nextLine();
        }

        System.out.print("Enter search title: ");
        String search = sc.nextLine();

        System.out.print("Enter 1 for Exact search, 2 for Partial search: ");
        int choice = sc.nextInt();

        // Method call
        searchBook(books, search, choice);
    }
}
