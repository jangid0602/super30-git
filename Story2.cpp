#include <iostream>
#include <vector>
#include <string>
using namespace std;

// Book class 
class Book {
private:
    string title;

public:
    explicit Book(string t) : title(move(t)) {}

    string getTitle() const {
        return title;
    }

    void print() const {
        cout << "Book(\"" << title << "\")";
    }
};

// Library class 
class Library {
private:
    vector<Book> books;

public:
    // Add a book to the library
    void addBook(string title) {
        books.emplace_back(title);
    }

    // Remove all books with exact matching title
    void removeBook(string title) {
        vector<Book> remaining;
        for (const auto& book : books) {
            if (book.getTitle() != title) {
                remaining.push_back(book);
            }
        }
        books = move(remaining);
    }

    // Exact match search
    vector<Book> search(string query) const {
        vector<Book> results;
        for (const auto& book : books) {
            if (book.getTitle() == query) {
                results.push_back(book);
            }
        }
        return results;
    }

    // Partial match search 
    vector<Book> search(string query, bool partial) const {
        if (!partial) {
            return search(query); 
        }

        vector<Book> results;
        for (const auto& book : books) {
            string title = book.getTitle();
            if (title.find(query) != string::npos) {
                results.push_back(book);
            }
        }
        return results;
    }
};

void printResults(const vector<Book>& results) {
    cout << "[";
    for (size_t i = 0; i < results.size(); ++i) {
        results[i].print();
        if (i < results.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}
int main() {
    Library library;

    library.addBook("War");
    auto result1 = library.search("War");  
    printResults(result1);  

    library.addBook("Data");
    library.addBook("Database");
    auto result2 = library.search("Data", true); 
    printResults(result2);  

    library.removeBook("A");  
    auto result3 = library.search("A");
    printResults(result3);  

    return 0;
}