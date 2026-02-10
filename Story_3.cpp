
// This file includes solution of Week Story - 3
// Name : Lokesh Kumar
// Date : 20/1/26
#include <iostream>
#include <vector>
#include <string>
#include <limits>
using namespace std;

/* SIMPLE LINKED LIST */
struct Node
{
    int data;
    Node *next;
    Node(int d) : data(d), next(nullptr) {}
};

class SimpleList
{
public:
    Node *head;

    SimpleList() : head(nullptr) {}

    void pushBack(int val)
    {
        Node *n = new Node(val);
        if (!head)
        {
            head = n;
            return;
        }
        Node *t = head;
        while (t->next)
            t = t->next;
        t->next = n;
    }

    void display()
    {
        Node *t = head;
        while (t)
        {
            cout << t->data << " -> ";
            t = t->next;
        }
        cout << "NULL\n";
    }
};

/* PROBLEM 1: O(1) AVERAGE STACK */
class AvgStack
{
    vector<int> st;
    int total = 0;

public:
    void push(int x)
    {
        st.push_back(x);
        total += x;
        cout << "Pushed: " << x << endl;
    }

    void pop()
    {
        if (st.empty())
        {
            cout << "Stack Empty\n";
            return;
        }
        total -= st.back();
        cout << "Popped: " << st.back() << endl;
        st.pop_back();
    }

    void top()
    {
        if (!st.empty())
            cout << "Top: " << st.back() << endl;
    }

    void average()
    {
        if (!st.empty())
            cout << "Average: " << (double)total / st.size() << endl;
    }

    void show()
    {
        cout << "Stack: ";
        for (int x : st)
            cout << x << " ";
        cout << endl;
    }
};

/* PROBLEM 2: LEAKY BUCKET QUEUE */
class LeakyQueue
{
    vector<int> q;
    int cap;

public:
    LeakyQueue(int c) : cap(c) {}

    void enqueue(int x)
    {
        if ((int)q.size() == cap)
            q.erase(q.begin());
        q.push_back(x);
    }

    void process(int k)
    {
        cout << "Processed: ";
        while (k-- && !q.empty())
        {
            cout << q.front() << " ";
            q.erase(q.begin());
        }
        cout << endl;
    }

    void display()
    {
        cout << "Queue: ";
        for (int x : q)
            cout << x << " ";
        cout << endl;
    }
};

/* PROBLEM 3: K-ZIPLINE MERGE */
void ziplineMerge()
{
    SimpleList a, b, res;
    int x, k;

    cout << "Enter List A (-1 end): ";
    while (cin >> x && x != -1)
        a.pushBack(x);

    cout << "Enter List B (-1 end): ";
    while (cin >> x && x != -1)
        b.pushBack(x);

    cout << "Enter batch size: ";
    cin >> k;

    Node *p = a.head;
    Node *q = b.head;

    while (p || q)
    {
        for (int i = 0; i < k && p; i++)
        {
            res.pushBack(p->data);
            p = p->next;
        }
        for (int i = 0; i < k && q; i++)
        {
            res.pushBack(q->data);
            q = q->next;
        }
    }

    cout << "Merged List: ";
    res.display();
}

/* PROBLEM 4: PRIME / COMPOSITE PARTITION */
bool isPrime(int n)
{
    if (n < 2)
        return false;
    for (int i = 2; i * i <= n; i++)
        if (n % i == 0)
            return false;
    return true;
}

void primeCompositePartition()
{
    SimpleList primes, composites, ones;
    int x;

    cout << "Enter values (-1 end): ";
    while (cin >> x && x != -1)
    {
        if (x == 1)
            ones.pushBack(x);
        else if (isPrime(x))
            primes.pushBack(x);
        else
            composites.pushBack(x);
    }

    cout << "Partitioned List: ";
    Node *p = primes.head;
    while (p)
    {
        cout << p->data << " -> ";
        p = p->next;
    }
    p = composites.head;
    while (p)
    {
        cout << p->data << " -> ";
        p = p->next;
    }
    p = ones.head;
    while (p)
    {
        cout << p->data << " -> ";
        p = p->next;
    }
    cout << "NULL\n";
}

/* PROBLEM 5: STRING INTERWEAVER */
void interweaveStrings()
{
    string a, b, res;
    cout << "Enter first string: ";
    cin >> a;
    cout << "Enter second string: ";
    cin >> b;

    int i = 0;
    while (i < a.size() || i < b.size())
    {
        if (i < a.size())
            res += a[i];
        if (i < b.size())
            res += b[i];
        i++;
    }

    cout << "Result: " << res << endl;
}




/* MAIN MENU */
int main()
{
    int choice;

    while (true)
    {
        cout << "\nMENU\n";
        cout << "1. Average Stack\n";
        cout << "2. Leaky Bucket Queue\n";
        cout << "3. K-Zipline Merge\n";
        cout << "4. Prime/Composite Partition\n";
        cout << "5. String Interweaver\n";
        cout << "0. Exit\n";
        cout << "Enter choice: ";
        cin >> choice;

        if (choice == 0)
            break;

        if (choice == 1)
        {
            AvgStack s;
            int op, v;
            do
            {
                cout << "1 Push 2 Pop 3 Top 4 Avg 5 Show 0 Exit: ";
                cin >> op;
                if (op == 1)
                {
                    cin >> v;
                    s.push(v);
                }
                if (op == 2)
                    s.pop();
                if (op == 3)
                    s.top();
                if (op == 4)
                    s.average();
                if (op == 5)
                    s.show();
            } while (op != 0);
        }
        else if (choice == 2)
        {
            int cap;
            cout << "Enter capacity: ";
            cin >> cap;
            LeakyQueue q(cap);
            int op, v;
            do
            {
                cout << "1 Enqueue 2 Process 3 Show 0 Exit: ";
                cin >> op;
                if (op == 1)
                {
                    cin >> v;
                    q.enqueue(v);
                }
                if (op == 2)
                {
                    cin >> v;
                    q.process(v);
                }
                if (op == 3)
                    q.display();
            } while (op != 0);
        }
        else if (choice == 3)
            ziplineMerge();
        else if (choice == 4)
            primeCompositePartition();
        else if (choice == 5)
            interweaveStrings();
    }

    return 0;
}
