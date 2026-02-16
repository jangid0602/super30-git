#include<iostream>
using namespace std;

class WordMirror {
    public:

    bool isPalindrome(string input, int s, int e) {
        if(s >= e) return true;
        if(input[s] != input[e]) return false;
        else return isPalindrome(input, s+1, e-1);
    }

    bool wordMirror() {
        string input;
        cout << "Enter string:";
        cin >> input;
        return isPalindrome(input, 0, input.size()-1);
    }
};

int main() {
    WordMirror *word = new WordMirror();
    if(word->wordMirror()) cout << "String is palindrome" << endl;
    else cout << "String is not palindrome" << endl;
    return 0;
}