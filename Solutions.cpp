// This file includes solution of week-2 stories
// Name - Raj Gehlot
// Date - 12/11/25

#include<iostream>
#include<vector>
#include<unordered_map>
#include<math.h>
using namespace std;

int trendSetter(vector<int>& posts, int k) {
    int trendsetters = 0;
    for(int i = 0; i <= posts.size()-k; i++) {
        int maxFreq = 0;
        vector<int> counts;
        for(int j = i; j < i+k; j++) {
            int count = 0;
            for(int idx = j; idx < i+k; idx++) {
                if(posts[idx] == posts[j]) count++;
            }
            if(count > 0)
            counts.push_back(count);
        }
        int maxi = -1;
        for(auto num:counts) {
            if(num > maxi) maxi = num;
        }
        int cnt = 0;
        for(auto num:counts) {
            if(num == maxi) cnt++;
        }
        if(cnt == 1) trendsetters++;
    }
    return trendsetters;
}

int longestBalanced(vector<int>& nums) {
    int size = nums.size();
    int maxLen = 0;
    for(int i = 0; i < size; i++) {
        int ones = 0, twos = 0;
        for(int j = i; j < size; j++) {
            if(nums[j] == 1) ones++;
            else if(nums[j] == 2) twos++;
            if(ones == twos) {
                if(j-i+1 > maxLen)
                maxLen = j-i+1;
            };
        }
    }
    return maxLen;
}

int countPairs(vector<int>& nums, int k) {
    int n = nums.size();
    vector<int> vis(n, 0);
    int count = 0;
    for(int i = 0; i < n; i++) {
        if(vis[i] == 1) continue;
        for(int j = i+1; j < n; j++) {
            if(vis[j] == 1) continue;
            if(nums[i] + nums[j] == k) {
                vis[i] = 1;
                vis[j] = 1;
                count++;
                cout << i << " " << j << endl;
                break;
            }
        }
    }
    return count;
}

bool scrambledSubstring(string superstring, string substring) {
    int n1 = superstring.size(), n2 = substring.size();
    vector<int> charCount(26, 0);
    for(auto character:substring) charCount[character - 'a']++;
    for(int i = 0; i <= n1-n2; i++) {
        vector<int> count(26, 0);
        for(int j = i; j < i+n2; j++) {
            count[superstring[j] - 'a']++;
        }
        if(charCount == count) return true;
    }
    return false;
}

string mostFrequentPath(vector<string>& actions) {
    int n = actions.size();
    vector<int> vis(n, 0);
    vector<string> paths;

    for(int i = 0; i < n; i++) {
        if(vis[i] == 1) continue;
        string user = "";
        user += actions[i][0];
        user += actions[i][1];

        string currPath = "";
        for(int j = i; j < n; j++) {
            if(vis[j] == 1) continue;

            string currUser = "";
            string currActions = "";
            currUser += actions[j][0];
            currUser += actions[j][1];
            for(int k = 2; k < actions[j].size(); k++) currActions += actions[j][k];
            string temp = "";
            for(int k = 4; k < actions[j].size(); k++) temp += actions[j][k];

            if(user == currUser) {
                if(currPath != "") {
                    currPath += currActions;
                    paths.push_back(currPath);
                }
                currPath = temp;
                vis[j] = 1;
            }
        }
    }
    
    // taking a maximum value for string
    string journey("{", 10);
    int size = paths.size();
    vis.resize(size);
    for(auto &v:vis) v = 0;
    int maxiCount = 0;
    vector<int> counts(size, 0);

    for(int i = 0; i < size; i++) {
        if(vis[i] == 1) continue;
        int currCount = 0;
        for(int j = i; j < size; j++) {
            if(vis[j] == 1) continue;
            if(paths[i] == paths[j]) {
                vis[i] = 1;
                vis[j] = 1;
                currCount++;
            }
        }
        counts[i] = currCount;
        if(currCount > maxiCount) {
            maxiCount = currCount;
        }
    }

    for(int i = 0; i < size; i++) {
        if(counts[i] == maxiCount) {
            if(paths[i] < journey) {
                journey = paths[i];
            }
        }
    }
    return journey;
}

int main() {
    bool flag = true;
    while(flag) {
        cout << "Enter a choice:" << endl;
        cout << "1. Trend setter:" << endl;
        cout << "2. Longest balanced subarray:" << endl;
        cout << "3. Count pairs sum equal to k:" << endl;
        cout << "4. Scrambled Substring:" << endl;
        cout << "5. Most frequent path:" << endl;
        cout << "0. to end:" << endl;
        string choice;
        cin >> choice;
        switch(choice[0]) {
            case '1': {
                cout << "Enter size of array and window size:";
                int size, k;
                cin >> size >> k;
                cout << "Enter elements of array:";
                vector<int> nums(size);
                for(int i = 0; i < size; i++) cin >> nums[i];
                cout << "Number of trend setters: " << trendSetter(nums, k) << endl;
            }
            break;
            case '2': {
                cout << "Enter size of array:";
                int size;
                cin >> size;
                cout << "Enter elements of array:";
                vector<int> nums(size);
                for(int i = 0; i < size; i++) cin >> nums[i];
                cout << "Length of longest balanced subarray: " << longestBalanced(nums) << endl;
            }
            break;
            case '3': {
                cout << "Enter size of array and value of k:";
                int size, k;
                cin >> size >> k;
                cout << "Enter elements of array:";
                vector<int> nums(size);
                for(int i = 0; i < size; i++) cin >> nums[i];
                cout << "number of pairs with sum k: " << countPairs(nums, k) << endl;
            }
            break;
            case '4': {
                string superstring, substring;
                cout << "Enter superstring:";
                cin >> superstring;
                cout << "Enter substring:";
                cin >> substring;
                if(scrambledSubstring(superstring, substring)) {
                    cout << "substring is within superstring" << endl;
                }
                else {
                    cout << "Substring is not within superstring" << endl;
                }
            }
            break;
            case '5': {
                cout << "Enter number of actions:";
                int size;
                cin >> size;
                // it clears the new line from buffer so that it do not interrupt ahead
                cin.ignore();
                cout << "Enter all actions along with user name:";
                vector<string> actions(size);
                for(int i = 0; i < size; i++) getline(cin, actions[i]);
                cout << "Most frequent path: " << mostFrequentPath(actions) << endl;
            }
            break;
            case '0':
                flag = false;
            break;
            default:
                cout << "Invalid input please enter again:" << endl;
            break;
        }
    }
    cout << "Thank You\n";
    return 0;
}