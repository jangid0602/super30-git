#include<iostream>
#include<vector>
#include<string>
#include<cstring>
#include<limits>
#include <cstdlib> 

using namespace std;

// Node structure
    struct Node {
        int data;
        Node* next;

        Node(int val) : data(val), next(nullptr) {}
    };

// LinkedList Class
    class LinkedList {
        public:

        Node* head; // Points to the first node  

        LinkedList() : head(nullptr) {}

        // 1. Insert at the end
        void insert(int val) {
            Node* newNode = new Node(val);
            if (head == nullptr) {
                head = newNode;
                return;
            }

            Node* temp = head;
            while (temp->next != nullptr) {
                temp = temp->next;
            }
            temp->next = newNode;
        }

        // 2. Delete a node by value
        void deleteNode(int val) {
            if (head == nullptr) return;

            // If head node itself holds the value
            if (head->data == val) {
                Node* temp = head;
                head = head->next;
                delete temp;
                return;
            }

            Node* temp = head;
            while (temp->next != nullptr && temp->next->data != val) {
                temp = temp->next;
            }

            if (temp->next != nullptr) {
                Node* toDelete = temp->next;
                temp->next = temp->next->next;
                delete toDelete;
            }
        }

        // 3. Display the list
        void display() const {
            Node* temp = head;
            while (temp != nullptr) {
                cout << temp->data << " -> ";
                temp = temp->next;
            }
            cout << "NULL" << endl;
        }

        // Destructor to clean up memory
        ~LinkedList() {
            Node* current = head;
            while (current != nullptr) {
                Node* nextNode = current->next;
                delete current;
                current = nextNode;
            }
        }
    };

// The O(1) Average Stack

class theAverageStack{

    class Stack{
    
    public: 

        int stackSize;
        int *arr;
        int top;
        int sum = 0;
        double average = 0;

        Stack(int size){
            this->stackSize = size;
            top = -1;
            arr = new int[size];
        }

        void push(int value){
            
            if(top >= stackSize){
                std::cout << "STACK OVERFLOW. VALUE NOT ADDED." << std::endl;
            } else {
                top++;
                arr[top] = value;
                sum += value;
                cout << value << " has been added." << endl;
            }
        }

        void pop(){
            if(top < 0){
                std::cout << "STACK UNDERFLOW. STACK IS EMPTY." << std::endl;
            } else {
                sum -= arr[top];
                top--;
                cout << arr[top] << " has been removed." << endl;
            }
        }

        void peek(){
            cout << "Top Element: " << arr[top] << endl;
        }

        void printAverage(){
            average = sum / (top+1);
            cout << "Average: " << average << endl;
        }

        void print(){
            cout << "Stack: ";
            for(int i = 0; i <= top; i++){
                std::cout << arr[i] << " ";
            }
            cout << endl;
        }
    };

    public:
        void execute(){

        int size;
        int choice;

        cout << "Problem 1: The O(1) Average Stack" << endl;
        cout << "Enter the size of Stack: ";
        cin >> size;

        Stack currStack(size);

        while(cin){
        
            cout << "1. Push" << endl;
            cout << "2. Pop" << endl;
            cout << "3. Print Stack" << endl;
            cout << "4. Print Average" << endl;
            cout << "5. Print Top" << endl;
            cout << "6. Exit" << endl;
            cout << "Enter an option: ";
            cin >> choice;

            switch (choice)
            {
            case 1:
                int value;
                cout << "Enter a value to add: ";
                cin >> value;
                currStack.push(value);
                break;

            case 2:
                currStack.pop();
                break;

            case 3: 
                currStack.print();
                break;

            case 4: 
                currStack.printAverage();
                break;

            case 5: 
                currStack.peek();
                break;

            case 6: 
                return;
        
            default:
                cout << "Invalid Option." << endl;
                break;
            }   
        }   
    }
};

// The Leaky Bucket Queue

class theLeakyBucketQueue{
    
    class LeakyBucket{
        
        public:
            int* arr;
            int front;
            int back;
            int capacity;
            int count;

            LeakyBucket(int size){
                arr = new int[size];
                front = 0; 
                back = -1;
                count = 0;
                capacity = size;
            }

            int dequeue(){
                if(count == 0){
                    cout << "Queue Underflow" << endl;
                    return 0;
                }  
                else {
                    int item = arr[front];
                    front = (front + 1) % capacity;
                    count--;
                    return item;
                }
            }

