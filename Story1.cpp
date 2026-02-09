#include <bits/stdc++.h>
using namespace std;

int minDeadline(vector<int> routes) {
    if (routes.size() == 1) return routes[0];
    
    int max1 = INT_MIN, max2 = INT_MIN;
    
    for (int time : routes) {
        if (time > max1) {
            max2 = max1;
            max1 = time;
        } else if (time > max2) {
            max2 = time;
        }
    }
    
    // If removing the largest reduces deadline, return second largest
    // Else return original max
    return (max2 != INT_MIN) ? max2 : max1;
}

int main() {
    // Test cases
    cout << minDeadline({10, 5, 8, 12, 6}) << endl;  // 10
    cout << minDeadline({3, 3, 3, 3}) << endl;      // 3
    cout << minDeadline({1, 100, 2}) << endl;       // 2
    return 0;
}