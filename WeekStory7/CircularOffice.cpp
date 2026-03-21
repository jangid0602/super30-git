#include<iostream>
#include<vector>
#include<map>
#include<limits.h>
using namespace std;

class CircularOffice {
    public:
    int maxAuditValue(vector<int>& values, int cabin, int cabins, vector<int>& dp) {
        if(cabin >= cabins) return 0;
        if(dp[cabin] != -1) return dp[cabin];
        // include
        int include = maxAuditValue(values, cabin+2, cabins, dp) + values[cabin];
        // exclude
        int exclude = maxAuditValue(values, cabin+1, cabins, dp);
        return dp[cabin] = max(include, exclude);
    }

    int circularOffice() {
        int cabins;
        vector<int> values;
        cout << "Enter number of cabins:";
        cin >> cabins;
        cout << "Enter value of each cabin:";
        for(int i = 0; i < cabins; i++) {
            int value;
            cin >> value;
            values.push_back(value);
        }
        vector<int> dp1(cabins, -1), dp2(cabins, -1);
        int maxValue = max(maxAuditValue(values, 0, cabins-1, dp1), maxAuditValue(values, 1, cabins, dp2));
        return maxValue;
    }
};
int main() {
    CircularOffice* office = new CircularOffice();
    cout << office->circularOffice() << endl;
    return 0;
}