            void enqueue(int value){
                if(count >= capacity) dequeue();
                back++;
                arr[back] = value;
                count++;
            }

            void process(int k){
                for(int i = 0; i < k; i++){
                    cout << dequeue();
                }
            }

            void print(){
                cout << "Queue: ";
                for(int i = 0; i < count; i++){
                    cout << arr[i] << " ";
                }
                cout << endl;
            }
        };

    public:

    void execute(){

        int size;
        int choice;

        cout << "Problem 6: The Leaky Bucket Queue" << endl;
        cout << "Enter the size of Queue: ";
        cin >> size;

        LeakyBucket Queue(size);

        while(cin){
        
            cout << "1. Enqueue" << endl;
            cout << "2. Process" << endl;
            cout << "3. Print Queue" << endl;
            cout << "0. Exit" << endl;
            cout << "Enter an option: ";
            cin >> choice;

            switch (choice)
            {
            case 1:
                int value;
                cout << "Enter a value to add: ";
                cin >> value;
                Queue.enqueue(value);
                break;

            case 2:
                int number;
                cout << "Enter a number to process: ";
                cin >> number;
                Queue.process(number);
                break;

            case 3: 
                Queue.print();
                break;

            case 0: 
                return;
        
            default:
                cout << "Invalid Option." << endl;
                break;
            }   
        }   
    }
};

// The K-Zipline Merge

class TheKZiplineMerge{

    public:
    void execute(){

        LinkedList listOne;
        LinkedList listTwo;
        int batchSize;

        int input;

        cout << "Enter Elements for List One (or 'e' to end) ";

        while(cin >> input && input != 'e'){
            listOne.insert(input);
        }

        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        cout << "Enter Elements for List Two (or 'e' to end) ";

        while(cin >> input && input != 'e'){
            listTwo.insert(input);
        }

        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        Node* pointerOne = listOne.head;
        Node* pointerTwo = listTwo.head;

        LinkedList resultList;

        cout << "Enter a chunk amount: ";
        cin >> batchSize;

        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        while(pointerOne != nullptr ||  pointerTwo != nullptr){

            for(int i = 0; i < batchSize; i++){
                if(pointerOne == nullptr){
                    break;
                }
                resultList.insert(pointerOne->data);
                pointerOne = pointerOne->next;
            }

            for(int j = 0; j < batchSize; j++){
                if(pointerTwo == nullptr){
                    break;
                }
                resultList.insert(pointerTwo->data);
                pointerTwo = pointerTwo->next;
            }

        }

        cout << "Result: " << endl;

        resultList.display();

        cout << "\nPress Enter to return to Story Menu";
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cin.get();
    }
};

// The Prime/Composite List Partition

class ListPartition{

    public:

    // Function to Identify Prime Number
    bool isPrime(int value){

        if(value == 1 || value == 0){
            return false;
        }

        for(int i = 2; i < value; i++){
            if(value % i == 0) return false;
        }

        return true;
    }

    void execute(){

        // List:
        LinkedList list;

        int input;

        cout << "Enter Elements for List One (or 'e' to end) ";

        while(cin >> input && input != 'e'){
            list.insert(input);
        }

        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        cout << "List: ";
        list.display();
        cout << endl;

        // Pointers:
        Node* current = list.head;
        Node* primeFirst = nullptr;
        Node* primeLast = nullptr;
        Node* compositeFirst = nullptr;
        Node* compositeLast = nullptr;
        Node* forOne = nullptr;

        // Partition the list
        while(current != nullptr){
            Node* next = current->next;  // Saved next node before changing links

            // Creating a Sub-List for Prime Numbers
            if(isPrime(current->data)){
                if(primeFirst == nullptr){
                    primeFirst = current;
                    primeLast = current;
                } else {
                    primeLast->next = current;
                    primeLast = current;
                }
                primeLast->next = nullptr;  // Terminate the prime sublist
            }

            // Creating a Sub-List for Composite Numbers
            else if(current->data != 1){
                if(compositeFirst == nullptr){
                    compositeFirst = current;
                    compositeLast = current;
                } else {
                    compositeLast->next = current;
                    compositeLast = current;
                }
                compositeLast->next = nullptr;  // Terminate the composite sublist
            }

            // For handling number '1'.
            else {
                forOne = current;
                forOne->next = nullptr;
            }

            current = next;
        }

        // Link the three partitions together
        if(primeFirst != nullptr){
            list.head = primeFirst;
            primeLast->next = compositeFirst;
        } else {
            list.head = compositeFirst;
        }

        if(compositeLast != nullptr){
            compositeLast->next = forOne;
        } else if(primeFirst != nullptr) {
            primeLast->next = forOne;
        } else {
            list.head = forOne;
        }

        if(forOne != nullptr){
            forOne->next = nullptr;
        }

        cout << "Partitioned List: ";
        list.display();

        cout << "\nPress Enter to return to Story Menu";
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cin.get();
    }   
};

