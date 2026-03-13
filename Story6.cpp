#include <iostream>
#include <vector>
using namespace std;

vector<int> prefix;

void preprocess(vector<int> logins) {
    prefix.push_back(0);
    for (int x : logins) {
        prefix.push_back(prefix.back() + x);
    }
}

int query(int i, int j) {
    return prefix[j + 1] - prefix[i];
}

int main() {
    vector<int> logins = {10, 50, 20, 80, 15};
    preprocess(logins);
    
    cout << query(1, 3) << endl;  // 150
    
    return 0;
}