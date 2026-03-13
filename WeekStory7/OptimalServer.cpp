#include<iostream>
#include<vector>
#include<map>
#include<limits.h>
using namespace std;
class OptimalServers {
    public:
    int calcMin(vector<int>& arr, int idx, int groups, vector<vector<int>>& memo) {
        if(idx >= arr.size()) {
            if(groups == 0) return 0;
            else return 1e7;
        }
        if(groups <= 0) {
            return 1e7;
        }
        if(memo[idx][groups] != -1) return memo[idx][groups];
        int result = INT_MAX;
        int lo = INT_MAX, hi = INT_MIN;
        for(int end = idx; end < arr.size(); end++) {
            lo = min(lo, arr[end]);
            hi = max(hi, arr[end]);
            int val = calcMin(arr, end+1, groups-1, memo) + (hi - lo);
            result = min(result, val);
        }
        return memo[idx][groups] = result;
    }
    int findMinimumSum() {
        int total, grp;
        cout << "Enter number of servers and number of clusters:";
        cin >> total >> grp;
        vector<int> arr(total);
        cout << "Enter power of each server:";
        for(int i = 0; i < total; i++) {
            cin >> arr[i];
        }
        vector<vector<int>> memo(total+1, vector<int>(grp+1, -1));
        return calcMin(arr, 0, grp, memo);
    }
};
int main() {
    OptimalServers* obj = new OptimalServers();
    cout << obj->findMinimumSum() << endl;
    return 0;
}