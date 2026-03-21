#include<iostream>
#include<vector>
using namespace std;

class TeamAssembly {
    public:
    vector<string> inputTeams() {
        int n;
        cout << "Enter number of teams:";
        cin >> n;
        vector<string> teams(n);
        cout << "Enter all teams:";
        for(int it = 0; it < n; it++) cin >> teams[it];
        return teams;
    }

    void teamCombinations(vector<string>& teams, int i, vector<string>& combinations) {
        if(i >= teams.size()) {
            cout << "[";
            for(int idx = 0; idx < combinations.size(); idx++) {
                if(idx == combinations.size()-1) cout << combinations[idx];
                else cout << combinations[idx] << ", ";
            }
            cout << "]";
            cout << endl;
            return;
        }

        // skip
        teamCombinations(teams, i+1, combinations);
        // take
        combinations.push_back(teams[i]);
        teamCombinations(teams, i+1, combinations);
        combinations.pop_back();
    }

    void teamAssemble() {
        vector<string> teams = inputTeams();
        vector<string> combination;
        teamCombinations(teams, 0, combination);
    }
};

int main() {
    TeamAssembly *teams = new TeamAssembly();
    teams->teamAssemble();
    return 0;
}