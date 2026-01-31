/* Week 3 story 
   Programmer - Rajan
   Date - 31/1/205
   Late Reason- Too much difficult question, fixing all error handling, and body illness.
  */
#include<iostream>
#include<stack>
#include<string>
#include<vector>
#include<set>
#include<algorithm>
#include<queue>
using namespace std;
class StackOp{
protected:
    vector<int> arr;
    int totalSum;
public:
    StackOp() {
        totalSum=0;
    }
    void push(int value) {
        arr.push_back(value);
        totalSum+=value;
        cout<<"Pushed successfully\n";
    }
    int pop() {
        if(arr.size()==0) {
            cout<<"Stack Underflow\n";
            return -1;
        }
        int val=arr[arr.size()-1];
        totalSum-=val;
        arr.pop_back();
        return val;
    }
    int top() {
        if(arr.size()==0) {
            cout<<"Stack empty\n";
            return -1;
        }
        return arr[arr.size()-1];
    }
    double getAverage(){
        if(arr.size()==0){
            return 0.0;
        }
        return (totalSum*1.0)/arr.size();
    }
    void run() {
        int ch,val;
        do {
            cout<<"\n1.push 2.pop 3.top 4.average 0.exit ? ";
            cin>>ch;
            switch(ch) {
                case 1: cout<<"value: ";cin>>val; push(val); break;
                case 2: cout<<"Popped: "<<pop()<<"\n"; break;
                case 3: cout<<"Top: "<<top()<<"\n"; break;
                case 4: cout<<"Average: "<<getAverage()<<"\n"; break;
            }
        } while(ch!=0);
    }
};

