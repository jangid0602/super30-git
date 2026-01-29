#include <iostream>
#include <vector>
#include <string>
#include <limits>

using namespace std;

enum class Role {
    Faculty,
    Student,
    Guest
};

enum class VehicleType {
    FourWheeler,
    TwoWheeler,
    Cycle
};

enum class PassType {
    Weekly,
    Monthly,
    Yearly
};

class Vehicle {
public:
    VehicleType type;
    int licenseID;

    Vehicle(VehicleType t, int id) {
        type = t;
        licenseID = id;
    }
};

class Pass {
public:
    int passId;
    PassType type;
    int remainingDays;

    Pass(int id, PassType t, int days) {
        passId = id;
        type = t;
        remainingDays = days;
    }
};

class User {
public:
    int id;
    string name;
    Role role;
    Vehicle vehicle;

    User(int i, string n, Role r, Vehicle v)
        : vehicle(v) {
        id = i;
        name = n;
        role = r;
    }
};

class Ticket {
public:
    int ticketId;
    string name;
    string role;
    string vehicle;
    int amount;
    int licenseID;

    Ticket(int id, string n, string r, string v, int amt, int lid) {
        ticketId = id;
        name = n;
        role = r;
        vehicle = v;
        amount = amt;
        licenseID = lid;
    }

    void print() {
        cout << "\n======= PARKING TICKET =======\n";
        cout << "Ticket ID : " << ticketId << endl;
        cout << "Name      : " << name << endl;
        cout << "Role      : " << role << endl;
        cout << "Vehicle   : " << vehicle << endl;
        cout << "License ID : " << licenseID << endl;
        cout << "Amount    : Rs " << amount << endl;
        cout << "==============================\n";
    }
};

vector<Pass> passes;

string roleToString(Role r) {
    if (r == Role::Faculty) return "Faculty";
    if (r == Role::Student) return "Student";
    return "Guest";
}

string vehicleToString(VehicleType v) {
    if (v == VehicleType::FourWheeler) return "4-Wheeler";
    if (v == VehicleType::TwoWheeler) return "2-Wheeler";
    return "Cycle";
}

Pass* findPass(int id) {
    for (auto& p : passes) {
        if (p.passId == id) {
            return &p;
        }
    }
    return nullptr;
}

int calculateFee(Role role, VehicleType vehicle) {

    if (role == Role::Faculty)
        return 0;

    if (role == Role::Student) {
        if (vehicle == VehicleType::FourWheeler) return 20;
        if (vehicle == VehicleType::TwoWheeler) return 10;
        return 2;
    }

    if (role == Role::Guest) {
        if (vehicle == VehicleType::FourWheeler) return 50;
        if (vehicle == VehicleType::TwoWheeler) return 20;
        return 5;
    }

    return 0;
}

int main() {

    int choice;
    int nextTicketId = 1000;
    int nextPassId = 5000;

    while (true) {

        cout << "\n==== COLLEGE PARKING SYSTEM ====\n";
        cout << "1. Generate Ticket\n";
        cout << "2. Buy a Pass\n";
        cout << "3. Exit\n";
        cout << "Enter choice: ";
        cin >> choice;

        if (choice == 3) {
            cout << "Program Ended.\n";
            break;
        }

        if (choice == 2) {

            int pChoice;
            cout << "\n1. Monthly Pass (30 days)\n";
            cout << "2. Yearly Pass (365 days)\n";
            cout << "Choose pass type: ";
            cin >> pChoice;

            int days = (pChoice == 1) ? 30 : 365;

            Pass newPass(nextPassId++, PassType::Monthly, days);
            passes.push_back(newPass);

            cout << "Pass Purchased Successfully!\n";
            cout << "Pass ID: " << newPass.passId << endl;
            cout << "Remaining Days: " << newPass.remainingDays << endl;
        }

        else if (choice == 1) {

            int id;
            string name;

            cout << "Enter User ID: ";
            cin >> id;
            cin.ignore(numeric_limits<streamsize>::max(), '\n');

            cout << "Enter Name: ";
            getline(cin, name);
            cin.clear();
            cin. ignore(numeric_limits<streamsize>::max(), '\n');

            int rChoice;
            cout << "\n1. Faculty\n2. Student\n3. Guest\n";
            cout << "Select Role: ";
            cin >> rChoice;

            Role role = (rChoice == 1) ? Role::Faculty :
                        (rChoice == 2) ? Role::Student : Role::Guest;

            int vChoice;
            cout << "\n1. 4-Wheeler\n2. 2-Wheeler\n3. Cycle\n";
            cout << "Select Vehicle: ";
            cin >> vChoice;

            int licenseID;
            cout << "\nlicense ID: ";
            cin >> licenseID;

            VehicleType vehicleType =
                (vChoice == 1) ? VehicleType::FourWheeler :
                (vChoice == 2) ? VehicleType::TwoWheeler :
                                 VehicleType::Cycle;

            Vehicle vehicle(vehicleType, licenseID);
            User user(id, name, role, vehicle);

            int fee = 0;

            if (role != Role::Faculty) {

                char hasPass;
                cout << "Do you have a pass? (y/n): ";
                cin >> hasPass;

                if (hasPass == 'y' || hasPass == 'Y') {

                    int pid;
                    cout << "Enter Pass ID: ";
                    cin >> pid;

                    Pass* pass = findPass(pid);

                    if (pass && pass->remainingDays > 0) {
                        cout << "Valid Pass Found. Free Parking.\n";
                        pass->remainingDays--;
                        fee = 0;
                    } else {
                        cout << "Invalid or Expired Pass.\n";
                        fee = calculateFee(role, vehicleType);
                    }

                } else {
                    fee = calculateFee(role, vehicleType);
                }
            }

            Ticket ticket(
                nextTicketId++,
                user.name,
                roleToString(user.role),
                vehicleToString(vehicleType),
                fee,
                licenseID
            );

            ticket.print();
        }
    }

    return 0;
}
