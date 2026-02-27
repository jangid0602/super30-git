#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <map>
#include <string>
using namespace std;

struct TreeNode
{
    int value;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int val)
    {
        value = val;
        left = NULL;
        right = NULL;
    }
};

TreeNode* buildTree(vector<int>& arr, int i)
{
    TreeNode* root = NULL;
    if (i < arr.size() && arr[i] != -1)
    {
        root = new TreeNode(arr[i]);
        root->left = buildTree(arr, 2 * i + 1);
        root->right = buildTree(arr, 2 * i + 2);
    }
    return root;
}

struct CharTreeNode
{
    char ch;
    CharTreeNode* left;
    CharTreeNode* right;
    CharTreeNode(char c)
    {
        ch = c;
        left = NULL;
        right = NULL;
    }
};

CharTreeNode* buildCharTree(vector<char>& arr, int i)
{
    CharTreeNode* root = NULL;
    if (i < arr.size() && arr[i] != -1)
    {
        root = new CharTreeNode(arr[i]);
        root->left = buildCharTree(arr, 2 * i + 1);
        root->right = buildCharTree(arr, 2 * i + 2);
    }
    return root;
}

struct HdNode
{
    int hdValue;
    TreeNode* node;
    HdNode(int hd, TreeNode* n)
    {
        hdValue = hd;
        node = n;
    }
};

vector<vector<int>> getTopView(TreeNode* root)
{
    vector<vector<int>> result;
    if (root == NULL)
    {
        return result;
    }
    queue<HdNode> q;
    q.push(HdNode(0, root));
    map<int, vector<int>> mp;
    while (!q.empty())
    {
        HdNode current = q.front();
        q.pop();
        mp[current.hdValue].push_back(current.node->value);
        if (current.node->left != NULL)
        {
            q.push(HdNode(current.hdValue - 1, current.node->left));
        }
        if (current.node->right != NULL)
        {
            q.push(HdNode(current.hdValue + 1, current.node->right));
        }
    }
    map<int, vector<int>>::iterator it;
    for (it = mp.begin(); it != mp.end(); it++)
    {
        result.push_back(it->second);
    }
    return result;
}

void serializeHelper(TreeNode* node, string& output)
{
    if (node == NULL)
    {
        output += "null,";
        return;
    }
    output += to_string(node->value) + ",";
    serializeHelper(node->left, output);
    serializeHelper(node->right, output);
}

string serialize(TreeNode* root)
{
    string output = "";
    serializeHelper(root, output);
    return output;
}

TreeNode* deserializeHelper(queue<string>& tokens)
{
    string val = tokens.front();
    tokens.pop();
    if (val == "null")
    {
        return NULL;
    }
    TreeNode* node = new TreeNode(stoi(val));
    node->left = deserializeHelper(tokens);
    node->right = deserializeHelper(tokens);
    return node;
}

TreeNode* deserialize(string data)
{
    queue<string> tokens;
    string current = "";
    for (int i = 0; i < data.size(); i++)
    {
        if (data[i] == ',')
        {
            tokens.push(current);
            current = "";
        }
        else
        {
            current += data[i];
        }
    }
    return deserializeHelper(tokens);
}

void getMaxPath(TreeNode* root, vector<int>& current, int target, vector<vector<int>>& totalAns)
{
    if (root == NULL)
    {
        return;
    }
    current.push_back(root->value);
    target -= root->value;
    if (target == 0)
    {
        totalAns.push_back(current);
    }
    getMaxPath(root->left, current, target, totalAns);
    getMaxPath(root->right, current, target, totalAns);
    target += current[current.size() - 1];
    current.pop_back();
}

bool isLeaf(TreeNode* node)
{
    return node->left == NULL && node->right == NULL;
}

void addLeftBoundary(TreeNode* node, vector<int>& result)
{
    while (node != NULL)
    {
        if (!isLeaf(node))
        {
            result.push_back(node->value);
        }
        if (node->left != NULL)
        {
            node = node->left;
        }
        else
        {
            node = node->right;
        }
    }
}

void addRightBoundary(TreeNode* node, vector<int>& result)
{
    stack<int> st;
    while (node != NULL)
    {
        if (!isLeaf(node))
        {
            st.push(node->value);
        }
        if (node->right != NULL)
        {
            node = node->right;
        }
        else
        {
            node = node->left;
        }
    }
    while (!st.empty())
    {
        result.push_back(st.top());
        st.pop();
    }
}

