#include <bits/stdc++.h>
using namespace std;

class TreeNode {
public:
    int value;
    TreeNode* lchild;
    TreeNode* rchild;

    TreeNode(int val) {
        value = val;
        lchild = nullptr;
        rchild = nullptr;
    }
};

class TreeBoundary {

public:

    TreeNode* buildTree() {
        int val;
        cin >> val;

        if(val == -1) return nullptr;

        TreeNode* node = new TreeNode(val);

        cout << "Left of " << val << ": ";
        node->lchild = buildTree();

        cout << "Right of " << val << ": ";
        node->rchild = buildTree();

        return node;
    }

    void collectLeft(TreeNode* node, vector<int>& result) {
        if(node == nullptr) return;
        if(node->lchild == nullptr && node->rchild == nullptr) return;

        result.push_back(node->value);

        if(node->lchild)
            collectLeft(node->lchild, result);
        else
            collectLeft(node->rchild, result);
    }

    void collectLeaves(TreeNode* node, vector<int>& result) {
        if(node == nullptr) return;

        collectLeaves(node->lchild, result);
        collectLeaves(node->rchild, result);

        if(node->lchild == nullptr && node->rchild == nullptr)
            result.push_back(node->value);
    }

    void collectRight(TreeNode* node, vector<int>& result) {
        if(node == nullptr) return;
        if(node->lchild == nullptr && node->rchild == nullptr) return;

        if(node->rchild)
            collectRight(node->rchild, result);
        else
            collectRight(node->lchild, result);

        result.push_back(node->value);
    }

    vector<int> getBoundary(TreeNode* root) {
        vector<int> answer;

        if(root == nullptr) return answer;

        answer.push_back(root->value);

        collectLeft(root->lchild, answer);
        collectLeaves(root->lchild, answer);
        collectLeaves(root->rchild, answer);
        collectRight(root->rchild, answer);

        return answer;
    }

    void execute() {
        TreeNode* rootNode = buildTree();
        vector<int> output = getBoundary(rootNode);

        for(int x : output)
            cout << x << " ";
        cout << endl;
    }
};

int main() {
    TreeBoundary obj;
    obj.execute();
    return 0;
}
