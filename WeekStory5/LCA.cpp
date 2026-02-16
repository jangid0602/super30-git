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

class LCA {
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

    int lca(Node* root, int &commonAncestor, set<int>& childs) {
        if(!root) return 0;
        int count = 0;
        count += lca(root->left, commonAncestor, childs);
        count += lca(root->right, commonAncestor, childs);
        if(childs.find(root->data) != childs.end()) {
            count++;
        }
        if(count == childs.size() && commonAncestor == -1) {
            commonAncestor = root->data;
        }
        return count;
    }

    void lowestCommonAncestor() {
        int n;
        set<int> childs;
        Node* root = createTree();
        cout << "Enter number of childs:";
        cin >> n;
        cout << "Enter childs values:";
        for(int i = 0; i < n; i++) {
            int child; cin >> child;
            childs.insert(child);
        }
        int commonAncestor = -1;
        lca(root, commonAncestor, childs);
        cout << commonAncestor << endl;
    }
};

int main() {
    LCA* tree = new LCA();
    tree->lowestCommonAncestor();
    return 0;
}

// 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1