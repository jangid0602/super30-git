#include<iostream>
#include<vector>
using namespace std;
class MentorshipMatch {
    public:
    int findMaxScore(vector<vector<int>>& score, int mentor, int bits, vector<vector<int>>& dp) {
        int n = score.size();
        if(mentor == score.size()) {
            return 0;
        }
        if(dp[mentor][bits] != -1) {
            return dp[mentor][bits];
        }
        int maxScore = 0;
        for(int student = 0; student < n; student++) {
            if(((bits>>student)&1) == 0) { // student has not assigned a mentor yet
                bits ^= (1<<student);
                maxScore = max(maxScore, findMaxScore(score, mentor+1, bits, dp) + score[mentor][student]);
                bits ^= (1<<student);
            }
        }
        return dp[mentor][bits] = maxScore;
    }
    int mentorshipMatch() {
        int n;
        cout << "Enter number of mentor and student:";
        cin >> n;
        vector<vector<int>> score(n, vector<int>(n));
        cout << "Enter score of every student with each mentor:";
        for(int mentor = 0; mentor < n; mentor++) {
            for(int student = 0; student < n; student++) {
                cin >> score[mentor][student];
            }
        }
        int bits = 0;
        int maxi = 0;
        for(int i = 0; i < n; i++) {maxi <<= 1; maxi |= 1;}
        vector<vector<int>> dp(n, vector<int>(maxi+1, -1));
        return findMaxScore(score, 0, bits, dp);

    }
};
int main() {
    MentorshipMatch* codeup = new MentorshipMatch();
    cout << codeup->mentorshipMatch() << endl;
    return 0;
}