#include <bits/stdc++.h>
using namespace std;

class Node {
    public:
    string data;
    Node* left;
    Node* right;

    Node(string data) {
        this->data = data;
        left = NULL;
        right = NULL;
    }
};

class CameraMan {
    public:
    Node* createTree() {
        string data;
        cin >> data;
        if(data == "-1") return NULL;
        Node* root = new Node(data);
        cout << "Enter left data of " << data << ":";
        root->left = createTree();
        cout << "Enter right data of " << data << ":";
        root->right = createTree();
        return root;
    }

    int cameras = 0;
    int minCameraCover(Node* root) {
        if(dfs(root) == 2) {
            cameras++;
        }
        return cameras;
    }

    int dfs(Node* node) {
        if(node == NULL) {
            return 1;
        }
        int left = dfs(node->left);
        int right = dfs(node->right);
        if(left == 2 || right == 2) {
            cameras++;
            return 0;
        }
        if(left == 0 || right == 0) {
            return 1;
        }
        return 2;
    }

    void countCameras() {
        Node* root = createTree();
        minCameraCover(root);
        cout << cameras << endl;
    }
};

int main() {
    CameraMan* tree = new CameraMan();
    tree->countCameras();
    return 0;
}

// 2 -1 3 4 -1 -1 5 -1 -1