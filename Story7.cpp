#include <iostream>
#include <vector>
#include <string>
#include <map>
using namespace std;

int main() {
    vector<pair<string, int>> requests = {{"C1",101}, {"C2",105}, {"C3",101}};
    
    map<int, string> booked;
    
    for (auto req : requests) {
        if (booked.count(req.second)) {
            cout << req.first << endl;
            return 0;
        }
        booked[req.second] = req.first;
    }
    cout << -1 << endl;
    return 0;
}