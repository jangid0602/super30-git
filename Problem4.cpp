#include<iostream>
#include<unordered_map>
using namespace std;
int target(int nums[],int n,int k){
    int count = 0;
    unordered_map<int,int>mp;
    for(int i = 0;i < n;i++){
        mp[nums[i]]++;
    }
    for(auto ele : mp){
        int x = ele.first;
        int num = k - x;
        if(mp.find(num)==mp.end()) continue;
        if(x == num){
            count+=mp[x]/2;
        }
        else if(x < num){
            count+=min(mp[x],mp[num]);
        }
    }
    return count;
}
int main(){
    int n;
    cout<<"Enter the size of the array : ";
    cin>>n;

    int nums[n];
    cout<<"Enter "<<n<<" elements : ";
    for(int i=0;i<n;i++){
        cin>>nums[i];
    }

    int k;
    cout<<"Enter the target : ";
    cin>>k;

    int ans = target(nums,n,k);

    cout<<ans<<endl;

}