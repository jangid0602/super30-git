#include <iostream>
#include <string>
using namespace std;

int main() {
    string original = "abcd";
    string scrambled = "abcde";
    
    int count[26] = {0};
    
    for (char c : scrambled) count[c - 'a']++;
    for (char c : original) count[c - 'a']--;
    
    for (int i = 0; i < 26; i++) {
        if (count[i] == 1) {
            cout << (char)(i + 'a') << endl;
        }
    }
    return 0;
}