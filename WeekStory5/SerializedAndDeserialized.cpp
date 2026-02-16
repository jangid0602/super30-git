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

class TreeToString {
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

    string serializedTree(Node* root) {
        string serialized = "";
        queue<Node*> q;
        q.push(root);
        while(!q.empty()) {
            int size = q.size();
            for(int it = 0; it < size; it++) {
                Node* node = q.front();
                q.pop();
                if(node == NULL) serialized += "-1";
                else serialized += node->data;
                if(node != NULL) {
                    q.push(node->left);
                    q.push(node->right);
                }
                if(!q.empty()) serialized += ",";
            }
        }
        return serialized;
    }

    Node* deserializedString(string serialized) {
        int n = serialized.size();
        queue<Node*> q;
        int i = 0;
        string currNode = "";
        while(i < n && serialized[i] != ',') currNode += serialized[i++];
        i++;
        if(currNode == "-1") return NULL;

        Node* root = new Node(currNode);
        q.push(root);
        while(!q.empty()) {
            int size = q.size();
            for(int it = 0; it < size; it++) {
                Node* node = q.front();
                q.pop();

                currNode = "";
                while(i < n && serialized[i] != ',') currNode += serialized[i++];
                i++;
                if(currNode != "-1") {
                    Node* leftNode = new Node(currNode);
                    node->left = leftNode;
                    q.push(leftNode);
                }
                currNode = "";
                while(i < n && serialized[i] != ',') currNode += serialized[i++];
                i++;
                if(currNode != "-1") {
                    Node* rightNode = new Node(currNode);
                    node->right = rightNode;
                    q.push(rightNode);
                }
            }
        }
        return root;
    }

    void printTree(Node* root) {
        queue<Node*> q;
        q.push(root);
        while(!q.empty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node* node = q.front();
                q.pop();
                if(!node) continue;
                cout << node->data << " ";
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            if(!q.empty()) cout << endl;
        }
    }

    void serializedDeserialized() {
        Node* root = createTree();
        string serialized = serializedTree(root);
        cout << serialized << endl;
        Node* deserialized = deserializedString(serialized);
        printTree(deserialized);
    }
};

int main() {
    TreeToString* tree = new TreeToString();
    tree->serializedDeserialized();
    return 0;
}

// 2 -1 3 4 -1 -1 5 -1 -1