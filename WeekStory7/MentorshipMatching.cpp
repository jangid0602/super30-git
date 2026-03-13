#include<iostream>
#include<vector>
using namespace std;
class MentorshipMatch {
    public:
    int findMaxScore(vector<vector<int>>& matrix, int row, int mask, vector<vector<int>>& memo) {
        int size = matrix.size();
        if(row == matrix.size()) {
            return 0;
        }
        if(memo[row][mask] != -1) {
            return memo[row][mask];
        }
        int best = 0;
        for(int col = 0; col < size; col++) {
            if(((mask>>col)&1) == 0) {
                mask ^= (1<<col);
                best = max(best, findMaxScore(matrix, row+1, mask, memo) + matrix[row][col]);
                mask ^= (1<<col);
            }
        }
        return memo[row][mask] = best;
    }
    int mentorshipMatch() {
        int size;
        cout << "Enter number of mentor and student:";
        cin >> size;
        vector<vector<int>> matrix(size, vector<int>(size));
        cout << "Enter score of every student with each mentor:";
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                cin >> matrix[i][j];
            }
        }
        int mask = 0;
        int limit = 0;
        for(int k = 0; k < size; k++) {limit <<= 1; limit |= 1;}
        vector<vector<int>> memo(size, vector<int>(limit+1, -1));
        return findMaxScore(matrix, 0, mask, memo);
    }
};
int main() {
    MentorshipMatch* obj = new MentorshipMatch();
    cout << obj->mentorshipMatch() << endl;
    return 0;
}