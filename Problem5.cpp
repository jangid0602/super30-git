#include <iostream>
#include <map>
using namespace std;
int longestBalancedSubarray(int arr[], int n) {
    // Transform 2s to -1, keep 1s as +1, 0s as 0
    int transformed[n];
    for (int i = 0; i < n; i++) {
        if (arr[i] == 1) transformed[i] = 1;
        else if (arr[i] == 2) transformed[i] = -1;
        else transformed[i] = 0;
    }
    map<int, int> firstOccur;
    firstOccur[0] = -1; // prefix sum 0 before start

    int prefixSum = 0;
    int maxLength = 0;

    for (int i = 0; i < n; i++) {
        prefixSum += transformed[i];
        if (firstOccur.find(prefixSum) != firstOccur.end()) {
            int length = i - firstOccur[prefixSum];
            if (length > maxLength) maxLength = length;
        } else {
            firstOccur[prefixSum] = i;
        }
    }

    return maxLength;
}

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;
    int arr[n];

    cout << "Enter elements (1, 2, or 0):\n";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int result = longestBalancedSubarray(arr, n);
    cout << "Longest Balanced Subarray Length: " << result << endl;

    return 0;
}
