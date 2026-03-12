#include <bits/stdc++.h>
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

class BoundaryTraverse {
    public:
    Node* createTree() {
        int data;
        cin >> data;
        if(data == -1) return NULL;
        Node* root = new Node(data);
        cout << "Enter left data of " << data << ":";
        root->left = createTree();
        cout << "Enter right data of " << data << ":";
        root->right = createTree();
        return root;
    }

    void leftTraverse(Node* root, vector<int>& traversal) {
        if(!root || (!root->left && !root->right)) return;
        traversal.push_back(root->data);
        if(!root->left) {
            leftTraverse(root->right, traversal);
        } else {
            leftTraverse(root->left, traversal);
        }
    }

    void leafTraverse(Node* root, vector<int>& traversal) {
        if(!root) return ;
        if(!root->left && !root->right) {
            traversal.push_back(root->data);
            return;
        }
        leafTraverse(root->left, traversal);
        leafTraverse(root->right, traversal);
    }

    void rightTraverse(Node* root, vector<int>& traversal) {
        if(!root || (!root->left && !root->right)) return ;
        if(!root->right) {
            rightTraverse(root->left, traversal);
        } else {
            rightTraverse(root->right, traversal);
        }
        traversal.push_back(root->data);
    }

    vector<int> boundaryTraversal(Node* root) {
        vector<int> traversal;
        leftTraverse(root, traversal);
        leafTraverse(root->left, traversal);
        leafTraverse(root->right, traversal);
        rightTraverse(root->right, traversal);
        return traversal;
    }

    void boundaryTraverse() {
        Node* root = createTree();
        vector<int> traversal = boundaryTraversal(root);
        for(auto node:traversal) cout << node << " ";
        cout << endl;
    }
};

int main() {
    BoundaryTraverse* tree = new BoundaryTraverse();
    tree->boundaryTraverse();
    return 0;
}