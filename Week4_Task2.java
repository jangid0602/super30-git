//The Digital Library System

import java.util.ArrayList;
import java.util.List;


class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book(\"" + title + "\")";
    }
}


class Library {

    private List<Book> books = new ArrayList<>();

    
    public void addBook(String title) {
        books.add(new Book(title));
    }

    
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }


    public List<Book> search(String title) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }
        return result;
    }

    
    public List<Book> search(String title, boolean partial) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (partial && book.getTitle().contains(title)) {
                result.add(book);
            }
        }
        return result;
    }
}


public class Week4_Task2 {

    public static void main(String[] args) {

        Library library = new Library();

    
        library.addBook("War");
        System.out.println(library.search("War"));

        
        library.addBook("Data");
        library.addBook("Database");
        System.out.println(library.search("Data", true));

        
        library.removeBook("A");
        System.out.println(library.search("A"));
    }
}
