#include<iostream>
#include<unordered_map>
using namespace std;
void trendsetter(int nums[], int n, int gs) {
    int count = 0; // Trendsetter groups count
    for(int i=0; i <= n-gs; i++){ 
        unordered_map<int, int> m1;
        // Count frequency of elements in current group
        for(int j=i; j < i+gs; j++){
            m1[nums[j]]++;
        }
        // Find max frequency and count how many IDs have it
        int maxFreq = 0, maxCount = 0;
        for(auto &pair : m1){
            if(pair.second > maxFreq){
                maxFreq = pair.second;
                maxCount = 1;
            } else if(pair.second == maxFreq){
                maxCount++;
            }
        }
        if(maxCount == 1){
            count++; // Only one trendsetter in the group
        }
    }
    cout << "Trendsetter Score: " << count << endl;
}

int main(){
    int n ;
    cout<<"Enter the number of elements : ";
    cin>>n;

    int nums[n];
    for(int i=0;i<n;i++){
        cin>>nums[i];
    }

    int gs;
    cout<<"Enter the group size : ";
    cin>>gs;

    trendsetter(nums, n, gs);

    return 0;
}
