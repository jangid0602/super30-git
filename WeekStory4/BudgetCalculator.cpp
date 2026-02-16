#include<iostream>
#include<vector>
using namespace std;

class BudgetCalculator {
    public:
    void combinationSum(vector<int>& prices, int i, int sum, int budget, vector<int>& combination) {
        if(i >= prices.size() || sum > budget) {
            return;
        }
        if(sum == budget) {
            cout << "[";
            for(int idx = 0; idx < combination.size(); idx++) {
                if(idx == combination.size()-1) cout << combination[idx];
                else cout << combination[idx] << ", ";
            }
            cout << "]";
            cout << endl;
            return;
        }

        // take
        combination.push_back(prices[i]);
        combinationSum(prices, i, sum+prices[i], budget, combination);
        combination.pop_back();
        // skip
        combinationSum(prices, i+1, sum, budget, combination);
    }

    void budgetCalculator() {
        int size, budget;
        cout << "Enter size of prices:";
        cin >> size;
        vector<int> prices(size);
        cout << "Enter prices:";
        for(int i = 0; i < size; i++) cin >> prices[i];
        cout << "Enter budget:";
        cin >> budget;
        vector<int> combination;
        combinationSum(prices, 0, 0, budget, combination);
    }
};

int main() {
    BudgetCalculator *calculator = new BudgetCalculator();
    calculator->budgetCalculator();
    return 0;
}