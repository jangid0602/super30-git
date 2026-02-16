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

class VerticalSilhouette {
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

    void groupNodes(Node* root, int hd, map<int, set<int>>& groups) {
        if(!root) return;
        groups[hd].insert(root->data);
        groupNodes(root->left, hd-1, groups);
        groupNodes(root->right, hd+1, groups);
    }
    
    int verticalSilhouette() {
        Node* root = createTree();
        map<int, set<int>> groups;
        groupNodes(root, 0, groups);
        for(auto group:groups) {
            for(auto node:group.second) cout << node << " ";
            cout << endl;
        }
    }
};

int main() {
    VerticalSilhouette *obj = new VerticalSilhouette();
    obj->verticalSilhouette();
    return 0;
}