void addLeaves(TreeNode* node, vector<int>& result)
{
    if (node == NULL)
    {
        return;
    }
    if (isLeaf(node))
    {
        result.push_back(node->value);
        return;
    }
    addLeaves(node->left, result);
    addLeaves(node->right, result);
}

vector<int> getBoundary(TreeNode* root)
{
    vector<int> result;
    if (root == NULL)
    {
        return result;
    }
    result.push_back(root->value);
    addLeftBoundary(root->left, result);
    addLeaves(root->left, result);
    addLeaves(root->right, result);
    addRightBoundary(root->right, result);
    return result;
}

int getLCA(TreeNode* root)
{
    vector<vector<int>> levels;
    if (root == NULL)
    {
        return 0;
    }
    queue<TreeNode*> q;
    q.push(root);
    while (!q.empty())
    {
        vector<int> level;
        int n = q.size();
        for (int i = 0; i < n; i++)
        {
            TreeNode* current = q.front();
            q.pop();
            if (current != NULL)
            {
                level.push_back(current->value);
            }
            if (current->left != NULL)
            {
                q.push(current->left);
            }
            if (current->right != NULL)
            {
                q.push(current->right);
            }
        }
        levels.push_back(level);
    }
    int ans = -1;
    for (int i = levels.size() - 1; i >= 0; i--)
    {
        int temp = levels[i][0];
        bool allSame = true;
        for (int j = 0; j < levels[i].size(); j++)
        {
            if (temp != levels[i][j])
            {
                allSame = false;
                break;
            }
        }
        if (allSame)
        {
            ans = temp;
            break;
        }
    }
    return ans;
}

void printVector(vector<int>& v)
{
    cout << "[";
    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i];
        if (i != v.size() - 1)
        {
            cout << ", ";
        }
    }
    cout << "]" << endl;
}

void print2DVector(vector<vector<int>>& v)
{
    cout << "[";
    for (int i = 0; i < v.size(); i++)
    {
        cout << "[";
        for (int j = 0; j < v[i].size(); j++)
        {
            cout << v[i][j];
            if (j != v[i].size() - 1)
            {
                cout << ", ";
            }
        }
        cout << "]";
        if (i != v.size() - 1)
        {
            cout << ", ";
        }
    }
    cout << "]" << endl;
}

int main()
{
    int choice;
    cout << "Select a question to run:" << endl;
    cout << "2 - Top View of Tree" << endl;
    cout << "5 - Serialize / Deserialize" << endl;
    cout << "6 - Path Sum" << endl;
    cout << "7 - Boundary Traversal" << endl;
    cout << "8 - LCA via Level Order" << endl;
    cout << "Enter choice: ";
    cin >> choice;
    cin.ignore();
    vector<int> list;
    string line;
    cout << "Enter tree values one by one (-1 for null, blank line to stop):" << endl;
    while (true)
    {
        cout << "Value: ";
        getline(cin, line);
        if (line.empty())
        {
            break;
        }
        list.push_back(stoi(line));
    }
    TreeNode* root = buildTree(list, 0);
    if (choice == 2)
    {
        vector<vector<int>> result = getTopView(root);
        cout << "Top View: ";
        print2DVector(result);
    }
    else if (choice == 5)
    {
        string serialized = serialize(root);
        cout << "Serialized: " << serialized << endl;
        TreeNode* newRoot = deserialize(serialized);
        if (newRoot != NULL)
        {
            cout << "Deserialization successful: true" << endl;
        }
        else
        {
            cout << "Deserialization successful: false" << endl;
        }
    }
    else if (choice == 6)
    {
        int target;
        cout << "Enter target sum: ";
        cin >> target;
        cin.ignore();
        vector<int> current;
        vector<vector<int>> result;
        getMaxPath(root, current, target, result);
        cout << "Paths with target sum:" << endl;
        print2DVector(result);
    }
    else if (choice == 7)
    {
        vector<int> result = getBoundary(root);
        cout << "Boundary: ";
        printVector(result);
    }
    else if (choice == 8)
    {
        int result = getLCA(root);
        cout << "LCA Result: " << result << endl;
    }
    else
    {
        cout << "Invalid choice." << endl;
    }
    return 0;
}
