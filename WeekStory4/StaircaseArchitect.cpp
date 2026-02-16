#include<iostream>
using namespace std;

class StaircaseArchitect {
    public:
    int staircaseArchitect(int n) {
        if(n == 0) {
            return 1;
        } else if(n < 0) {
            return 0;
        }
        return staircaseArchitect(n-1) + staircaseArchitect(n-2);
    }
};

int main() {
    int n;
    cin >> n;
    StaircaseArchitect *stair = new StaircaseArchitect();
    cout << stair->staircaseArchitect(n) << endl;
    return 0;
}