class IndentationValidator{
public:
    int countSpaces(string line) {
        int count=0;
        for(int i=0;i<line.size();i++) {
            if(line[i]==' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
    bool isValidIndentation(vector<string> lines) {
        stack<int> indentStack;
        indentStack.push(0);
        for(int i=0;i<lines.size();i++) {
            if(lines[i].size()==0) continue;
            int spaces=countSpaces(lines[i]);
            if(spaces>indentStack.top()) {
                indentStack.push(spaces);
            } else if(spaces<indentStack.top()) {
                bool found=false;
                while(indentStack.size()>0 && indentStack.top()>spaces) {
                    indentStack.pop();
                }
                if(indentStack.size()==0 || indentStack.top()!=spaces) {
                    return false;
                }
            }
        }
        return true;
    }
    void run(){
        int n;
        cout<<"Number of lines: ";
        cin>>n;
        cin.ignore();
        vector<string> lines;
        cout<<"Enter lines:\n";
        for(int i=0;i<n;i++) {
            string line;
            getline(cin,line);
            lines.push_back(line);
        }
        if(isValidIndentation(lines)) {
            cout<<"Valid Indentation\n";
        } else {
            cout<<"Invalid Indentation\n";
        }
    }
};

class TwoDListTranspose{
public:
    struct Node {
        int val;
        Node* right;
        Node* down;
        Node(int v):val(v),right(NULL),down(NULL){}
    };
    Node* transpose(Node* head) {
        if(head==NULL) return NULL;
        Node* current=head;
        while(current!=NULL) {
            Node* rowNode=current;
            while(rowNode!=NULL) {
                Node* temp=rowNode->right;
                rowNode->right=rowNode->down;
                rowNode->down=temp;
                rowNode=rowNode->down;
            }
            current=current->right;
        }
        return head;
    }
    void printMatrix(Node* head){
        Node* row=head;
        while(row!=NULL) {
            Node* col=row;
            while(col!=NULL) {
                cout<<col->val;
                if(col->right!=NULL) cout<<" -> ";
                col=col->right;
            }
            cout<<"\n";
            if(row->down!=NULL) {
                Node* downRow=row->down;
                while(downRow!=NULL) {
                    cout<<"|";
                    if(downRow->right!=NULL) cout<<"    ";
                    downRow=downRow->right;
                }
                cout<<"\n";
            }
            row=row->down;
        }
    }
    void run() {
        Node* n1=new Node(1);
        Node* n2=new Node(2);
        Node* n3=new Node(3);
        Node* n4=new Node(4);
        Node* n5=new Node(5);
        Node* n6=new Node(6);
        n1->right=n2; n2->right=n3;
        n1->down=n4; n2->down=n5; n3->down=n6;
        n4->right=n5; n5->right=n6;
        cout<<"Original Matrix:\n";
        printMatrix(n1);
        cout<<"\nTransposed Matrix:\n";
        Node* newHead=transpose(n1);
        printMatrix(newHead);
    }
};
class LinkedListKZipper {
protected:
    struct Node {
        char data;
        Node* next;
        Node(char v):data(v),next(NULL){}
    };
    void insert(Node*& h, char v) {
        if(h==NULL) {
            h=new Node(v);
            return;
        }
        Node* t=h;
        while(t->next!=NULL) {
            t=t->next;
        }
        t->next=new Node(v);
    }
    Node* kzip(Node* h1, Node* h2, int k) {
        Node dummy('0');
        Node* tail=&dummy;
        while(h1!=NULL || h2!=NULL) {
            for(int i=0;i<k&&h1!=NULL;i++) {
                tail->next=h1;
                tail=h1;
                h1=h1->next;
            }
            for(int i=0;i<k&&h2!=NULL;i++) {
                tail->next=h2;
                tail=h2;
                h2=h2->next;
            }
        }
        tail->next=NULL;
        return dummy.next;
    }
    void print(Node* h) {
        while(h!=NULL) {
            cout<<h->data;
            if(h->next!=NULL) {
                cout<<"->";
            }
            h=h->next;
        }
        cout<<"\n";
    }
public:
    void run() {
        Node *l1=NULL,*l2=NULL;
        insert(l1,'1');insert(l1,'2');insert(l1,'3');
        insert(l1,'4');insert(l1,'5');insert(l1,'6');
        insert(l2,'A');insert(l2,'B');insert(l2,'C');insert(l2,'D');
        int k=2;
        cout<<"List1: 1->2->3->4->5->6\n";
        cout<<"List2: A->B->C->D    k="<<k<<"\n";
        Node* res=kzip(l1,l2,k);
        cout<<"K-Zip result: ";
        print(res);
    }
};
class PrimeCompositePartitioner {
protected:
    struct Node {
        int data;
        Node* next;
        Node(int v):data(v),next(NULL){}
    };
    bool isPrime(int n) {
        if(n<=1) return false;
        for(int i=2;i*i<=n;i++) {
            if(n%i==0) return false;
        }
        return true;
    }
public:
    void run() {
        int n,x;
        cout<<"Count: ";cin>>n;
        Node *head=NULL,*tail=NULL;
        cout<<"Values: ";
        for(int i=0;i<n;i++) {
            cin>>x;
            Node* nn=new Node(x);
            if(head==NULL) {
                head=nn;
                tail=nn;
            } else {
                tail->next=nn;
                tail=nn;
            }
        }
        Node *ph=NULL,*pt=NULL,*ch=NULL,*ct=NULL,*oh=NULL,*ot=NULL;
        Node* cur=head;
        while(cur!=NULL) {
            Node* nxt=cur->next;
            cur->next=NULL;
            if(cur->data==1) {
                if(oh==NULL) {
                    oh=cur;
                    ot=cur;
                } else {
                    ot->next=cur;
                    ot=cur;
                }
            } else if(isPrime(cur->data)) {
                if(ph==NULL) {
                    ph=cur;
                    pt=cur;
                } else {
                    pt->next=cur;
                    pt=cur;
                }
            } else {
                if(ch==NULL) {
                    ch=cur;
                    ct=cur;
                } else {
                    ct->next=cur;
                    ct=cur;
                }
            }
            cur=nxt;
        }
        if(pt!=NULL) {
            if(ch!=NULL) {
                pt->next=ch;
            } else {
                pt->next=oh;
            }
        }
        if(ct!=NULL) {
            ct->next=oh;
        }
        if(ph!=NULL) {
            head=ph;
        } else if(ch!=NULL) {
            head=ch;
        } else {
            head=oh;
        }
        cout<<"Result: ";
        Node* t=head;
        while(t!=NULL) {
            cout<<t->data<<" -> ";
            t=t->next;
        }
        cout<<"NULL\n";
    }
};
class LeakyBucket {
protected:
    vector<int> q;
    int cap;
    int front;
    int back;
public:
    LeakyBucket(int c) {
        cap=c;
        front=0;
        back=0;
        q.resize(1005);
    }
    void enqueue(int x) {
        if(back-front==cap) {
            front++;
        }
        q[back]=x;
        back++;
    }
    vector<int> process(int k) {
        vector<int> res;
        int cnt=0;
        while(cnt<k && front<back) {
            res.push_back(q[front]);
            front++;
            cnt++;
        }
        if(front==back) {
            front=0;
            back=0;
        }
        return res;
    }
    void print() {
        for(int i=front;i<back;i++) {
            cout<<q[i]<<" ";
        }
        cout<<"\n";
    }
    void run() {
        int op;
        while(true) {
            cout<<"\n1.Enqueue  2.Process  0.Exit ? ";
            cin>>op;
            if(op==0) break;
            if(op==1) {
                int x;
                cout<<"value: ";cin>>x;
                enqueue(x);
            } else if(op==2) {
                int k;
                cout<<"how many? ";cin>>k;
                vector<int> p=process(k);
                for(int i=0;i<p.size();i++) {
                    cout<<p[i]<<" ";
                }
                cout<<"\n";
            }
        }
        cout<<"Remaining: ";
        print();
    }
};
class StringInterweaver {
public:
    string weave(string a, string b) {
        string res;
        int n=min(a.size(),b.size());
        for(int i=0;i<n;i++) {
            res+=a[i];
            res+=b[i];
        }
        if(a.size()>n) {
            for(int i=n;i<a.size();i++) {
                res+=a[i];
            }
        }
        if(b.size()>n) {
            for(int i=n;i<b.size();i++) {
                res+=b[i];
            }
        }
        return res;
    }
    void run() {
        string s1,s2;
        cout<<"str1: ";cin>>s1;
        cout<<"str2: ";cin>>s2;
        cout<<"Result: "<<weave(s1,s2)<<"\n";
    }
};
class CollapsingCountList {
protected:
    struct Node {
        char value;
        int count;
        Node* next;
        Node(char v,int c):value(v),count(c),next(NULL){}
    };
public:
    Node* collapse(Node* head) {
        if(head==NULL) return NULL;
        bool changed=true;
        while(changed) {
            changed=false;
            Node* current=head;
            Node* prev=NULL;
            while(current!=NULL && current->next!=NULL) {
                if(current->value==current->next->value) {
                    current->count+=current->next->count;
                    Node* temp=current->next;
                    current->next=current->next->next;
                    delete temp;
                    changed=true;
                } else {
                    prev=current;
                    current=current->next;
                }
            }
        }
        return head;
    }
    void print(Node* head) {
        Node* t=head;
        while(t!=NULL) {
            cout<<"("<<t->value<<","<<t->count<<")";
            if(t->next!=NULL) cout<<" -> ";
            t=t->next;
        }
        cout<<"\n";
    }
    void run() {
        Node* head=NULL;
        Node* tail=NULL;
        int n;
        cout<<"Number of nodes: ";
        cin>>n;
        cout<<"Enter (char count) pairs:\n";
        for(int i=0;i<n;i++) {
            char ch;
            int cnt;
            cin>>ch>>cnt;
            Node* nn=new Node(ch,cnt);
            if(head==NULL) {
                head=nn;
                tail=nn;
            } else {
                tail->next=nn;
                tail=nn;
            }
        }
        cout<<"Before collapse: ";
        print(head);
        head=collapse(head);
        cout<<"After collapse: ";
        print(head);
    }
};
class ZigzagFlatten {
public:
    struct Node {
        int val;
        Node* prev;
        Node* next;
        Node* child;
        Node(int v):val(v),prev(NULL),next(NULL),child(NULL){}
    };
    Node* flattenZigzag(Node* head) {
        if(head==NULL) return NULL;
        queue<Node*> q;
        vector<Node*> result;
        q.push(head);
        int level=0;
        while(q.size()>0) {
            int size=q.size();
            vector<Node*> levelNodes;
            for(int i=0;i<size;i++) {
                Node* current=q.front();
                q.pop();
                Node* temp=current;
                while(temp!=NULL) {
                    levelNodes.push_back(temp);
                    if(temp->child!=NULL) {
                        q.push(temp->child);
                    }
                    temp=temp->next;
                }
            }
            if(level%2==1) {
                for(int i=levelNodes.size()-1;i>=0;i--) {
                    result.push_back(levelNodes[i]);
                }
            } else {
                for(int i=0;i<levelNodes.size();i++) {
                    result.push_back(levelNodes[i]);
                }
            }
            level++;
        }
        for(int i=0;i<result.size()-1;i++) {
            result[i]->next=result[i+1];
            result[i+1]->prev=result[i];
            result[i]->child=NULL;
        }
        result[result.size()-1]->next=NULL;
        result[result.size()-1]->child=NULL;
        return result[0];
    }
    void print(Node* head) {
        Node* t=head;
        while(t!=NULL) {
            cout<<t->val;
            if(t->next!=NULL) cout<<"-";
            t=t->next;
        }
        cout<<"-NULL\n";
    }
    void run() {
        Node* n1=new Node(1);
        Node* n2=new Node(2);
        Node* n3=new Node(3);
        Node* n4=new Node(4);
        Node* n5=new Node(5);
        Node* n6=new Node(6);
        Node* n7=new Node(7);
        Node* n8=new Node(8);
        Node* n9=new Node(9);
        n1->next=n2; n2->prev=n1;
        n2->next=n3; n3->prev=n2;
        n3->next=n4; n4->prev=n3;
        n2->child=n5;
        n5->next=n6; n6->prev=n5;
        n6->next=n7; n7->prev=n6;
        n6->child=n8;
        n8->next=n9; n9->prev=n8;
        cout<<"Original list structure created\n";
        Node* result=flattenZigzag(n1);
        cout<<"Flattened zigzag: ";
        print(result);
    }
};

class Main {
public:
    StackOp avgStack;
    IndentationValidator indentValidator;
    TwoDListTranspose twoDTranspose;
    LinkedListKZipper kZipper;
    PrimeCompositePartitioner primePartitioner;
    LeakyBucket* leakyBucket;
    StringInterweaver stringWeaver;
    CollapsingCountList collapsingList;
    ZigzagFlatten zigzagFlatten;

    Main() {
        leakyBucket=NULL;
    }

    void menu() {
        int choice;
        do {
            cout<<" 1. Average Stack\n";
            cout<<" 2. Python Indentation Validator\n";
            cout<<" 3. 2D Linked List Transpose\n";
            cout<<" 4. K-Zipline Merge\n";
            cout<<" 5. Prime/Composite Partition\n";
            cout<<" 6. Leaky Bucket\n";
            cout<<" 7. C-String Interweaver\n";
            cout<<" 8. Collapsing Count List\n";
            cout<<" 9. Zigzag Multi-Level Flatten\n";
            cout<<" 0. Exit\n";
            cin>>choice;
            switch(choice) {
                case 1: avgStack.run(); break;
                case 2: indentValidator.run(); break;
                case 3: twoDTranspose.run(); break;
                case 4: kZipper.run(); break;
                case 5: primePartitioner.run(); break;
                case 6: {
                    int cap;
                    cout<<"Bucket capacity: ";
                    cin>>cap;
                    if(leakyBucket!=NULL) delete leakyBucket;
                    leakyBucket=new LeakyBucket(cap);
                    leakyBucket->run();
                    break;
                }
                case 7: stringWeaver.run(); break;
                case 8: collapsingList.run(); break;
                case 9: zigzagFlatten.run(); break;
                case 0: cout<<"Thanks.\n"; break;
                default: cout<<"Invalid choice\n";
            }
        } while(choice!=0);
    }
};

int main() {
    Main app;
    app.menu();
    return 0;
}
