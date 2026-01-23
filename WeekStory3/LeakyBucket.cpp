#include <bits/stdc++.h>
using namespace std;

class Queue {
    vector<int> queue;
    int capacity;
    int front;
    int back;

    public:
    Queue(int capacity) {
        this->capacity = capacity;
        queue.resize(1001);
        front = 0;
        back = 0;
    }

    void enqueue(int data) {
        if(back == capacity) {
            // if queue is full -> deleting first element
            front++;
        }
        queue[back] = data;
        back++;
    }

    vector<int> process(int k) {
        vector<int> processes;
        int cnt = 0;
        while(cnt < k && front < back) {
            processes.push_back(queue[front++]);
            cnt++;
        }
        if(front == back) {
            front = 0;
            back = 0;
        }
        return processes;
    }

    void printBucket() {
        for(int i = front; i < back; i++) {
            cout << queue[i] << " ";
        }
        cout << endl;
    }
};

class LeakyBucket {
    public:
    void leakyBucket() {
        int capacity;
        cout << "Enter capacity:";
        cin >> capacity;
        Queue *bucket = new Queue(capacity);

        int input = 0;
        while(input != -1) {
            cout << "Enter operations to perform:" << endl;
            cout << "1. enqueue()" << endl;
            cout << "2. process()" << endl;
            cin >> input;
            if(input == 1) {
                int data;
                cout << "Enter data:";
                cin >> data;
                bucket->enqueue(data);
            } else if(input == 2) {
                int k;
                cout << "Enter value of k:";
                cin >> k;
                vector<int> processes = bucket->process(k);
                for(auto &process:processes) cout << process << " ";
                cout << endl; 

            } else if(input != -1){
                cout << "Invalid Input" << endl;
            }
        }
        bucket->printBucket();
    }
};