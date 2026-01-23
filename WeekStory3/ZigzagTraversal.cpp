#include<iostream>
using namespace std;

class Node {
    public:
    string data;
    Node* prev;
    Node* next;
    Node* child;

    Node(string data) {
        this->data = data;
        this->prev = NULL;
        this->next = NULL;
        this->child = NULL;
    }
};

class Traversal {
    public:
    Node* createList(string state) {
        string data;
        cin >> data;
        if(data == "-1") return NULL;
        Node* head = new Node(data);

        cout << "Enter child values of " << data << ":";
        head->child = createList("child");

        if(state != "left") {
            cout << "Enter right values of " << data << ":";
            head->next = createList("right");
            if(head->next) head->next->prev = head;
        }
        if(state != "right") {
            cout << "Enter left values of " << data << ":";
            head->prev = createList("left");
            if(head->prev) head->prev->next = head;
        }
        return head;
    }

    void printList(Node* head, bool leftToRight) {
        if(!head) return;
        if(leftToRight) {
            Node* left = head;
            while(left->prev) left = left->prev;
            while(left != NULL) {
                cout << left->data << " ";
                if(left->child) printList(left->child, 0);
                left = left->next;
            }
        } else {
            Node* right = head;
            while(right->next) right = right->next;
            while(right != NULL) {
                cout << right->data << " ";
                if(right->child) printList(right->child, 1);
                right = right->prev;
            }
        }
    }

    void zigzagTraverse() {
        Node* head = createList("start");
        printList(head, 1);
    }
};

int main() {
    Traversal *t = new Traversal();
    t->zigzagTraverse();
}

// 1 5 -1 6 8 -1 9 -1 -1 -1 7 -1 -1 -1 2 -1 3 -1 4 -1 -1 -1