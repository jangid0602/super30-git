#include <bits/stdc++.h>
using namespace std;

class Node {
    public:
    string data;
    Node* next;

    Node(string data) {
        this->data = data;
        next = NULL;
    }
};

class ListPartition {
    void insertIntoNode(Node* &head, Node* &tail, string data) {
        Node* newNode = new Node(data);
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
        while(data != "-1") {
            cin >> data;
            if(data != "-1") insertIntoNode(head, tail, data);
        }
    }

    void printList(Node* head) {
        while(head != NULL) {
            cout << head->data << " ";
            head = head->next;
        }
        cout << endl;
    }

    bool isPrime(int num) {
        if(num <= 1) return false;
        for(int i = 2; i*i <= num; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

    void partition(Node* &head) {
        if(!head || !head->next) return;
        Node* head1 = NULL;
        Node* tail1 = NULL;
        Node* head2 = NULL;
        Node* tail2 = NULL;
        Node* oneHead = NULL;
        Node* oneTail = NULL;

        Node* curr = head;
        while(curr != NULL) {
            int data = stoi(curr->data);
            if(data == 1) {
                if(!oneHead) {
                    oneHead = curr;
                    oneTail = curr;
                } else {
                    oneTail->next = curr;
                    oneTail = oneTail->next;
                }
            } else if(isPrime(data)) {
                if(!head1) {
                    head1 = curr;
                    tail1 = curr;
                } else {
                    tail1->next = curr;
                    tail1 = tail1->next;
                }
            } else {
                if(!head2) {
                    head2 = curr;
                    tail2 = curr;
                } else {
                    tail2->next = curr;
                    tail2 = tail1->next;
                }
            }
            curr = curr->next;
        }

        if(head1) {
            head = head1;
        } else if(head2) {
            head = head2;
        } else {
            head = oneHead;
        }

        if(tail1) {
            if(head2) {
                tail1->next = head2;
            } else {
                tail1->next = oneHead;
            }
        }
        if(tail2) {
            if(oneHead) {
                tail2->next = oneHead;
            }
        }
        if(oneTail) {
            oneTail->next = NULL;
        }
    }

    public:
    void listPartition() {
        Node* head = NULL;
        Node* tail = NULL;
        takeInput(head, tail);
        partition(head);
        printList(head);
    }
};
