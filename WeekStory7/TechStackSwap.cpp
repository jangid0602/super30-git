#include<iostream>
#include<vector>
#include<map>
#include<limits.h>
using namespace std;
class TechStackSwap {
    public:
    int solve(string& a, string& b, int p, int q, int ins, int del, int rep, vector<vector<int>>& memo) {
        int rows = a.size(), cols = b.size();
        if(p == rows && q == cols) {
            return 0;
        } else if(p == rows) {
            return (cols-q) * ins;
        } else if(q == cols) {
            return (rows-p) * del;
        }
        if(memo[p][q] != -1) {
            return memo[p][q];
        }
        if(a[p] == b[q]) {
            return memo[p][q] = solve(a, b, p+1, q+1, ins, del, rep, memo);
        } else {
            int add = solve(a, b, p, q+1, ins, del, rep, memo) + ins;
            int rem = solve(a, b, p+1, q, ins, del, rep, memo) + del;
            int swap = solve(a, b, p+1, q+1, ins, del, rep, memo) + rep;
            return memo[p][q] = min(add, min(rem, swap));
        }
    }
    int swapStacks() {
        string a, b;
        cout << "Enter tech two stacks:";
        getline(cin, a);
        getline(cin, b);
        int ins, del, rep;
        cout << "Enter insert, delete, replace cost:";
        cin >> ins >> del >> rep;
        int rows = a.size(), cols = b.size();
        vector<vector<int>> memo(rows, vector<int>(cols, -1));
        return solve(a, b, 0, 0, ins, del, rep, memo);
    }
};
int main() {
    TechStackSwap* obj = new TechStackSwap();
    cout << obj->swapStacks() << endl;
    return 0;
}