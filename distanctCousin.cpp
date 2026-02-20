#include <bits/stdc++.h>
using namespace std;

class TreeNode {
public:
    int value;
    TreeNode* leftChild;
    TreeNode* rightChild;

    TreeNode(int value) {
        this->value = value;
        leftChild = NULL;
        rightChild = NULL;
    }
};

class CousinFinder {
public:
    TreeNode* buildTree() {
        int value;
        cin >> value;

        if (value == -1)
            return NULL;

        TreeNode* root = new TreeNode(value);

        cout << "Enter left child of " << value << ": ";
        root->leftChild = buildTree();

        cout << "Enter right child of " << value << ": ";
        root->rightChild = buildTree();

        return root;
    }

    vector<int> getCousins(TreeNode* root, int targetValue) {
        vector<int> cousinList;
        queue<TreeNode*> nodeQueue;

        int targetLevel = -1;
        int currentLevel = 0;

        nodeQueue.push(root);

        while (!nodeQueue.empty()) {
            int levelSize = nodeQueue.size();
            currentLevel++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode* currentNode = nodeQueue.front();
                nodeQueue.pop();

                if (currentLevel == targetLevel)
                    cousinList.push_back(currentNode->value);

                if ((currentNode->leftChild && currentNode->leftChild->value == targetValue) ||
                    (currentNode->rightChild && currentNode->rightChild->value == targetValue)) {

                    targetLevel = currentLevel + 1;
                    continue;  
                }

                if (currentNode->leftChild)
                    nodeQueue.push(currentNode->leftChild);

                if (currentNode->rightChild)
                    nodeQueue.push(currentNode->rightChild);
            }
        }

        return cousinList;
    }

    void startFindingCousins() {
        int targetValue;

        TreeNode* root = buildTree();

        cout << "Enter node value: ";
        cin >> targetValue;

        vector<int> cousins = getCousins(root, targetValue);

        for (int cousin : cousins)
            cout << cousin << " ";

        cout << endl;
    }
};

int main() {
    CousinFinder* tree = new CousinFinder();
    tree->startFindingCousins();
    return 0;
}