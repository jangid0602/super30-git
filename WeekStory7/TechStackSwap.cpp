#include<iostream>
#include<vector>
#include<map>
#include<limits.h>
using namespace std;
class TechStackSwap {
    public:
    int minimumCost(string& tech1, string& tech2, int i, int j, int insertCost, int deleteCost, int replaceCost, vector<vector<int>>& dp) {
        int n = tech1.size(), m = tech2.size();
        if(i == n && j == m) {
            return 0;
        } else if(i == n) {
            return (m-j) * insertCost;
        } else if(j == m) {
            return (n-i) * deleteCost;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(tech1[i] == tech2[j]) {
            return dp[i][j] = minimumCost(tech1, tech2, i+1, j+1, insertCost, deleteCost, replaceCost, dp);
        } else {
            int insert = minimumCost(tech1, tech2, i, j+1, insertCost, deleteCost, replaceCost, dp) + insertCost;
            int _delete = minimumCost(tech1, tech2, i+1, j, insertCost, deleteCost, replaceCost, dp) + deleteCost;
            int replace = minimumCost(tech1, tech2, i+1, j+1, insertCost, deleteCost, replaceCost, dp) + replaceCost;
            return dp[i][j] = min(insert, min(_delete, replace));
        }
    }

    int swapStacks() {
        string tech1, tech2;
        cout << "Enter tech two stacks:";
        getline(cin, tech1);
        getline(cin, tech2);
        int insertCost, deleteCost, replaceCost;
        cout << "Enter insert, delete, replace cost:";
        cin >> insertCost >> deleteCost >> replaceCost;
        int n = tech1.size(), m = tech2.size();
        vector<vector<int>> dp(n, vector<int>(m, -1));
        return minimumCost(tech1, tech2, 0, 0, insertCost, deleteCost, replaceCost, dp);
    }
};
int main() {
    TechStackSwap* techStacks = new TechStackSwap();
    cout << techStacks->swapStacks() << endl;
    return 0;
}