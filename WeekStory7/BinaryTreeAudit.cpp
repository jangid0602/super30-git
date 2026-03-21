#include<iostream>
#include<vector>
#include<map>
#include<limits.h>
using namespace std;

class Node {
    public:
    int data;
    Node* left;
    Node* right;

    Node(int data) {
        this->data = data;
        left = NULL;
        right = NULL;
    }
};

class TreeAudit {
    public:

    Node* createTree() {
        int data;
        cin >> data;
        if(data == -1) return NULL;
        Node* root = new Node(data);
        cout << "Enter left data of " << data << ": ";
        root->left = createTree();
        cout << "Enter right data of " << data << ": ";
        root->right = createTree();
        return root;
    }

    int maxEfficiency(Node* root, bool skip, map<pair<Node*, bool>, int>& dp) {
        if(!root) return 0;
        if(dp.count({root, skip})) return dp[{root, skip}];
        int include = maxEfficiency(root->left, true, dp) + maxEfficiency(root->right, true, dp) + root->data;
        int exclude = maxEfficiency(root->left, false, dp) + maxEfficiency(root->right, false, dp);
        if(skip) { // we have to skip it
            return dp[{root, skip}] = exclude;
        } else {
            return dp[{root, skip}] = max(include, exclude);
        }
    }

    int treeAudit() {
        cout << "Enter data of binary tree:";
        Node* root = createTree();
        bool skip = false;
        map<pair<Node*, bool>, int> dp;
        return maxEfficiency(root, skip, dp);
    }
};
int main() {
    TreeAudit* tree = new TreeAudit();
    cout << tree->treeAudit() << endl;
    return 0;
}