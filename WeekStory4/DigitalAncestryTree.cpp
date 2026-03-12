#include<iostream>
using namespace std;

class Node {
    public:
    int data;
    Node* left;
    Node* right;

    Node(int data) {
        this->data = data;
        this->left = NULL;
        this->right = NULL;
    }
};

class AncestryTree {
    public:
    Node* takeInput() {
        int data;
        cin >> data;
        if(data == -1) {
            return NULL;
        } else {
            Node* root = new Node(data);
            cout << "Enter left data of " << data << ":";
            root->left = takeInput();
            cout << "Enter right data of " << data << ":";
            root->right = takeInput();
            return root;
        }
    }

    int digitalTree(Node* node) {
        if(!node) return 0;
        return digitalTree(node->left) + node->data + digitalTree(node->right);
    }

    void ancestryTree() {
        Node* root = takeInput();
        cout << digitalTree(root) << endl;
    }
};

int main() {
    AncestryTree *tree = new AncestryTree();
    tree->ancestryTree();
    return 0;
}