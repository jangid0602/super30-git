#include<iostream>
using namespace std;

class RussianDoll {
    public:
    bool russianDoll(int size) {
        if(size == 1) {
            return true;
        } else if(size < 1) {
            return false;
        }
        return russianDoll(size-1);
    }
};

int main() {
    RussianDoll *doll = new RussianDoll();
    if(doll->russianDoll(5)) cout << "Key Found!";
    else cout << "Key Not Found!";
    return 0;
}