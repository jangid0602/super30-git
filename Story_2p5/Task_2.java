package Codeup.Story_2p5;

import java.util.Scanner;

public class Task_2 {
    static class Library {
        String[] books = new String[100];
        int count = 0;

        void addBook(String title) {
            books[count++] = title;
        }

        void searchExact(String title) {
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (equalsStr(books[i], title)) {
                    System.out.println("Book(\"" + books[i] + "\")");
                    found = true;
                }
            }
            if (!found) System.out.println("[]");
        }

        void searchPartial(String title) {
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (containsStr(books[i], title)) {
                    System.out.println("Book(\"" + books[i] + "\")");
                    found = true;
                }
            }
            if (!found) System.out.println("[]");
        }

        boolean equalsStr(String a, String b) {
            if (a.length() != b.length()) return false;
            for (int i = 0; i < a.length(); i++)
                if (a.charAt(i) != b.charAt(i)) return false;
            return true;
        }

        boolean containsStr(String a, String b) {
            for (int i = 0; i <= a.length() - b.length(); i++) {
                int j = 0;
                while (j < b.length() && a.charAt(i + j) == b.charAt(j)) j++;
                if (j == b.length()) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        System.out.print("How many books to add: ");
        int nb = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < nb; i++) {
            String title = sc.nextLine();
            lib.addBook(title);
        }
        System.out.print("Enter search title: ");
        String search = sc.nextLine();
        lib.searchPartial(search);
    }
}
