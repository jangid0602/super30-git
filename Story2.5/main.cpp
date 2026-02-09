#include <iostream>
#include <limits>
#include <vector>
#include <string>
#include <unordered_set>

using namespace std;

// The Cosmic Courier 

class TheCosmicCourier{
    public:
        int Solution(const vector<int>& routes) const {

        // For only one element is present in the input array
        if (routes.size() == 1) {
            return routes[0];
        }

        // Inititalizing the intiial variables
        int largestRoute = INT_MIN;
        int secondLargestRoute = INT_MIN;
        int largestCount = 0;

        for (int currRoute : routes) {

            // To find the largest and second largest values:
            if (currRoute > largestRoute) {
                secondLargestRoute = largestRoute;
                largestRoute = currRoute;
                largestCount = 1;
            } 
        
            // For, if the largestRoute is equal to current value:
            else if (currRoute == largestRoute) {
                largestCount++;
            } 
        
            // For, if the x is larger than second largest then we have to change second largest value:
            else if (currRoute > secondLargestRoute) {
                secondLargestRoute = currRoute;
            }
        }

        return (largestCount > 1) ? largestRoute : secondLargestRoute;
    }

    void execute(){
        vector<int> input;
        int temp; 

        // For taking input
        cout << "Enter integers ( or any char to end): ";
        while (cin >> temp) {
        input.push_back(temp);
        }

        if (input.empty()) cout << "RESULT: No data provided." << endl;
        else cout << "MINIMIZED DEADLINE: " << Solution(input) << endl;

        // For input buffer clear
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
    }

};

// The Factory Floor Robot 

class FactoryFloorRobot{
    public:

    vector<string> Solution(const vector<int>& weight) const {

        vector<string> result;
    
        for(int i = 0; i < weight.size(); i++){

            int currValue = weight[i];

            // For multiple of 15
            if((currValue % 15) == 0){
                result.push_back("Hazardous");
            }
        
            // For multiple of 3
            else if((currValue % 3) == 0){
                result.push_back("Heavy");
            }

            // For multiple of 5
            else if((currValue % 5) == 0){
                result.push_back("Fragile");
            }

            else {
                result.push_back(to_string(currValue));
            }
        }

        return result;
    }

    void execute(){

        vector<int> input;
        int temp; 

        // For taking input:
        cout << "\n[Factory Robot] Enter weights (any char to end): ";
        while (cin >> temp) {
            input.push_back(temp);
        }

        // Storing output in labels from Solution method:
        vector<string> labels = Solution(input);

        // For printing lables:
        for(const string& s : labels) {
            cout << s << " "; 
        }
        cout << endl;

        // For input buffer clear:
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }
};

// The Spy’s Cipher
    
class TheSpyCipher{
    public:
    char Solution(const string& original,const string& scrambled) const {
        
        // Taking a frequecy array for each 0-255 ASCII character
        int freq[256] = {0}; 

        // For each character in origianl we count the frequecny
        for (char ch : original){
            freq[(unsigned)ch]++;
        }

        // For each character in scrambled we decrease the frequency
        for (char ch : scrambled){

            // If the frequency becomes '-1' or less than zero we return that character
            if(--freq[(unsigned)ch] < 0){
                return ch;
            }
        }

        return '\0'; // edge case 
    }


    void execute(){

        string input1, input2;

        // For taking input
        cout << "Enter strings( original scrambled ): ";
        cin >> input1 >> input2;

        // For clearing input buffer
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        // For printing result
        char extra = Solution(input1, input2);

        if (extra != '\0') {
            cout << "The extra character is: " << extra << endl;
        } else {
            cout << "No extra character found." << endl;
        }

        // (extra != '\0') ? cout << "The extra character is: " << extra << endl : cout << "No extra character found." << endl;

    }
};

class SecurityLogAnalyzer {
private:
    vector<int> prefix;

public:
    // Default constructor (needed for the menu)
    SecurityLogAnalyzer() {}

    // Method to initialize/rebuild the prefix sum array
    void initialize(const vector<int>& logins) {
        int size = logins.size();
        if (size == 0) return;

        prefix.resize(size);
        prefix[0] = logins[0];
        for (int k = 1; k < size; k++) {
            prefix[k] = prefix[k - 1] + logins[k];
        }
    }

    // Method for query resolution
    long long getSum(const int& i,const int& j) const {

        if (i < 0 || j >= (int)prefix.size() || i > j) return 0; // Boundary check

        if (i == 0) return (long long)prefix[j];
        return (long long)prefix[j] - prefix[i - 1];
    }

    void execute() {
        vector<int> input;
        int temp;

        cout << "\n[Security Log Analyzer] Enter daily logins (any letter to end): ";
        while (cin >> temp) {
            input.push_back(temp);
        }

        // Cleanup the fail state caused by entering a letter
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        if (input.empty()) {
            cout << "No data entered." << endl;
            return;
        }

        // Initialize object with the data
        initialize(input);

        int i, j;
        cout << "Enter query (start_index end_index): ";
        if (cin >> i >> j) {
            cout << "Total Logins for range [" << i << ", " << j << "]: " << getSum(i, j) << endl;
        }

        // For clearing the input buffer
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }
};

