package ProblemStatement_2;

public class Library {
    Book[] books = new Book[10];
    int count = 0;

    void addBook(String title) {
        books[count++] = new Book(title);
    }

    void removeBook(String key) {
        for (int i = 0; i < count; i++) {
            if (check(books[i].title, key)) {
                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];
                }
                count--;
                i--;
            }
        }
    }

    void search(String key) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equals(key)) {
                System.out.println("Book(\"" + books[i].title + "\")");
            }
        }
    }

    void search(String key, boolean partial) {
        for (int i = 0; i < count; i++) {
            if (check(books[i].title, key)) {
                System.out.println("Book(\"" + books[i].title + "\")");
            }
        }
    }

    boolean check(String text, String key) {
        for (int i = 0; i <= text.length() - key.length(); i++) {
            int j = 0;
            while (j < key.length() && text.charAt(i + j) == key.charAt(j)) {
                j++;
            }
            if (j == key.length()) {
                return true;
            }
        }
        return false;
    }
}
