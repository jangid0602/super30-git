#include<iostream>
#include<vector>
using namespace std;
class PlacementMarathon {
    public:
    int longestSequence(vector<int>& skills, int n, int k, int prevIdx, int i, vector<vector<int>>& dp) {
        if(i >= n) {
            return 0;
        }
        if(dp[prevIdx+1][i] != -1) {
            return dp[prevIdx+1][i];
        }
        int take = 0;
        if(prevIdx == -1 || (abs(skills[i] - skills[prevIdx]) == k)) {
            take = longestSequence(skills, n, k, i, i+1, dp) + 1;
        }
        int skip = longestSequence(skills, n, k, prevIdx, i+1, dp);
        return dp[prevIdx+1][i] = max(take, skip);
    }

    int placementMarathon() {
        int n, k;
        cout << "Enter number students and skill difference value(k):";
        cin >> n >> k;
        vector<int> skills(n);
        cout << "Enter skill level of students:";
        for(int i = 0; i < n; i++) {
            cin >> skills[i];
        }
        vector<vector<int>> dp(n+1, vector<int>(n, -1));
        return longestSequence(skills, n, k, -1, 0, dp);
    }
};
int main() {
    PlacementMarathon* obj = new PlacementMarathon();
    cout << obj->placementMarathon() << endl;
    return 0;
}