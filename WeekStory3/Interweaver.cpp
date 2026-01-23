#include <bits/stdc++.h>
using namespace std;

class Interweaver {
    char* interweave(char* s1, char* s2, int size1, int size2) {
        int size = size1 + size2;
        char* newString = new char[size];
        int idx = 0;
        int idx1 = 0, idx2 = 0;
        while(idx1 < size1 && idx2 < size2) {
            newString[idx++] = s1[idx1++];
            newString[idx++] = s2[idx2++];
        }
        while(idx1 < size1) {
            newString[idx++] = s1[idx1++];
        }
        while(idx2 < size2) {
            newString[idx++] = s2[idx2++];
        }
        return newString;
    }

    void printString(char* newString, int size) {
        for(int i = 0; i < size; i++) {
            cout << newString[i];
        }
        cout << endl;
    }

    public:
    void stringInterweave() {
        int size1;
        cout << "Enter size of string1:";
        cin >> size1;
        int size2;
        cout << "Enter size of string2:";
        cin >> size2;
        char* s1 = new char[size1];
        char* s2 = new char[size2];
        cout << "Enter string1:";
        for(int i = 0; i < size1; i++) {
            cin >> s1[i];
        }
        cout << "Enter string2:";
        for(int i = 0; i < size2; i++) {
            cin >> s2[i];
        }
        int size = size1 + size2;
        char* newString = interweave(s1, s2, size1, size2);
        printString(newString, size);
    }
};

int main() {
    Interweaver inter;
    inter.stringInterweave();
    return 0;
}