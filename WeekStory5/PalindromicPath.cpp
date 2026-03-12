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

class PalindromicPath {
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

    int countPalindromicPaths(Node* root, unordered_map<string, int>& count, int oddCount) {
        if(!root) return 0;
        count[root->data]++;
        if(count[root->data]&1) {
            oddCount++;
        } else {
            oddCount--;
        }
        int paths = 0;
        if(oddCount <= 1) {
            paths++;
        }
        paths += countPalindromicPaths(root->left, count, oddCount);
        paths += countPalindromicPaths(root->right, count, oddCount);
        return paths;
    }

    int countPaths(Node* root) {
        if(!root) return 0;
        int paths = 0;
        paths += countPaths(root->left);
        unordered_map<string, int> count;
        paths += countPalindromicPaths(root, count, 0);
        paths += countPaths(root->right);
        return paths;
    }
    int palindromicPath() {
        Node* root = createTree();
        int paths = countPaths(root);
        cout << paths << endl;
    }
};

int main() {
    PalindromicPath *path = new PalindromicPath();
    path->palindromicPath();
    return 0;
}