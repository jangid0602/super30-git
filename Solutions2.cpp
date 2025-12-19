// This file includes solution of week story - 2.5
// Name - Raj Gehlot
// Date - 19/12/25

#include<iostream>
#include<vector>
#include<string>
#include<unordered_map>
#include<unordered_set>
using namespace std;

int cosmicCourier(vector<int>& arr) {
    if(arr.size() <= 1) return arr[0];
    int mx = -1e9, smx = -1e9;
    for(int i = 0; i < arr.size(); i++) {
        if(arr[i] > mx) {
            smx = mx;
            mx = arr[i];
        } else if(arr[i] > smx && arr[i] < mx) {
            smx = arr[i];
        }
    }
    if(smx == -1e9) return mx;
    return smx;
}

class Library {
    vector<string> books;
public:
    void addBook(string s) {
        books.push_back(s);
    }

    bool equalsStr(string a, string b) {
        if(a.size() != b.size()) return false;
        for(int i = 0; i < a.size(); i++) {
            if(a[i] != b[i]) return false;
        }
        return true;
    }

    bool containsStr(string a, string b) {
        for(int i = 0; i + b.size() <= a.size(); i++) {
            int j = 0;
            while(j < b.size() && a[i + j] == b[j]) j++;
            if(j == b.size()) return true;
        }
        return false;
    }

    void searchExact(string s) {
        bool found = false;
        for(auto &b : books) {
            if(equalsStr(b, s)) {
                cout << "Book(\"" << b << "\")" << endl;
                found = true;
            }
        }
        if(!found) cout << "[]" << endl;
    }

    void searchPartial(string s) {
        bool found = false;
        for(auto &b : books) {
            if(containsStr(b, s)) {
                cout << "Book(\"" << b << "\")" << endl;
                found = true;
            }
        }
        if(!found) cout << "[]" << endl;
    }
};

vector<string> factoryFloor(vector<int>& arr) {
    vector<string> res(arr.size());
    for(int i = 0; i < arr.size(); i++) {
        if(arr[i] % 15 == 0) res[i] = "Hazardous";
        else if(arr[i] % 3 == 0) res[i] = "Heavy";
        else if(arr[i] % 5 == 0) res[i] = "Fragile";
        else res[i] = to_string(arr[i]);
    }
    return res;
}

char extraChar(string a, string b) {
    unordered_map<char,int> mp;
    for(char c : a) mp[c]++;
    for(char c : b) {
        if(mp.find(c) == mp.end()) return c;
        mp[c]--;
        if(mp[c] < 0) return c;
    }
    return ' ';
}

class Employee {
protected:
    double baseSalary;
public:
    Employee(double s) { baseSalary = s; }
    virtual double bonus() {
        return 0.10 * baseSalary;
    }
};

class Manager : public Employee {
public:
    Manager(double s) : Employee(s) {}
    double bonus() {
        return 0.25 * baseSalary + 5000;
    }
};

class Executive : public Manager {
public:
    Executive(double s) : Manager(s) {}
    double bonus() {
        return 0.50 * baseSalary + 10000;
    }
};

double totalBonus(vector<Employee*>& emp) {
    double sum = 0;
    for(auto e : emp) sum += e->bonus();
    return sum;
}

int prefixQuery(vector<int>& arr, int i, int j) {
    if(i < 0 || j >= arr.size()) return 0;
    int sum = 0;
    while(i <= j) sum += arr[i++];
    return sum;
}

string duplicateSeat(vector<vector<string>>& v) {
    unordered_set<int> st;
    for(auto &x : v) {
        int seat = stoi(x[1]);
        if(st.count(seat)) return x[0];
        st.insert(seat);
    }
    return "-1";
}

int recordTemps(vector<int>& arr) {
    if(arr.size() == 0) return 0;
    int mx = arr[0], cnt = 1;
    for(int i = 1; i < arr.size(); i++) {
        if(arr[i] > mx) {
            mx = arr[i];
            cnt++;
        }
    }
    return cnt;
}

int main() {
    Library lib;
    bool run = true;
    while(run) {
        cout << "Enter choice:\n";
        cout << "1 Cosmic Courier\n";
        cout << "2 Digital Library\n";
        cout << "3 Factory Floor\n";
        cout << "4 Spy Cipher\n";
        cout << "5 Corporate Bonus\n";
        cout << "6 Security Log\n";
        cout << "7 Concert Seat\n";
        cout << "8 Weather Station\n";
        cout << "0 Exit\n";

        int ch;
        cin >> ch;

        switch(ch) {
            case 1: {
                int n;
                cin >> n;
                vector<int> a(n);
                for(int i = 0; i < n; i++) cin >> a[i];
                cout << cosmicCourier(a) << endl;
            } break;

            case 2: {
                int n;
                cin >> n;
                cin.ignore();
                for(int i = 0; i < n; i++) {
                    string s;
                    getline(cin, s);
                    lib.addBook(s);
                }
                string q;
                getline(cin, q);
                lib.searchPartial(q);
            } break;

            case 3: {
                int n;
                cin >> n;
                vector<int> a(n);
                for(int i = 0; i < n; i++) cin >> a[i];
                vector<string> r = factoryFloor(a);
                for(auto &s : r) cout << s << " ";
                cout << endl;
            } break;

            case 4: {
                string a,b;
                cin >> a >> b;
                cout << extraChar(a,b) << endl;
            } break;

            case 5: {
                int n;
                cin >> n;
                vector<Employee*> emp;
                for(int i = 0; i < n; i++) {
                    int t;
                    double s;
                    cin >> t >> s;
                    if(t == 1) emp.push_back(new Employee(s));
                    else if(t == 2) emp.push_back(new Manager(s));
                    else emp.push_back(new Executive(s));
                }
                cout << totalBonus(emp) << endl;
            } break;

            case 6: {
                int n;
                cin >> n;
                vector<int> a(n);
                for(int i = 0; i < n; i++) cin >> a[i];
                int i,j;
                cin >> i >> j;
                cout << prefixQuery(a,i,j) << endl;
            } break;

            case 7: {
                int n;
                cin >> n;
                vector<vector<string>> v(n, vector<string>(2));
                for(int i = 0; i < n; i++) cin >> v[i][0] >> v[i][1];
                cout << duplicateSeat(v) << endl;
            } break;

            case 8: {
                int n;
                cin >> n;
                vector<int> t(n);
                for(int i = 0; i < n; i++) cin >> t[i];
                cout << recordTemps(t) << endl;
            } break;

            case 0:
                run = false;
                break;
        }
    }
    cout << "Thank You\n";
    return 0;
}
