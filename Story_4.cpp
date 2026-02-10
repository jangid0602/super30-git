// This file includes solution of Week Story - 4
// Name : Lokesh Kumar
// Date : 2/2/26
#include <iostream>
#include <vector>
#include <string>
#include <limits>
using namespace std;

/* TASK 1: NESTED DOLL SEARCH */
class NestedDollSearch
{

    void openDolls(int level)
    {
        if (level == 0)
        {
            cout << "Innermost doll reached. Key found!\n";
            return;
        }
        cout << "Opening doll level: " << level << endl;
        openDolls(level - 1);
    }

public:
    void run()
    {
        int n;
        cout << "\nTask 1: Nested Doll Search\n";
        cout << "Enter number of dolls: ";
        cin >> n;

        if (n <= 0)
            cout << "Invalid input\n";
        else
            openDolls(n);
    }
};

/* TASK 2: STAIR PATH COUNTER */
class StairPathCounter
{

    int ways(int step)
    {
        if (step <= 1)
            return 1;
        return ways(step - 1) + ways(step - 2);
    }

public:
    void run()
    {
        int n;
        cout << "\nTask 2: Stair Path Counter\n";
        cout << "Enter steps: ";
        cin >> n;

        if (n < 0)
            cout << "Invalid steps\n";
        else
            cout << "Number of ways: " << ways(n) << endl;
    }
};

/* TASK 3: FAMILY WEALTH TREE */
struct FamilyNode
{
    int money;
    vector<FamilyNode *> next;
    FamilyNode(int m) : money(m) {}
};

class FamilyWealthTree
{

    int computeSum(FamilyNode *root)
    {
        if (!root)
            return 0;
        int sum = root->money;
        for (auto child : root->next)
            sum += computeSum(child);
        return sum;
    }

public:
    void run()
    {
        cout << "\nTask 3: Family Wealth Tree\n";

        FamilyNode *head = new FamilyNode(100);
        head->next.push_back(new FamilyNode(40));
        head->next.push_back(new FamilyNode(60));

        cout << "Total Wealth: " << computeSum(head) << endl;

        for (auto c : head->next)
            delete c;
        delete head;
    }
};

/* TASK 4: PALINDROME CHECKER */
class PalindromeChecker
{

    bool check(const string &s, int l, int r)
    {
        if (l >= r)
            return true;
        if (s[l] != s[r])
            return false;
        return check(s, l + 1, r - 1);
    }

public:
    void run()
    {
        string word;
        cout << "\nTask 4: Palindrome Checker\n";
        cout << "Enter word: ";
        cin >> word;

        if (check(word, 0, word.size() - 1))
            cout << "Palindrome\n";
        else
            cout << "Not a Palindrome\n";
    }
};

/* TASK 5: GRID PATH FINDER */
class GridPathFinder
{

    bool canReach(int i, int j, vector<vector<int>> &grid)
    {
        int n = grid.size();
        if (i == n - 1 && j == n - 1)
            return true;
        if (i >= n || j >= n || grid[i][j] == 0)
            return false;

        grid[i][j] = 0; // mark visited
        return canReach(i + 1, j, grid) || canReach(i, j + 1, grid);
    }

public:
    void run()
    {
        cout << "\nTask 5: Grid Path Finder\n";

        vector<vector<int>> grid = {
            {1, 0},
            {1, 1}};

        if (canReach(0, 0, grid))
            cout << "Path Found\n";
        else
            cout << "No Path Exists\n";
    }
};

/* TASK 6: TEAM COMBINATION MAKER */
class TeamCombinationMaker
{

    void build(int idx, vector<string> &people, vector<string> &temp)
    {
        cout << "{ ";
        for (auto &x : temp)
            cout << x << " ";
        cout << "}\n";

        for (int i = idx; i < people.size(); i++)
        {
            temp.push_back(people[i]);
            build(i + 1, people, temp);
            temp.pop_back();
        }
    }

public:
    void run()
    {
        cout << "\nTask 6: Team Combination Maker\n";
        vector<string> members = {"Dev1", "Dev2", "Dev3"};
        vector<string> team;
        build(0, members, team);
    }
};

/* TASK 7: CODE PERMUTATION LOCK */
class CodePermutationLock
{

    void permute(vector<int> &nums, int pos)
    {
        if (pos == nums.size())
        {
            for (int x : nums)
                cout << x;
            cout << " ";
            return;
        }

        for (int i = pos; i < nums.size(); i++)
        {
            swap(nums[pos], nums[i]);
            permute(nums, pos + 1);
            swap(nums[pos], nums[i]);
        }
    }

public:
    void run()
    {
        cout << "\nTask 7: Code Permutation Lock\n";
        vector<int> code = {1, 2, 3};
        permute(code, 0);
        cout << endl;
    }
};

/* MAIN */
int main()
{
    int ch;

    while (true)
    {
        cout << "\n=== WEEK 4 : RECURSION & BACKTRACKING ===\n";
        cout << "1. Nested Doll Search\n";
        cout << "2. Stair Path Counter\n";
        cout << "3. Family Wealth Tree\n";
        cout << "4. Palindrome Checker\n";
        cout << "5. Grid Path Finder\n";
        cout << "6. Team Combination Maker\n";
        cout << "7. Code Permutation Lock\n";
        cout << "0. Exit\n";
        cout << "Choice: ";
        cin >> ch;

        if (ch == 0)
            break;

        switch (ch)
        {
        case 1:
        {
            NestedDollSearch o;
            o.run();
            break;
        }
        case 2:
        {
            StairPathCounter o;
            o.run();
            break;
        }
        case 3:
        {
            FamilyWealthTree o;
            o.run();
            break;
        }
        case 4:
        {
            PalindromeChecker o;
            o.run();
            break;
        }
        case 5:
        {
            GridPathFinder o;
            o.run();
            break;
        }
        case 6:
        {
            TeamCombinationMaker o;
            o.run();
            break;
        }
        case 7:
        {
            CodePermutationLock o;
            o.run();
            break;
        }
        default:
            cout << "Invalid option\n";
        }
    }

    return 0;
}
