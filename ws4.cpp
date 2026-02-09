#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
using namespace std;

void problem1() {
    string word;
    while(true) {
        cout<<"\nEnter word (type -1 to go back): ";
        cin>>word;
        
        if(word=="-1") break;
        
        if(word.length() == 0) {
            cout << "Word is empty!\n";
            continue;
        }
        if(word.length() < 2) {
            cout << "Word is too short!\n";
            continue;
        }
        
        bool same = true;
        int len = word.length();
        for(int i = 0; i < len/2; i++) {
            if(word[i] != word[len-1-i]) {
                same = false;
                break;
            }
        }
        
        if(same) {
            cout << "YES - it is palindrome\n";
        } else {
            cout << "NO - not palindrome\n";
        }
    }
}

void problem2() {
    string s;
    while(true) {
        cout << "\nEnter word (only letters, -1 to go back): ";
        cin >> s;
        if(s == "-1") break;
        
        bool only_letters = true;
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if(s[i] < 'a' || s[i] > 'z') {
                if(s[i] < 'A' || s[i] > 'Z') {
                    only_letters = false;
                    break;
                }
            }
        }
        if(!only_letters) {
            cout << "Only English letters allowed!\n";
            continue;
        }
        
        if(s.length() == 0) {
            cout << "Empty word!\n";
            continue;
        }
        
        string answer = "";
        char last = s[0];
        int count = 1;
        
        for(int i = 1; i < len; i++) {
            if(s[i] == last) {
                count++;
            } else {
                stringstream ss;
                ss << count;
                answer = answer + ss.str() + last;
                last = s[i];
                count = 1;
            }
        }
        stringstream ss;
        ss << count;
        answer = answer + ss.str() + last;
        
        cout << "Result: " << answer << "\n";
    }
}

void problem3() {
    long long dp[1001];
    for(int i = 0; i <= 1000; i++) {
        dp[i] = -1;
    }
    
    dp[1] = 1;
    dp[2] = 2;
    
    int n;
    while(true) {
        cout << "\nEnter number of stairs (-1 to go back): ";
        cin >> n;
        if(n == -1) break;
        
        if(n <= 0) {
            cout << "Please enter positive number!\n";
            continue;
        }
        
        for(int i = 3; i <= n; i++) {
            if(dp[i] == -1) {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        
        cout << "Number of ways = " << dp[n] << "\n";
    }
}

void problem4() {
    int n;
    while(true) {
        cout << "\nHow many numbers? (-1 to go back): ";
        cin >> n;
        if(n == -1) break;
        
        if(n < 1 || n > 8) {
            cout << "Please choose 1 to 8 only\n";
            continue;
        }
        
        vector<int> numbers(n);
        cout << "Enter " << n << " different numbers:\n";
        for(int i = 0; i < n; i++) {
            cin >> numbers[i];
        }
        
        sort(numbers.begin(), numbers.end());
        
        cout << "\nAll possible orders:\n";
        do {
            for(int i = 0; i < n; i++) {
                cout << numbers[i] << " ";
            }
            cout << "\n";
        } while(next_permutation(numbers.begin(), numbers.end()));
    }
}

void problem5() {
    cout << "\nExample team: A B C\n";
    cout << "All possible groups:\n";
    
    for(int mask = 0; mask < 8; mask++) {
        cout << "{ ";
        if(mask & 1) cout << "A ";
        if(mask & 2) cout << "B ";
        if(mask & 4) cout << "C ";
        cout << "}\n";
    }
    cout << "(You can change this part to read names if needed)\n";
}

void problem6() {
    cout << "\nThis problem needs numbers like level order with -1 for null\n";
    cout << "Example: 1 2 3 -1 -1 -1 -1   (sum = 6)\n";
    
    vector<int> nums;
    int x;
    cout << "Enter numbers (0 to stop):\n";
    while(true) {
        cin >> x;
        if(x == 0) break;
        nums.push_back(x);
    }
    
    int total = 0;
    int size = nums.size();
    for(int i = 0; i < size; i++) {
        if(nums[i] != -1) {
            total += nums[i];
        }
    }
    
    cout << "Sum of all node values = " << total << "\n";
}

void problem7() {
    int n, key_pos;
    cout << "\nHow many dolls? ";
    cin >> n;
    cout << "Key is inside doll number (1 to " << n << "): ";
    cin >> key_pos;
    
    if(key_pos < 1 || key_pos > n) {
        cout << "Wrong doll number!\n";
        return;
    }
    
    cout << "Looking for key...\n";
    for(int i = 1; i <= n; i++) {
        if(i == key_pos) {
            cout << "Key Found in doll " << i << " !\n";
            return;
        }
    }
    cout << "Key not found (should not happen)\n";
}

void problem8() {
    cout <<"Enter small size\n";
    
    int n;
    cout << "Maze size: ";
    cin >> n;
    
    int maze[10][10];
    for(int i = 0; i < 10; i++) {
        for(int j = 0; j < 10; j++) {
            maze[i][j] = 0;
        }
    }
    
    cout << "Enter maze (1 = can walk, 0 = wall):\n";
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> maze[i][j];
        }
    }
    
    if(maze[0][0] == 0 || maze[n-1][n-1] == 0) {
        cout << "false (start or end is wall)\n";
        return;
    }
    
    bool can = true;
    int x = 0, y = 0;
    while(x < n-1 || y < n-1) {
        if(x < n-1 && maze[x+1][y] == 1) {
            x++;
        }
        else if(y < n-1 && maze[x][y+1] == 1) {
            y++;
        }
        else {
            can = false;
            break;
        }
    }
    if(can) {
        cout << "true\n";
    } else {
        cout << "false\n";
    }
}