// The Concert Seat Manager

class ConcertSeatManager {
public:
    string Solution(const vector<pair<string, int>>& requests) const {
        // A set to keep track of already booked seat numbers
        unordered_set<int> bookedSeats;

        for (const auto& currRequest : requests) {
            string customerID = currRequest.first;
            int seat = currRequest.second;
        
            // If the seat is already in the set, we found a duplicate
            if (bookedSeats.find(seat) != bookedSeats.end()) {
                return customerID; 
            }

            bookedSeats.insert(seat);
        }

        return "-1"; // No duplicates found
    }

    void execute() {
        vector<pair<string, int>> input;
        string cid;
        int seat;

        cout << "\n[Concert Seat Manager]" << endl;
        cout << "Enter requests (Customer_ID Seat_Number). Type 'done 0' to finish: " << endl;

        // For input loop
        while (cin >> cid && cid != "done") {
            if (cin >> seat) {
                input.push_back({cid, seat});
            } else {
                // If user types a non-integer for seat, clear it and break
                cin.clear();
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                break;
            }
        } 

        // Calculate and print result
        string duplicateCustomer = Solution(input);
        cout << "First duplicate attempt by: " << duplicateCustomer << endl;

        // Cleanup to prevent menu skip
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }
};

// The Weather Station Data Aggregator

class WeatherStation {
public: 
    
    int Solution(const vector<int>& data) const {
        // Safety check for empty input
        if (data.empty()) return 0;

        int count = 1; // The first day is always a record
        int currentMax = data[0];

        
        for (int i = 1; i < data.size(); i++) {
            if (data[i] > currentMax) {
                currentMax = data[i];
                count++;
            }
        }   

        return count;
    }

    void execute() {
        vector<int> input;
        int temp; 

        cout << "\n[Weather Station] Enter temperatures (or any char to end): ";
        while (cin >> temp) {
            input.push_back(temp);
        }

        // Logic Check: Ensure we don't call Solution on an empty vector
        if (input.empty()) {
            cout << "No data recorded." << endl;
        } else {
            cout << "Record-breaking days: " << Solution(input) << endl;
        }

        // Cleanup 
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }
};

// The Digital Library System

class Book {
private: 
    string title;

public: 
    Book(string t) : title(t) {}
    string getTitle() { return title; }
};

class DigitalLibrarySystem {
private:
    vector<Book> collection;

public:
    // Logic: Adds a book to the vector
    void addBook(string title) {
        collection.push_back(Book(title));
        cout << "Book added successfully!" << endl;
    }

    // Logic: Removes a book by exact title
    void removeBook(string title) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection[i].getTitle() == title) {
                collection.erase(collection.begin() + i);
                cout << "Book '" << title << "' removed." << endl;
                return;
            }
        }
        cout << "Book not found. Nothing removed." << endl;
    }
    
    // Exact Match Search
    void search(string query) {
        bool found = false;
        for (auto& b : collection) {
            if (b.getTitle() == query) {
                cout << "Found: " << b.getTitle() << endl;
                found = true;
                break; 
            }
        }
        if (!found) cout << "Not found (Exact match)." << endl;
    }

    // Partial Match Search
    void search(string query, bool isPartial) {
        if (!isPartial) {
            search(query);
            return;
        }

        bool found = false;
        cout << "Partial results: ";
        for (auto& b : collection) {
            // string::find returns npos if the substring is not found
            if (b.getTitle().find(query) != string::npos) {
                cout << "\"" << b.getTitle() << "\" ";
                found = true;
            }
        }
        cout << endl;
        if (!found) cout << "No partial matches found." << endl;
    }

    void execute() {
        int choice;
        string tempTitle;

        while (true) {
            cout << "\n[Digital Library Sub-Menu]" << endl;
            cout << "1. Add Book\n2. Remove Book\n3. Exact Search\n4. Partial Search\n0. Back to Main Menu" << endl;
            cout << "Choice: ";
            
            if (!(cin >> choice)) {
                cin.clear();
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                continue;
            }

            if (choice == 0) break;

            cin.ignore(numeric_limits<streamsize>::max(), '\n');

            switch (choice) {
                case 1:
                    cout << "Enter book title to add: ";
                    getline(cin, tempTitle);
                    addBook(tempTitle);
                    break;
                case 2:
                    cout << "Enter book title to remove: ";
                    getline(cin, tempTitle);
                    removeBook(tempTitle);
                    break;
                case 3:
                    cout << "Enter search query (Exact): ";
                    getline(cin, tempTitle);
                    search(tempTitle);
                    break;
                case 4:
                    cout << "Enter search query (Partial): ";
                    getline(cin, tempTitle);
                    search(tempTitle, true);
                    break;
                default:
                    cout << "Invalid choice." << endl;
            }
        }

        cin.clear();
    }
};

