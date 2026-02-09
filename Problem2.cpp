#include<iostream>
#include<unordered_map>
using namespace std;
bool scrambled(string superstring,string substring){
    bool flag = false;
    unordered_map<char,int>m1,m2;
    for(auto ch : superstring) m1[ch]++;
    for(auto ch : substring) m2[ch]++;

    for(auto ch : m2){
        if(m1.find(ch.first)!=m1.end()){
            if(m1[ch.first]==m2[ch.first]){
                flag = true;
            }
        }
        else continue;
    }
    return flag;
}
int main(){
    string superstring,substring;
    cout<<"Enter the superstring : ";
    cin>>superstring;
    cout<<"Enter the substring : ";
    cin>>substring;

    bool ans = scrambled(superstring,substring);
    cout<<ans<<" ";
}