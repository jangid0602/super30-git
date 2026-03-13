#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
    vector<int> weights = {15, 6, 10, 7};
    
    for (int w : weights) {
        if (w % 15 == 0) {
            cout << "Hazardous" << " ";
        }
        else if (w % 3 == 0) {
            cout << "Heavy" << " ";
        }
        else if (w % 5 == 0) {
            cout << "Fragile" << " ";
        }
        else {
            cout << w << " ";
        }
    }
    return 0;
}