// The C-String Interweaver 

class StringInterweaver{

    string interweave(const char* string1,const char* string2){

        int length1 = strlen(string1);
        int length2 = strlen(string2);

        string result = "";

        int i = 0, j = 0;

        while(i < length1 && j < length2){
            result += string1[i++];
            result += string2[j++];
        }

        while(i < length1){
            result += string1[i++];
        }

        while(j < length2){
            result += string2[j++];
        }

        return result;
    }

    public: 
    void execute(){

        string str1, str2;
        cout << "Enter first string: ";
        cin >> str1;
        cout << "Enter second string: ";
        cin >> str2;

        string interwoven = interweave(str1.c_str(), str2.c_str());

        cout << "RESULT: " << interwoven << endl;

        cout << "\nPress Enter to return to Story Menu";
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cin.get();
    }
};

// The Collapsing Count List

struct CountNode {
    string value;
    int count;
    CountNode* next;

    CountNode(string v, int c) : value(v), count(c), next(nullptr) {}
};

class CollapsingCountList {
public:   

    CountNode* collapse(CountNode* countHead){
        // Build a collapsed list by reusing nodes from the input list.
        CountNode* head = nullptr;
        CountNode* tail = nullptr;
        CountNode* current = countHead;

        while (current != nullptr) {
            CountNode* next = current->next;
            current->next = nullptr; // detach current

            if (tail != nullptr && tail->value == current->value) {
                // merge counts into tail and delete current node
                tail->count += current->count;
                delete current;
            } else {
                if (tail == nullptr) {
                    head = tail = current;
                } else {
                    tail->next = current;
                    tail = current;
                }
            }

            current = next;
        }

        return head;
    }


    void display(CountNode* head) {
        CountNode* temp = head;
        while (temp) {
            cout << "(" << temp->value << ", " << temp->count << ")";
            if (temp->next) cout << " -> ";
            temp = temp->next;
        }
        cout << endl;
    }

    void execute(){
        CountNode* head = new CountNode("X", 1);
        head->next = new CountNode("Y", 2);
        head->next->next = new CountNode("Y", 2);
        head->next->next->next = new CountNode("X", 5);

        cout << "Original: "; display(head);
        head = collapse(head);
        cout << "Collapsed: "; display(head);

        cout << "\nPress Enter to return...";
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cin.get();
    }
};


int main() {

    int choice;
    cout << "STORY 2.5" << endl;

    while(cin) {
        cout << "1. The Average Stack" << endl;
        cout << "2. The Leaky Bucket" << endl;
        cout << "3. The K-Zipline Merge" << endl;
        cout << "4. The Prime/Composite List Partition" << endl;
        cout << "5. The C-String Interweaver" << endl;
        cout << "6. The Collapsing Count List" << endl;
        cout << "0. Exit" << endl;
        cout << "Enter a Choice: ";
        cin >> choice;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        
        switch (choice)
        {
        case 1:
            theAverageStack avgStack;
            avgStack.execute();
            break;

        case 2: 
            theLeakyBucketQueue leakyBukcet;
            leakyBukcet.execute();
            break;
        
        case 3:
            TheKZiplineMerge zipline;
            zipline.execute();
            break;

        case 4: 
            ListPartition list;
            list.execute();
            break;

        case 5:
            StringInterweaver interweaver;
            interweaver.execute();
            break;

        case 6: 
            CollapsingCountList collapseList;
            collapseList.execute();
            break;

        case 0: 
            return 0;

        default:
            cout << "Invalid Choice." << endl;
            cout << "\nPress Enter to return to Story Menu";
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cin.get();
            break;
        }
        
    }

    return 0;
}