#include<iostream>
#include<vector>
using namespace std;

class StringTiling {
    public:
    string inputString() {
        string input;
        cout << "Enter string:";
        cin >> input;
        return input;
    }

    string compress(string input, int i, int count) {
        if(i >= input.size()) {
            return to_string(count) + input[i-1];
        }
        if(i-1 >= 0 && input[i] != input[i-1]) {
            return to_string(count) + input[i-1] + compress(input, i+1, 1);
        } else {
            return compress(input, i+1, count+1);
        }
    }

    string stringTiling() {
        string input = inputString();
        return compress(input, 0, 0);
    }
};

int main() {
    StringTiling *str = new StringTiling();
    cout << str->stringTiling() << endl;
    return 0;
}