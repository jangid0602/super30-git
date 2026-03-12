#include<iostream>
#include<vector>
#include<map>
#include<limits.h>
using namespace std;
class OptimalServers {
    public:
    int minimumSum(vector<int>& powers, int i, int k, vector<vector<int>>& dp) {
        if(i >= powers.size()) {
            if(k == 0) return 0;
            else return 1e7;
        }
        if(k <= 0) {
            return 1e7;
        }
        if(dp[i][k] != -1) return dp[i][k];
        int minCost = INT_MAX;
        int mini = INT_MAX, maxi = INT_MIN;
        for(int j = i; j < powers.size(); j++) {
            mini = min(mini, powers[j]);
            maxi = max(maxi, powers[j]);
            int currCost = minimumSum(powers, j+1, k-1, dp) + (maxi - mini);
            minCost = min(minCost, currCost);
        }
        return dp[i][k] = minCost;
    }

    int findMinimumSum() {
        int servers, k;
        cout << "Enter number of servers and number of clusters:";
        cin >> servers >> k;
        vector<int> powers(servers);
        cout << "Enter power of each server:";
        for(int i = 0; i < servers; i++) {
            cin >> powers[i];
        }
        vector<vector<int>> dp(servers+1, vector<int>(k+1, -1));
        return minimumSum(powers, 0, k, dp);
    }
};
int main() {
    OptimalServers* servers = new OptimalServers();
    cout << servers->findMinimumSum() << endl;
    return 0;
}