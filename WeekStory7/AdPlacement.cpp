#include<iostream>
#include<vector>
#include<map>
#include<limits.h>
using namespace std;
class AdPlacement {
    public:
    double maxProfit(vector<pair<int, int>>& ads, int ad, int time, int fact, map<vector<int>, double>& dp) {
        int n = ads.size();
        if(ad == n) {
            if(time < 0) return -1e7;
            else return 0;
        }
        if(time < 0) return -1e7;
        vector<int> info = {ad, time, fact};
        if(dp.count(info)) {
            return dp[info];
        }

        // include
        double include = maxProfit(ads, ad, time-ads[ad].first, fact*2, dp) + (double(ads[ad].second) / fact);
        double exclude = maxProfit(ads, ad+1, time, fact, dp);
        return dp[info] = max(include, exclude);
    }

    double placeAd() {
        int time, n;
        vector<pair<int, int>> ads;
        cout << "Enter video duration(time):";
        cin >> time;
        cout << "Enter number of ads:";
        cin >> n;
        cout << "Enter duration and profit for each ad:";
        for(int i = 0; i < n; i++) {
            int t, prof;
            cin >> t >> prof;
            ads.push_back({t, prof});
        }
        int fact = 1; // dividing the profit with current factor
        map<vector<int>, double> dp;
        return maxProfit(ads, 0, time, fact, dp);
    }
};
int main() {
    AdPlacement* codeup = new AdPlacement();
    cout << codeup->placeAd() << endl;
    return 0;
}