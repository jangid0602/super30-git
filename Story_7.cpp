// This file includes solution of Week Story - 7
// Name : Lokesh Kumar
// Date : 13/3/26
#include<iostream>
#include<vector>
#include<limits.h>
#include<stdexcept>
#include<string>
using namespace std;

class MentorshipMatch {
public:
    int findMaxScore(vector<vector<int>>& score, int mentor, int bits, vector<vector<int>>& dp) {
        int n = score.size();
        if (mentor == n) return 0;
        if (dp[mentor][bits] != -1) return dp[mentor][bits];
        int maxScore = 0;
        for (int student = 0; student < n; student++) {
            if (((bits >> student) & 1) == 0) {
                bits ^= (1 << student);
                int gained = score[mentor][student];
                if (mentor == student) gained += (int)(gained * 0.1);
                maxScore = max(maxScore, findMaxScore(score, mentor + 1, bits, dp) + gained);
                bits ^= (1 << student);
            }
        }
        return dp[mentor][bits] = maxScore;
    }

    int mentorshipMatch() {
        int n;
        cout << "\n[Mentorship Match]\n";
        cout << "Enter number of mentors/students: ";
        if (!(cin >> n) || n <= 0 || n > 20) {
            cin.clear(); cin.ignore(1000, '\n');
            throw invalid_argument("Must be between 1 and 20.");
        }
        vector<vector<int>> score(n, vector<int>(n));
        cout << "Enter score matrix (" << n << "x" << n << "):\n";
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (!(cin >> score[i][j]) || score[i][j] < 0) {
                    cin.clear(); cin.ignore(1000, '\n');
                    throw invalid_argument("Invalid score value.");
                }
            }
        int bits = 0, maxi = (1 << n) - 1;
        vector<vector<int>> dp(n, vector<int>(maxi + 1, -1));
        return findMaxScore(score, 0, bits, dp);
    }
};

class OptimalServers {
public:
    int minimumSum(vector<int>& powers, int i, int k, vector<vector<int>>& dp) {
        int sz = powers.size();
        if (k == 0) {
            if (i >= sz) return 0;
            int mini = INT_MAX, maxi = INT_MIN;
            for (int x = i; x < sz; x++) { mini = min(mini, powers[x]); maxi = max(maxi, powers[x]); }
            return maxi - mini;
        }
        if (i >= sz) return 0;
        if (dp[i][k] != -1) return dp[i][k];
        int minCost = INT_MAX, mini = INT_MAX, maxi = INT_MIN;
        for (int j = i; j < sz; j++) {
            mini = min(mini, powers[j]); maxi = max(maxi, powers[j]);
            int sub = minimumSum(powers, j + 1, k - 1, dp);
            if (sub != INT_MAX) minCost = min(minCost, sub + (maxi - mini));
        }
        return dp[i][k] = minCost;
    }

    int findMinimumSum() {
        int servers, k;
        cout << "\n[Optimal Servers]\n";
        cout << "Enter number of servers: ";
        if (!(cin >> servers) || servers <= 0) {
            cin.clear(); cin.ignore(1000, '\n');
            throw invalid_argument("Server count must be positive.");
        }
        cout << "Enter number of clusters: ";
        if (!(cin >> k) || k <= 0 || k > servers) {
            cin.clear(); cin.ignore(1000, '\n');
            throw invalid_argument("Cluster count must be between 1 and server count.");
        }
        vector<int> powers(servers);
        cout << "Enter power of each server:\n";
        for (int i = 0; i < servers; i++) {
            if (!(cin >> powers[i])) {
                cin.clear(); cin.ignore(1000, '\n');
                throw invalid_argument("Invalid power value.");
            }
        }
        vector<vector<int>> dp(servers + 1, vector<int>(k + 1, -1));
        return minimumSum(powers, 0, k, dp);
    }
};

class PlacementMarathon {
public:
    int longestSequence(vector<int>& skills, int n, int k, int prevIdx, int i, vector<vector<int>>& dp) {
        if (i >= n) return 0;
        if (dp[prevIdx + 1][i] != -1) return dp[prevIdx + 1][i];
        int take = 0;
        if (prevIdx == -1 || abs(skills[i] - skills[prevIdx]) == k)
            take = longestSequence(skills, n, k, i, i + 1, dp) + 1 + (i % 2);
        int skip = longestSequence(skills, n, k, prevIdx, i + 1, dp);
        return dp[prevIdx + 1][i] = max(take, skip);
    }

    int placementMarathon() {
        int n, k;
        cout << "\n[Placement Marathon]\n";
        cout << "Enter number of students: ";
        if (!(cin >> n) || n <= 0) {
            cin.clear(); cin.ignore(1000, '\n');
            throw invalid_argument("Student count must be positive.");
        }
        cout << "Enter skill difference (k): ";
        if (!(cin >> k) || k < 0) {
            cin.clear(); cin.ignore(1000, '\n');
            throw invalid_argument("k must be non-negative.");
        }
        vector<int> skills(n);
        cout << "Enter skill levels:\n";
        for (int i = 0; i < n; i++) {
            if (!(cin >> skills[i])) {
                cin.clear(); cin.ignore(1000, '\n');
                throw invalid_argument("Invalid skill value.");
            }
        }
        vector<vector<int>> dp(n + 1, vector<int>(n, -1));
        return longestSequence(skills, n, k, -1, 0, dp);
    }
};

