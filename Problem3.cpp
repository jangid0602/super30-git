#include <iostream>
#include <vector>
#include <map>
using namespace std;

// split line into username and page using ','
void split(string& line, string& user, string& page) {
    size_t pos = line.find(',');
    user = line.substr(0, pos);
    page = line.substr(pos + 1);
    // Remove leading space from page
    if (!page.empty() && page[0] == ' ')
        page = page.substr(1);
}

int main() {
    int n;
    cout << "Enter the number of actions: ";
    cin >> n;

    vector<string> actions(n);
    cout << "Enter actions :\n";
    for (int i = 0; i < n; i++) {
        getline(cin, actions[i]);
    }

    // Group pages per user
    map<string, vector<string>> userPages;
    for (int i = 0; i < n; i++) {
        string user, page;
        split(actions[i], user, page);
        userPages[user].push_back(page);
    }

    // Count journeys
    map<string, int> journeyCount;
    for (auto &entry : userPages) {
        vector<string>& pages = entry.second;
        for (int i = 1; i < pages.size(); i++) {
            string journey = pages[i-1] + ", " + pages[i];
            journeyCount[journey]++;
        }
    }

    // Find journey with most count
    string answer;
    int maxCount = 0;
    for (auto &j : journeyCount) {
        if (j.second > maxCount || (j.second == maxCount && j.first < answer)) {
            answer = j.first;
            maxCount = j.second;
        }
    }

    cout << "Most Frequent Path: " << answer << endl;
    return 0;
}
