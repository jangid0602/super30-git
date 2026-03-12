#include<iostream>
#include<vector>
using namespace std;

class BuildersBlueprint {
    public:
    vector<string> inputTasks() {
        int n;
        cout << "Enter number of tasks:";
        cin >> n;
        cin.ignore();
        vector<string> tasks(n);
        cout << "Enter parent task:";
        for(int i = 0; i < n; i++) {
            if(i > 0) cout << "Enter subtask of " << tasks[i-1] << ":";
            getline(cin, tasks[i]);
        }
        return tasks;
    }

    void printTasks(vector<string>& tasks, int i) {
        if(i >= tasks.size()) return;
        cout << tasks[i] << endl;
        printTasks(tasks, i+1);
    }

    void builderBlueprint() {
        vector<string> tasks = inputTasks();
        printTasks(tasks, 0);
    }
};

int main() {
    BuildersBlueprint *blueprint = new BuildersBlueprint();
    blueprint->builderBlueprint();
    return 0;
}