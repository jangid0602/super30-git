#include <bits/stdc++.h>
using namespace std;

class Node {
    public:
    string data;
    Node* right;
    Node* down;

    Node(string data) {
        this->data = data;
        this->right = NULL;
        this->down = NULL;
    }
};

class ListTranspose {
    void insertIntoList(Node* &head, Node* &tail, Node* newNode) {
        if(head == NULL) {
            head = newNode;
            tail = newNode;
        } else {
            tail->right = newNode;
            tail = tail->right;
        }
    }

    void printList(Node* head) {
        while(head) {
            Node* read = head;
            while(read) {
                cout << read->data << " ";
                read = read->right;
            }
            head = head->down;
            cout << endl;
        }
    }

    Node* takeInput() {
        int rows;
        cout << "Enter number of rows:";
        cin >> rows;
        Node* firstHead = NULL;
        vector<Node*> prevNodes; // to associate current node with its parent nodes

        for(int it = 0; it < rows; it++) {
            vector<Node*> temp;
            Node* head = NULL;
            Node* tail = NULL;

            cout << "Enter values for row " << it+1 << ":" << endl;
            string data = "";
            int idx = 0;
            while(data != "-1") {
                cin >> data;
                if(data == "-1") break;
                Node* newNode = new Node(data);
                if(idx < prevNodes.size()) {
                    prevNodes[idx]->down = newNode;
                }
                insertIntoList(head, tail, newNode);
                if(!firstHead) firstHead = newNode;
                temp.push_back(newNode);
                idx++;
            }
            prevNodes = temp;
        }
        return firstHead;
    }

    void transpose(Node* &head, set<Node*> &vis) {
        if(!head || vis.count(head)) return;
        Node* right = head->right;
        Node* down = head->down;
        head->right = down;
        head->down = right;
        vis.insert(head);
        transpose(head->right, vis);
        transpose(head->down, vis);
    }

    public:
    void transposeList() {
        Node* head = takeInput();
        cout << "List before transpose:" << endl;
        printList(head);
        set<Node*> vis;
        transpose(head, vis);
        cout << "List after transpose:" << endl;
        printList(head);
    }
};