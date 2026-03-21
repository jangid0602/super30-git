#include<iostream>
#include<vector>
#include<algorithm>
#include<map>
#include<limits.h>
using namespace std;

class PalindromeDeployment {
    public:

    int commonSubstring(string& s, string& rev, int i, int j, vector<vector<int>>& dp) {
        int n = s.size();
        if(i == n || j == n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s[i] == rev[j]) {
            return dp[i][j] = commonSubstring(s, rev, i+1, j+1, dp) + 1;
        } else {
            int option1 = commonSubstring(s, rev, i+1, j, dp);
            int option2 = commonSubstring(s, rev, i, j+1, dp);
            return dp[i][j] = max(option1, option2);
        }
    }

    int longestPalindrome(string s) {
        int n = s.size();
        string rev = s;
        reverse(rev.begin(), rev.end());
        vector<vector<int>> dp(n, vector<int>(n, -1));
        return commonSubstring(s, rev, 0, 0, dp);
    }

    int deploy() {
        string s;
        cout << "Enter string:";
        cin >> s;
        int n = s.size();
        return n - longestPalindrome(s);
    }
};
int main() {
    PalindromeDeployment* deployment = new PalindromeDeployment();
    cout << deployment->deploy() << endl;
    return 0;
}