void problem9() {
    cout<<"Difficult question";
}

void problem10() {
    int n;
    cout << "\nHow many numbers? ";
    cin >> n;
    
    int a[20];
    cout << "Enter " << n << " numbers:\n";
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
    
    int target;
    cout << "Target sum: ";
    cin >> target;
    
    cout << "\nPossible combinations:\n";
    bool found = false;
    
    for(int mask = 0; mask < (1<<n); mask++) {
        int sum = 0;
        vector<int> chosen;
        
        for(int i = 0; i < n; i++) {
            if(mask & (1<<i)) {
                sum += a[i];
                chosen.push_back(a[i]);
            }
        }
        
        if(sum == target && chosen.size() > 0) {
            found = true;
            int chosenSize = chosen.size();
            for(int i = 0; i < chosenSize; i++) {
                cout << chosen[i] << " ";
            }
            cout << "\n";
        }
    }
    
    if(!found) {
        cout << "No combination found\n";
    }
}
int main() {
    while(true) {
        cout << "\n1. Palindrome check\n";
        cout << "2. Count letters (tiling)\n";
        cout << "3. Ways to climb stairs\n";
        cout << "4. All permutations\n";
        cout << "5. All possible groups\n";
        cout << "6. Sum of tree nodes\n";
        cout << "7. Find key in dolls\n";
        cout << "8. Maze (simple)\n";
        cout << "9. Project tasks\n";
        cout << "10. Budget combinations\n";
        cout << "0. Exit\n";
        cout <<"\nEnter choice (0-10):";
        int choice;
        cin >> choice;
        
        if(choice == 1) problem1();
        else if(choice == 2) problem2();
        else if(choice == 3) problem3();
        else if(choice == 4) problem4();
        else if(choice == 5) problem5();
        else if(choice == 6) problem6();
        else if(choice == 7) problem7();
        else if(choice == 8) problem8();
        else if(choice == 9) problem9();
        else if(choice == 10) problem10();
        else {
            cout << "Wrong choice! Try 0 to 10\n";
        }
    }
    return 0;
}