class StartupRevenue {
public:
    int maxRevenue(vector<int>& revenue, int index, int days, vector<int>& dp) {
        if (index >= days) return 0;
        if (dp[index] != -1) return dp[index];
        int skip = maxRevenue(revenue, index + 1, days, dp);
        int curr = revenue[index];
        if ((index + 1) % 7 == 0) curr *= 2;
        if (curr > 0 && (index + 1) % 3 == 0) curr = (int)(curr * 1.5);
        int take = maxRevenue(revenue, index + 2, days, dp) + curr;
        return dp[index] = max(skip, take);
    }

    int findMaxRevenue() {
        int days;
        cout << "\n[Startup Revenue]\n";
        cout << "Enter number of days: ";
        if (!(cin >> days) || days <= 0) {
            cin.clear(); cin.ignore(1000, '\n');
            throw invalid_argument("Days must be positive.");
        }
        vector<int> revenue(days);
        cout << "Enter revenue for each day:\n";
        for (int i = 0; i < days; i++) {
            if (!(cin >> revenue[i])) {
                cin.clear(); cin.ignore(1000, '\n');
                throw invalid_argument("Invalid revenue value.");
            }
        }
        vector<int> dp(days, -1);
        return maxRevenue(revenue, 0, days, dp);
    }
};

class TechStackSwap {
    bool isVowel(char c) {
        c = tolower(c);
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
public:
    int minimumCost(string& t1, string& t2, int i, int j, int ins, int del, int rep, vector<vector<int>>& dp) {
        int n = t1.size(), m = t2.size();
        if (i == n && j == m) return 0;
        if (i == n) return (m - j) * ins;
        if (j == m) return (n - i) * del;
        if (dp[i][j] != -1) return dp[i][j];
        if (t1[i] == t2[j] || (isVowel(t1[i]) && isVowel(t2[j])))
            return dp[i][j] = minimumCost(t1, t2, i+1, j+1, ins, del, rep, dp);
        int a = minimumCost(t1, t2, i,   j+1, ins, del, rep, dp) + ins;
        int b = minimumCost(t1, t2, i+1, j,   ins, del, rep, dp) + del;
        int c = minimumCost(t1, t2, i+1, j+1, ins, del, rep, dp) + rep;
        return dp[i][j] = min({a, b, c});
    }

    int swapStacks() {
        cout << "\n[Tech Stack Swap]\n";
        cin.ignore();
        string t1, t2;
        cout << "Enter first stack: ";
        if (!getline(cin, t1) || t1.empty()) throw invalid_argument("First stack cannot be empty.");
        cout << "Enter second stack: ";
        if (!getline(cin, t2) || t2.empty()) throw invalid_argument("Second stack cannot be empty.");
        int ins, del, rep;
        cout << "Enter insert, delete, replace cost: ";
        if (!(cin >> ins >> del >> rep) || ins < 0 || del < 0 || rep < 0) {
            cin.clear(); cin.ignore(1000, '\n');
            throw invalid_argument("Costs must be non-negative.");
        }
        int n = t1.size(), m = t2.size();
        vector<vector<int>> dp(n, vector<int>(m, -1));
        return minimumCost(t1, t2, 0, 0, ins, del, rep, dp);
    }
};

int main() {
    cout << "1. Mentorship Match\n";
    cout << "2. Optimal Servers\n";
    cout << "3. Placement Marathon\n";
    cout << "4. Startup Revenue\n";
    cout << "5. Tech Stack Swap\n";
    cout << "0. Exit\n";

    int choice;
    while (true) {
        cout << "\nChoose (0-5): ";
        if (!(cin >> choice)) {
            cin.clear(); cin.ignore(1000, '\n');
            cerr << "Invalid input.\n";
            continue;
        }
        if (choice == 0) break;
        try {
            int result = 0;
            if      (choice == 1) { MentorshipMatch   obj; result = obj.mentorshipMatch();   }
            else if (choice == 2) { OptimalServers     obj; result = obj.findMinimumSum();    }
            else if (choice == 3) { PlacementMarathon  obj; result = obj.placementMarathon(); }
            else if (choice == 4) { StartupRevenue     obj; result = obj.findMaxRevenue();    }
            else if (choice == 5) { TechStackSwap      obj; result = obj.swapStacks();        }
            else { cerr << "Enter 0-5.\n"; continue; }
            cout << "Result: " << result << "\n";
        }
        catch (const exception& e) {
            cerr << "Error: " << e.what() << "\n";
        }
    }
    return 0;
}