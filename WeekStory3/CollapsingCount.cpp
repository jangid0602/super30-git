#include <bits/stdc++.h>
using namespace std;

class Node {
    public:
    string data;
    int count;
    Node* next;

    Node(string data, int count) {
        this->data = data;
        this->count = count;
        next = NULL;
    }
};

class CollapsingCount {
    public:
    void collapseCount() {
        Node* head = NULL;
        Node* tail = NULL;
        takeInput(head, tail);
        Node* node = head;
        while(node != NULL) {
            while(node->next && node->data == node->next->data) {
                node->count += node->next->count;
                node->next = node->next->next;
            }
            node = node->next;
        }
        printList(head);
    }

    void insertIntoNode(Node* &head, Node* &tail, string data, int count) {
        Node* newNode = new Node(data, count);
        if(head == NULL) {
            head = newNode;
            tail = newNode;
        } else {
            tail->next = newNode;
            tail = tail->next;
        }
    }
    
    void takeInput(Node* &head, Node* &tail) {
        string data = "";
        int count = 0;
        while(data != "-1") {
            cin >> data;
            cin >> count;
            if(data != "-1") insertIntoNode(head, tail, data, count);
        }
    }

    void printList(Node* head) {
        while(head != NULL) {
            cout << "(";
            cout << head->data << ",";
            cout << head->count << ") ";
            head = head->next;
        }
        cout << endl;
    }
};

int main() {
    CollapsingCount *c = new CollapsingCount();
    Node* head = NULL;
    Node* tail = NULL;
    c->collapseCount();
    return 0;
}