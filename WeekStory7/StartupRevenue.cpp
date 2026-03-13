#include<iostream>
#include<vector>
using namespace std;
class StartupRevenue {
    public:
    int calc(vector<int>& arr, int pos, int len, vector<int>& memo) {
        if(pos >= len) return 0;
        if(memo[pos] != -1) return memo[pos];
        int leave = calc(arr, pos+1, len, memo);
        int val = arr[pos];
        if((pos+1)%7 == 0) val = val * 2;
        int pick = calc(arr, pos+2, len, memo) + val;
        return memo[pos] = max(leave, pick);
    }
    int findMaxRevenue() {
        int len;
        cout << "Enter number of days:";
        cin >> len;
        vector<int> arr(len);
        cout << "\nEnter revenue for each day:";
        for(int it = 0; it < len; it++) {
            cin >> arr[it];
        }
        vector<int> memo(len, -1);
        return calc(arr, 0, len, memo);
    }
};
int main() {
    StartupRevenue *obj = new StartupRevenue();
    cout << obj->findMaxRevenue() << endl;
    return 0;
}