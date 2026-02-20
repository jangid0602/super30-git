#include <bits/stdc++.h>
using namespace std;

class TreeNode {
public:
    string value;
    TreeNode* leftChild;
    TreeNode* rightChild;

    TreeNode(string value) {
        this->value = value;
        leftChild = NULL;
        rightChild = NULL;
    }
};

class CameraSystem {
public:
    int totalCameras = 0;

    TreeNode* buildTree() {
        string value;
        cin >> value;

        if (value == "-1")
            return NULL;

        TreeNode* root = new TreeNode(value);

        cout << "Enter left child of " << value << ": ";
        root->leftChild = buildTree();

        cout << "Enter right child of " << value << ": ";
        root->rightChild = buildTree();

        return root;
    }

    int placeMinimumCameras(TreeNode* root) {
        if (checkNode(root) == 2) {
            totalCameras++;
        }
        return totalCameras;
    }

    int checkNode(TreeNode* currentNode) {
        if (currentNode == NULL) {
            return 1;  
        }

        int leftStatus = checkNode(currentNode->leftChild);
        int rightStatus = checkNode(currentNode->rightChild);

        if (leftStatus == 2 || rightStatus == 2) {
            totalCameras++;
            return 0;  
        }

        if (leftStatus == 0 || rightStatus == 0) {
            return 1;  
        }

        return 2;  
    }

    void startCounting() {
        TreeNode* root = buildTree();
        placeMinimumCameras(root);
        cout << totalCameras << endl;
    }
};

int main() {
    CameraSystem* system = new CameraSystem();
    system->startCounting();
    return 0;
}