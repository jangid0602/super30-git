#include <bits/stdc++.h>
using namespace std;

class Node {
    public:
    string data;
    Node* next;

    Node(string data) {
        data = data;
        next = NULL;
    }
};

class KZipline {
    public:
    void insertIntoNode(Node* &head, Node* &tail, string data) {
        Node* newNode = new Node(data);
        if(head == NULL) {
            head = newNode;
            tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
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

    Node* merge(Node* head1, Node* head2, int k) {
        Node* head = NULL;
        Node* tail = NULL;
        while(head1 != NULL && head2 != NULL) {
            int cnt = 0;
            if(tail) tail->next = head1;
            while(cnt < k && head1 != NULL) {
                if(!head) head = head1;
                tail = head1;
                head1 = head1->next;
                cnt++;
            }
            cnt = 0;
            if(tail) tail->next = head2;
            while(cnt < k && head2 != NULL) {
                if(!head) head = head2;
                tail = head2;
                head2 = head2->next;
                cnt++;
            }
        }
        if(head1) {
            tail->next = head1;
        }
        if(head2) {
            tail->next = head2;
        }
        return head;
    }

    void kZipline() {
        Node* head1 = NULL;
        Node* tail1 = NULL;
        Node* head2 = NULL;
        Node* tail2 = NULL;
        cout << "Enter list datas:";
        takeInput(head1, tail1);
        takeInput(head2, tail2);
        cout << "Enter data of k:";
        int k;
        cin >> k;
        Node* head = merge(head1, head2, k);
        printList(head);
    }
};