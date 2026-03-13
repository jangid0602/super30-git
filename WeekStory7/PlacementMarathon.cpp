#include<iostream>
#include<vector>
using namespace std;
class PlacementMarathon {
    public:
    int compute(vector<int>& arr, int size, int gap, int prev, int cur, vector<vector<int>>& memo) {
        if(cur >= size) {
            return 0;
        }
        if(memo[prev+1][cur] != -1) {
            return memo[prev+1][cur];
        }
        int pick = 0;
        if(prev == -1 || (abs(arr[cur] - arr[prev]) == gap)) {
            pick = compute(arr, size, gap, cur, cur+1, memo) + 1;
        }
        int leave = compute(arr, size, gap, prev, cur+1, memo);
        return memo[prev+1][cur] = max(pick, leave);
    }
    int placementMarathon() {
        int size, gap;
        cout << "Enter number students and skill difference value(k):";
        cin >> size >> gap;
        vector<int> arr(size);
        cout << "Enter skill level of students:";
        for(int i = 0; i < size; i++) {
            cin >> arr[i];
        }
        vector<vector<int>> memo(size+1, vector<int>(size, -1));
        return compute(arr, size, gap, -1, 0, memo);
    }
};
int main() {
    PlacementMarathon* obj = new PlacementMarathon();
    cout << obj->placementMarathon() << endl;
    return 0;
}