#include<iostream>
#include<string>
#include<algorithm>
#include<vector>
using namespace std;
class Vechile{
	public:
		int vehnum;
		string vehname;
		string owner;
		int size=5;
		
		void getDetails(){
			cout<<"Enter the Vehicle Number"<<endl;
			cin>>vehnum;
			cout<<"Enter the Vechile Name"<<endl;
			cin>>vehname;
			cout<<"Enter the Owner Name"<<endl;
			cin>>owner;
	}
		void showDetails(){
			cout<<"Vehicle Number :"<<vehnum<<endl;
			cout<<"Vechile Name :"<<vehname<<endl;
			cout<<"Owner Name :"<<owner<<endl;
	}
};

class Parking{
	public:
		int capacity;
		vector<Vechile>parkedvech;
		Parking(int cap){
			capacity=cap;
		}
		
		void add(){
			if(parkedvech.size()>=capacity){
				cout<<"Parking capacity id full"<<endl;
				
			}
			Vechile v;
			v.getDetails();
			parkedvech.push_back(v);
			cout<<"Vechile parked successfully"<<endl;
			
		}
		void remove(){
			if((parkedvech.empty())){
				cout<<" No vechile to remove"<<endl;
			}
			else{
				parkedvech.pop_back();
			}
		}
		void show(){
			for(int i=0;i<parkedvech.size();i++){
				cout<<"List of Car"<<endl;
				parkedvech[i].showDetails();
			}
		}
};

int main(){
	Parking veh(5);
	veh.add();
	veh.add();
	veh.remove();
	veh.show();
	return 0;
}
