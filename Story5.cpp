#include <iostream>
using namespace std;

class Employee {
public:
    double salary;
    virtual double bonus() { return 0.10 * salary; }
};

class Manager : public Employee {
public:
    double bonus() { return 0.25 * salary + 5000; }
};

class Executive : public Manager {
public:
    double bonus() { return 0.50 * salary + 10000; }
};

int main() {
    Employee e; e.salary = 100000;
    Manager m; m.salary = 100000;
    Executive ex; ex.salary = 200000;
    
    cout << e.bonus() << endl;     // 10000
    cout << m.bonus() << endl;     // 30000
    cout << ex.bonus() << endl;    // 110000
    
    Employee* list[3] = {&e, &m, &ex};
    double total = 0;
    for (int i = 0; i < 3; i++) total += list[i]->bonus();
    cout << total << endl;         // 150000
    return 0;
}