// The Corporate Hierarchy System

class Employee {
protected:
    string name;
    int id;
    double baseSalary; 

public:
    Employee(string n, int i, double s) : name(n), id(i), baseSalary(s) {}

    // virtual: enables dynamic dispatch for child classes
    virtual double calculateBonus() const {
        return baseSalary * 0.10; 
    }

    virtual string getRole() const { return "Employee"; }
    virtual ~Employee() {} 
};

class Manager : public Employee {
public:
    Manager(string n, int i, double s) : Employee(n, i, s) {}

    // override: Manager-specific bonus calculation
    double calculateBonus() const override {
        return (baseSalary * 0.25) + 5000; 
    }

    string getRole() const override { return "Manager"; }
};

class Executive : public Manager {
public:
    Executive(string n, int i, double s) : Manager(n, i, s) {}

    // override: Executive-specific bonus including stock options
    double calculateBonus() const override {
        return (baseSalary * 0.50) + 10000; 
    }

    string getRole() const override { return "Executive"; }
};

// --- Master Class for Menu Integration ---
class CorporateHierarchySystem {
private:
    vector<Employee*> companyStaff;

    // Polymorphic function to calculate total payout
    double calculateTotalPayout() {
        double total = 0;
        for (Employee* e : companyStaff) {
            total += e->calculateBonus(); 
        }
        return total;
    }

public:
    // Destructor to prevent memory leaks
    ~CorporateHierarchySystem() {
        for (Employee* e : companyStaff) {
            delete e;
        }
    }

    void execute() {
        int choice;
        string name;
        int id;
        double salary;

        while (true) {
            cout << "\n[Corporate Hierarchy Sub-Menu]" << endl;
            cout << "1. Add Employee\n2. Add Manager\n3. Add Executive\n4. View Bonus Report\n0. Back to Main Menu" << endl;
            cout << "Choice: ";
            
            if (!(cin >> choice)) {
                cin.clear();
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                continue;
            }

            if (choice == 0) break;

            if (choice >= 1 && choice <= 3) {
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                cout << "Enter Name: ";
                getline(cin, name);
                cout << "Enter ID: ";
                cin >> id;
                cout << "Enter Base Salary: ";
                cin >> salary;

                // Creating objects on the heap using 'new' for polymorphism
                if (choice == 1) companyStaff.push_back(new Employee(name, id, salary));
                else if (choice == 2) companyStaff.push_back(new Manager(name, id, salary));
                else if (choice == 3) companyStaff.push_back(new Executive(name, id, salary));
            } 
            else if (choice == 4) {
                cout << "\n--- Bonus Payout Report ---" << endl;
                for (Employee* e : companyStaff) {
                    cout << e->getRole() << " " << ": Bonus = " << e->calculateBonus() << endl;
                }
                cout << "Total Company-Wide Payout: " << calculateTotalPayout() << endl;
            }
        }
    }
};


int main() {
    int choice;
    
    DigitalLibrarySystem myLibrary;
    CorporateHierarchySystem myCompany;

    while (true) {
        cout << "\n===============================";
        cout << "\n       STORY 2.5 MASTER SUITE   ";
        cout << "\n===============================";
        cout << "\n1. The Cosmic Courier";
        cout << "\n2. The Factory Floor Robot";
        cout << "\n3. The Spy's Cipher";
        cout << "\n4. The Security Log Analyzer";
        cout << "\n5. The Concert Seat Manager";
        cout << "\n6. The Weather Station Data Aggregator";
        cout << "\n7. The Digital Library";
        cout << "\n8. The Corporate Hierarchy System";
        cout << "\n0. Exit";
        cout << "\nSelection: ";

        if (!(cin >> choice)) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            continue;
        }
        
        if (choice == 0) break;

        switch (choice) {
            case 1: {
                TheCosmicCourier courier;
                courier.execute();
                break;
            }
            case 2: {
                FactoryFloorRobot robot;
                robot.execute();
                break;
            }
            case 3: {
                TheSpyCipher spy;
                spy.execute();
                break;
            }
            case 4: {
                SecurityLogAnalyzer analyzer;
                analyzer.execute();
                break;
            }
            case 5: {
                ConcertSeatManager concert;
                concert.execute();
                break;
            }
            case 6: {
                WeatherStation weather;
                weather.execute();
                break;
            }
            case 7: {
                // Using the persistent object so books stay saved
                myLibrary.execute();
                break;
            }
            case 8: {
                // Using the persistent object so staff data stays saved
                myCompany.execute();
                break;
            }
            default: 
                cout << "Invalid choice. Please try again." << endl;
        }
    }
    
    cout << "\nGood Bye!" << endl;
    return 0;
}