#include <bits/stdc++.h>
using namespace std;

class AverageStack {
    vector<int> stack;
    int sum;

    public:
    AverageStack() {
        stack.clear();
        sum = 0;
    }

    void push(int value) {
        stack.push_back(value);
        sum += value;
    }

    int pop() {
        if(stack.size() == 0) {
            return -1;
        } else {
            int value = stack.back();
            stack.pop_back();
            sum -= value;
            return value;
        }
    }

    int top() {
        if(stack.size() == 0) {
            return -1;
        } else {
            return stack.back();
        }
    }
    
    int getAverage() {
        return sum/stack.size();
    }
};

class Stack {
    public:
    void averageStack() {
        AverageStack *stack = new AverageStack();
        int choice = -1;
        do {
            cout << "Choose operation:" << endl;
            cout << "1. push()" << endl;
            cout << "2. pop()" << endl;
            cout << "3. top()" << endl;
            cout << "4. getAverage()" << endl;
            cout << "-1. end()" << endl;
            cin >> choice;

            switch(choice) {
                case 1: {
                    int data;
                    cout << "Enter data:" << endl;
                    cin >> data;
                    stack->push(data);
                } break;
                case 2: {
                    stack->pop();
                } break;
                case 3: {
                    cout << "Top element of stack: " << stack->top() << endl;
                } break;
                case 4: {
                    cout << "Average of elements: " << stack->getAverage() << endl;
                } break;
            }
        } while(choice != -1);
    }
};