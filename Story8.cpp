#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
    vector<string> temps = {"15","22","15","30","28","31"};
    
    if (temps.empty()) {
        cout << 0 << endl;
        return 0;
    }
    
    int count = 1;
    int max_temp = stoi(temps[0]);
    
    for (int i = 1; i < temps.size(); i++) {
        int current = stoi(temps[i]);
        if (current > max_temp) {
            count++;
            max_temp = current;
        }
    }
    
    cout << count << endl;
    return 0;
}