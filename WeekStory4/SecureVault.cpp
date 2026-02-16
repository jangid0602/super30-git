#include<iostream>
#include<vector>
using namespace std;

class SecureVault {
    public:
    void possibleCodes(string &codes, int index) {
        if(index >= codes.size()) {
            cout << codes << " ";
            return;
        }
        for(int i = index; i < codes.size(); i++) {
            swap(codes[index], codes[i]);
            possibleCodes(codes, index+1);
            swap(codes[index], codes[i]);
        }
    }

    void secureVault() {
        string codes = "123";
        possibleCodes(codes, 0);
        cout << endl;
    }
};

int main() {
    SecureVault *vault = new SecureVault();
    vault->secureVault();
    return 0;
}