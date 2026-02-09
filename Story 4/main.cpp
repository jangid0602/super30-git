#include<iostream>
#include<vector>
#include<string>
#include<limits>

using namespace std;

class RussianDollMystery {
    // Recursive function to open dolls until the key is found
    void findKey(int size) {
        if (size == 1) {
            cout << "Smallest doll reached. Key Found!" << endl;
            return;
        }
        cout << "Opening doll of size " << size << endl;
        findKey(size - 1); // Recursive call on the inner doll
    }

public:
    void execute() {
        int initialSize;
        cout << "\nThe Russian Doll Mystery" << endl;
        cout << "Enter the size of the outermost doll: ";
        cin >> initialSize;
        
        if (initialSize <= 0) {
            cout << "Invalid size." << endl;
        } else {
            findKey(initialSize);
        }
        
        cout << "\nPress Enter to return to Story Menu...";
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cin.get();
    }
};

class StaircaseArchitect {
    int countWays(int n) {
        if (n <= 1) return 1; // Base case
        return countWays(n - 1) + countWays(n - 2); // Steps can be reached from n-1 or n-2
    }

public:
    void execute() {
        int n;
        cout << "\nThe Staircase Architect" << endl;
        cout << "Enter the number of steps (N): ";
        cin >> n;

        if (n < 0) {
            cout << "Steps cannot be negative." << endl;
        } else {
            cout << "Total ways: " << countWays(n) << endl;
        }

        cout << "\nPress Enter to return to Story Menu...";
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cin.get();
    }
};

struct PersonNode {
    int wealth;
    vector<PersonNode*> children;
    PersonNode(int w) : wealth(w) {}
};

class DigitalAncestryTree {
    int calculateLegacy(PersonNode* person) {
        if (!person) return 0;
        int total = person->wealth;
        for (PersonNode* child : person->children) {
            total += calculateLegacy(child); // Recurvsive addition of wealth
        }
        return total;
    }

public:
    void execute() {
        cout << "\nTask 3: The Digital Ancestry Tree" << endl;
        
        // Building the Test Case: A(100) -> B(50), C(50)
        PersonNode* root = new PersonNode(100);
        root->children.push_back(new PersonNode(50));
        root->children.push_back(new PersonNode(50));

        cout << "Total Legacy: " << calculateLegacy(root) << endl;

        // Cleanup
        for(auto c : root->children) delete c;
        delete root;

        cout << "\nPress Enter to return to Story Menu...";
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cin.get();
    }
};

class WordMirror {
    bool isPalindrome(string s, int start, int end) {
        if (start >= end) return true; // Base case: middle reached
        if (s[start] != s[end]) return false; // Mismatch found
        return isPalindrome(s, start + 1, end - 1); // Check inner string
    }

public:
    void execute() {
        string word;
        cout << "\nTask 4: The Word Mirror" << endl;
        cout << "Enter an ancient word to check: ";
        cin >> word;

        if (isPalindrome(word, 0, word.length() - 1)) {
            cout << word << " is a palindrome!" << endl;
        } else {
            cout << word << " is NOT a palindrome." << endl;
        }

        cout << "\nPress Enter to return to Story Menu...";
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cin.get();
    }
};

class MazeRunner {
    bool solve(int r, int c, int n, vector<vector<int>>& maze) {
        // when destination reached
        if (r == (n - 1) && c == (n - 1)) return true;

        // when moving Down
        if (r + 1 < n && maze[r + 1][c] == 1) {
            if (solve(r + 1, c, n, maze)) return true;
        }
        // when moving Right
        if (c + 1 < n && maze[r][c + 1] == 1) {
            if (solve(r, c + 1, n, maze)) return true;
        }
        return false;
    }

public:
    void execute() {
        cout << "\nTask 5: The Maze Runner" << endl;
        int n = 2;
        vector<vector<int>> maze = {{1, 0}, {1, 1}}; // Test Case

        if (solve(0, 0, n, maze)) cout << "Path Exists!" << endl;
        else cout << "Path doesn't exists" << endl;

        cout << "\nPress Enter to return to Story Menu...";
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cin.get();
    }
};

class PerfectTeamAssembly {
    void generateTeams(int idx, vector<string>& devs, vector<string>& currentTeam) {

        cout << "[ ";
        for (string s : currentTeam) cout << s << " ";
        cout << "]," << endl;

        for (int i = idx; i < devs.size(); i++) {
            currentTeam.push_back(devs[i]); // Include developer
            generateTeams(i + 1, devs, currentTeam); // Backtrack
            currentTeam.pop_back(); // Exclude developer for next branch
        }
    }

public:
    void execute() {
        vector<string> devs = {"DevA", "DevB", "DevC"}; // manual Test Case
        vector<string> current;

        cout << "\nTask 6: The Perfect Team Assembly" << endl;
        cout << "Team Combinations:" << endl;
        generateTeams(0, devs, current);

        cout << "\nPress Enter to return to Story Menu...";
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cin.get();
    }
};

class SecureVaultCode {
    void findPermutations(vector<int>& nums, int start) {
        if (start == nums.size()) {
            for (int x : nums) cout << x;
            cout << " ";
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            swap(nums[start], nums[i]);
            findPermutations(nums, start + 1);
            swap(nums[start], nums[i]); // Backtrack to original state
        }
    }

public:
    void execute() {
        vector<int> codes = {1, 2, 3}; // Test case defined by problem statement itself
        cout << "\nTask 7: The Secure Vault Code" << endl;
        cout << "Unique Vault Codes: ";
        findPermutations(codes, 0);
        cout << endl;

        cout << "\nPress Enter to return to Story Menu...";
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cin.get();
    }
};

int main() {
    int choice;
    while (true) {
        cout << "\n=== WEEK 4: RECURSION & BACKTRACKING ===" << endl;
        cout << "1. Russian Doll  2. Staircase Architect  3. Legacy Tree\n";
        cout << "4. Word Mirror   5. Maze Runner          6. Team Assembly\n";
        cout << "7. Vault Code    0. Exit \nSelection: ";
        if (!(cin >> choice)) break;

        switch (choice) {
            case 1: { RussianDollMystery obj; obj.execute(); break; }
            case 2: { StaircaseArchitect obj; obj.execute(); break; }
            case 3: { DigitalAncestryTree obj; obj.execute(); break; }
            case 4: { WordMirror obj; obj.execute(); break; }
            case 5: { MazeRunner obj; obj.execute(); break; }
            case 6: { PerfectTeamAssembly obj; obj.execute(); break; }
            case 7: { SecureVaultCode obj; obj.execute(); break; }
            case 0: return 0;
            default: cout << "Invalid Choice." << endl;
        }
    }
    return 0;
}