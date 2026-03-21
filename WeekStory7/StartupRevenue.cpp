#include<iostream>
#include<vector>
using namespace std;
class StartupRevenue {
    public:
    int maxRevenue(vector<int>& revenue, int index, int days, vector<int>& dp) {
        if(index >= days) return 0;
        if(dp[index] != -1) return dp[index];
        int skip = maxRevenue(revenue, index+1, days, dp);
        int currRevenue = revenue[index];
        if((index+1)%7 == 0) currRevenue = currRevenue * 2;
        int take = maxRevenue(revenue, index+2, days, dp) + currRevenue;
        return dp[index] = max(skip, take);
    }

    int findMaxRevenue() {
        int days;
        cout << "Enter number of days:";
        cin >> days;
        vector<int> revenue(days);
        cout << "\nEnter revenue for each day:";
        for(int it = 0; it < days; it++) {
            cin >> revenue[it];
        }
        vector<int> dp(days, -1);
        return maxRevenue(revenue, 0, days, dp);
    }
};
int main() {
    StartupRevenue *startup = new StartupRevenue();
    cout << startup->findMaxRevenue() << endl;
    return 0;
}