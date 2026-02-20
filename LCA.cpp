#include <bits/stdc++.h>
using namespace std;

class Node {
public:
    int data;
    Node* left;
    Node* right;

    Node(int val) {
        data = val;
        left = NULL;
        right = NULL;
    }
};

class MultiLCA {

public:

    Node* buildTree() {
        int val;
        cin >> val;

        if(val == -1) return NULL;

        Node* temp = new Node(val);

        cout << "Enter left of " << val << ": ";
        temp->left = buildTree();

        cout << "Enter right of " << val << ": ";
        temp->right = buildTree();

        return temp;
    }

    Node* solveLCA(Node* root, unordered_set<int>& nodesSet, int& matchedCount) {
        if(root == NULL) return NULL;

        Node* leftNode = solveLCA(root->left, nodesSet, matchedCount);
        Node* rightNode = solveLCA(root->right, nodesSet, matchedCount);

        if(nodesSet.find(root->data) != nodesSet.end()) {
            matchedCount++;
            return root;
        }

        if(leftNode && rightNode) return root;

        if(leftNode) return leftNode;
        if(rightNode) return rightNode;

        return NULL;
    }

    void findLowestCommonAncestor() {

        Node* rootNode = buildTree();

        int m;
        cout << "Enter number of nodes in set: ";
        cin >> m;

        unordered_set<int> requiredNodes;
        cout << "Enter node values: ";

        for(int i = 0; i < m; i++) {
            int x;
            cin >> x;
            requiredNodes.insert(x);
        }

        int foundCount = 0;
        Node* result = solveLCA(rootNode, requiredNodes, foundCount);

        if(foundCount == requiredNodes.size() && result != NULL)
            cout << result->data << endl;
        else
            cout << -1 << endl;   // if all nodes not present
    }
};

int main() {
    MultiLCA obj;
    obj.findLowestCommonAncestor();
    return 0;
}
