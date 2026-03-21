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

class LongestPathSum {
    public:
    Node* createTree() {
        int data;
        cin >> data;
        if(data == -999) return NULL;
        Node* root = new Node(data);
        cout << "Enter left data of " << data << ":";
        root->left = createTree();
        cout << "Enter right data of " << data << ":";
        root->right = createTree();
        return root;
    }
    
    void findLength(Node* root, int sum, int length, int &maxLength, int k) {
        if(!root) {
            return ;
        }
        sum += root->data;
        length++;
        if(sum == k) {
            maxLength = max(maxLength, length);
        }
        findLength(root->left, sum, length, maxLength, k);
        findLength(root->right, sum, length, maxLength, k);
    }

    void findMaxLength(Node* root, int &maxLength, int k) {
        if(!root) return ;
        findMaxLength(root->left, maxLength, k);
        findLength(root, 0, 0, maxLength, k);
        findMaxLength(root->right, maxLength, k);
    }

    void longestPathSum() {
        Node* root = createTree();
        int k;
        cout << "Enter the values of k:";
        cin >> k;
        int maxLength = 0;
        findMaxLength(root, maxLength, k);
        cout << maxLength << endl;
    }
};

int main() {
    LongestPathSum* tree = new LongestPathSum();
    tree->longestPathSum();
    return 0;
}
