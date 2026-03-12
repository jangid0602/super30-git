// This file includes solution of Week Story - 5
// Name : Lokesh Kumar
// Date : 20/2/26
#include <iostream>
#include <map>
#include <string>
#include <vector>
#include <set>
#include <queue>
#include <unordered_map>
using namespace std;

/* NODE STRUCTURE */

class Node
{
public:
    string data;
    Node *left;
    Node *right;

    Node(string data)
    {
        this->data = data;
        left = NULL;
        right = NULL;
    }
};

/* TREE CREATION */

Node *createTree()
{
    string data;
    cin >> data;

    if (data == "-1")
        return NULL;

    Node *root = new Node(data);

    cout << "Enter left data of " << data << ": ";
    root->left = createTree();

    cout << "Enter right data of " << data << ": ";
    root->right = createTree();

    return root;
}

/*  BOUNDARY TRAVERSAL  */

class BoundaryTraverse
{

public:
    void leftTraverse(Node *root, vector<string> &ans)
    {
        if (!root || (!root->left && !root->right))
            return;

        ans.push_back(root->data);

        if (root->left)
            leftTraverse(root->left, ans);
        else
            leftTraverse(root->right, ans);
    }

    void leafTraverse(Node *root, vector<string> &ans)
    {
        if (!root)
            return;

        if (!root->left && !root->right)
        {
            ans.push_back(root->data);
            return;
        }

        leafTraverse(root->left, ans);
        leafTraverse(root->right, ans);
    }

    void rightTraverse(Node *root, vector<string> &ans)
    {
        if (!root || (!root->left && !root->right))
            return;

        if (root->right)
            rightTraverse(root->right, ans);
        else
            rightTraverse(root->left, ans);

        ans.push_back(root->data);
    }

    void run(Node *root)
    {
        vector<string> ans;

        ans.push_back(root->data);

        leftTraverse(root->left, ans);
        leafTraverse(root->left, ans);
        leafTraverse(root->right, ans);
        rightTraverse(root->right, ans);

        for (auto x : ans)
            cout << x << " ";
        cout << endl;
    }
};

/* CAMERA COVER  */

class CameraMan
{

public:
    int cameras = 0;

    int dfs(Node *node)
    {

        if (node == NULL)
            return 1;

        int left = dfs(node->left);
        int right = dfs(node->right);

        if (left == 2 || right == 2)
        {
            cameras++;
            return 0;
        }

        if (left == 0 || right == 0)
            return 1;

        return 2;
    }

    void run(Node *root)
    {

        if (dfs(root) == 2)
            cameras++;

        cout << cameras << endl;
    }
};

/* DISTANT COUSINS */

class DistantCousins
{

public:
    void run(Node *root, string x)
    {

        queue<Node *> q;
        q.push(root);

        while (!q.empty())
        {

            int size = q.size();
            bool found = false;

            vector<string> ans;

            for (int i = 0; i < size; i++)
            {

                Node *node = q.front();
                q.pop();

                if ((node->left && node->left->data == x) ||
                    (node->right && node->right->data == x))
                {

                    found = true;
                }
                else
                {

                    if (node->left)
                    {
                        q.push(node->left);
                        ans.push_back(node->left->data);
                    }

                    if (node->right)
                    {
                        q.push(node->right);
                        ans.push_back(node->right->data);
                    }
                }
            }

            if (found)
            {

                for (auto v : ans)
                    cout << v << " ";

                cout << endl;
                return;
            }
        }
    }
};

/* LONGEST PATH SUM */

class LongestPathSum
{

public:
    void solve(Node *root, int sum, int len, int k, int &maxLen)
    {

        if (!root)
            return;

        sum += stoi(root->data);
        len++;

        if (sum == k)
            maxLen = max(maxLen, len);

        solve(root->left, sum, len, k, maxLen);
        solve(root->right, sum, len, k, maxLen);
    }

    void traverse(Node *root, int k, int &maxLen)
    {

        if (!root)
            return;

        solve(root, 0, 0, k, maxLen);

        traverse(root->left, k, maxLen);
        traverse(root->right, k, maxLen);
    }

    void run(Node *root, int k)
    {

        int maxLen = 0;

        traverse(root, k, maxLen);

        cout << maxLen << endl;
    }
};

/* PALINDROMIC PATH */

class PalindromicPath
{

public:
    int dfs(Node *root, unordered_map<string, int> &mp, int odd)
    {

        if (!root)
            return 0;

        mp[root->data]++;

        if (mp[root->data] % 2)
            odd++;
        else
            odd--;

        int paths = 0;

        if (odd <= 1)
            paths++;

        paths += dfs(root->left, mp, odd);
        paths += dfs(root->right, mp, odd);

        return paths;
    }

    int countPaths(Node *root)
    {

        if (!root)
            return 0;

        int ans = 0;

        ans += countPaths(root->left);

        unordered_map<string, int> mp;
        ans += dfs(root, mp, 0);

        ans += countPaths(root->right);

        return ans;
    }

    void run(Node *root)
    {

        cout << countPaths(root) << endl;
    }
};

/* SERIALIZE / DESERIALIZE */

class TreeToString
{

public:
    string serialize(Node *root)
    {

        string s = "";
        queue<Node *> q;
        q.push(root);

        while (!q.empty())
        {

            Node *node = q.front();
            q.pop();

            if (!node)
                s += "-1,";
            else
            {
                s += node->data + ",";
                q.push(node->left);
                q.push(node->right);
            }
        }

        return s;
    }

    void run(Node *root)
    {

        string s = serialize(root);
        cout << s << endl;
    }
};

/* VERTICAL SILHOUETTE */

class VerticalSilhouette
{

public:
    void solve(Node *root, int hd, map<int, set<string>> &mp)
    {

        if (!root)
            return;

        mp[hd].insert(root->data);

        solve(root->left, hd - 1, mp);
        solve(root->right, hd + 1, mp);
    }

    void run(Node *root)
    {

        map<int, set<string>> mp;

        solve(root, 0, mp);

        for (auto g : mp)
        {

            for (auto x : g.second)
                cout << x << " ";

            cout << endl;
        }
    }
};

/* MAIN MENU */

int main()
{

    cout << "Create Tree (-1 for NULL)\n";

    Node *root = createTree();

    cout << "\nSelect Operation\n";
    cout << "1 Boundary Traversal\n";
    cout << "2 Camera Cover\n";
    cout << "3 Distant Cousins\n";
    cout << "4 Longest Path Sum\n";
    cout << "5 Palindromic Path\n";
    cout << "6 Serialize Tree\n";
    cout << "7 Vertical Silhouette\n";

    int choice;
    cin >> choice;

    if (choice == 1)
    {
        BoundaryTraverse obj;
        obj.run(root);
    }
    else if (choice == 2)
    {
        CameraMan obj;
        obj.run(root);
    }
    else if (choice == 3)
    {
        string x;
        cout << "Enter node value: ";
        cin >> x;
        DistantCousins obj;
        obj.run(root, x);
    }
    else if (choice == 4)
    {
        int k;
        cout << "Enter K: ";
        cin >> k;
        LongestPathSum obj;
        obj.run(root, k);
    }
    else if (choice == 5)
    {
        PalindromicPath obj;
        obj.run(root);
    }
    else if (choice == 6)
    {
        TreeToString obj;
        obj.run(root);
    }
    else if (choice == 7)
    {
        VerticalSilhouette obj;
        obj.run(root);
    }

    return 0;
}