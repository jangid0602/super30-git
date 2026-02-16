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

class DistantCousins {
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

    vector<int> findCousins(Node* root, int x) {
        vector<int> cousins;
        vector<int> heights;
        queue<Node*> q;
        int height = -1;
        int currHeight = 0;
        q.push(root);
        while(!q.empty()) {
            int size = q.size();
            currHeight++;
            for(int i = 0; i < size; i++) {
                Node* node = q.front();
                q.pop();
                if(currHeight == height) cousins.push_back(node->data);
                if((node->left && node->left->data == x) || (node->right && node->right->data == x)) {
                    height = currHeight+1;
                    continue;
                } else {
                    if(node->left) q.push(node->left);
                    if(node->right) q.push(node->right);
                }
            }
        }
        return cousins;
    }

    void distantCousins() {
        int x;
        Node* root = createTree();
        cout << "Enter node value:";
        cin >> x;
        vector<int> cousins = findCousins(root, x);
        for(auto cousin:cousins) cout << cousin << " ";
        cout << endl;
    }
};

int main() {
    DistantCousins* tree = new DistantCousins();
    tree->distantCousins();
    return 0;
}

// 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1