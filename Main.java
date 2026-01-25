package Story3.java;
import java.util.Scanner;
/*
PROBLEM 1: O(1) Average Stack
Design a stack that supports:
- push(val)
- pop()
- top()
- getAverage()
All operations must work in O(1) time.
*/
class AverageStack {
    private int[] stack;
    private double[] avgStack;
    private int top;

    public AverageStack(int capacity) {
        stack = new int[capacity];
        avgStack = new double[capacity];
        top = -1;
    }

    // Push value into stack and update running average
    public void push(int val) {
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stack[top] = val;

        if (top == 0) avgStack[top] = val;
        else avgStack[top] = ((avgStack[top - 1] * top) + val) / (top + 1);
    }

    // Remove top element
    public int pop() {
        if (top == -1) throw new RuntimeException("Stack Empty");
        return stack[top--];
    }

    // Return top element
    public int top() {
        if (top == -1) throw new RuntimeException("Stack Empty");
        return stack[top];
    }

    // Return average of stack elements
    public double getAverage() {
        if (top == -1) return 0;
        return avgStack[top];
    }
}

/*
PROBLEM 3: 2D Linked List Transpose
Transpose a 2D linked list by swapping:
- right pointer <--> down pointer
*/

class Node2D {
    int val;
    Node2D right, down;

    Node2D(int v) {
        val = v;
    }
}

class TwoDListTransposer {

    public Node2D transpose(Node2D head) {
        Node2D row = head;

        while (row != null) {
            Node2D col = row;
            while (col != null) {
                Node2D temp = col.right;
                col.right = col.down;
                col.down = temp;
                col = col.down;
            }
            row = row.right;
        }
        return head;
    }

    public void print(Node2D head) {
        Node2D r = head;
        while (r != null) {
            Node2D c = r;
            while (c != null) {
                System.out.print(c.val + " ");
                c = c.right;
            }
            System.out.println();
            r = r.down;
        }
    }
}
/*
NODE CLASS FOR PROBLEM 4 & 5
*/
class ListNode {
    int val;
    ListNode next;

    ListNode(int v) {
        val = v;
    }
}
/*
PROBLEM 4: K-Zipline Merge
Merge two linked lists by taking:
k nodes from list1, then k nodes from list2, repeatedly.
*/
class KZiplineMerger {

    public ListNode merge(ListNode h1, ListNode h2, int k) {
        ListNode c1 = h1, c2 = h2;

        while (c1 != null && c2 != null) {

            ListNode t1 = c1;
            for (int i = 1; i < k && t1.next != null; i++)
                t1 = t1.next;

            ListNode t2 = c2;
            for (int i = 1; i < k && t2.next != null; i++)
                t2 = t2.next;

            ListNode n1 = t1.next;
            ListNode n2 = t2.next;

            t1.next = c2;
            t2.next = n1;

            c1 = n1;
            c2 = n2;
        }
        return h1;
    }
}
/*
PROBLEM 5: Prime / Composite Partition
Rearrange list so:
PRIMES → COMPOSITES → ONES
Maintain original relative order.
*/
class PrimeCompositePartitioner {

    public ListNode partition(ListNode h) {
        ListNode pH = null, pT = null;
        ListNode cH = null, cT = null;
        ListNode oH = null, oT = null;

        while (h != null) {
            ListNode n = h.next;
            h.next = null;

            if (h.val == 1) {
                if (oH == null) oH = oT = h;
                else {
                    oT.next = h;
                    oT = h;
                }
            } else if (isPrime(h.val)) {
                if (pH == null) pH = pT = h;
                else {
                    pT.next = h;
                    pT = h;
                }
            } else {
                if (cH == null) cH = cT = h;
                else {
                    cT.next = h;
                    cT = h;
                }
            }
            h = n;
        }

        if (pT != null) pT.next = cH;
        if (cT != null) cT.next = oH;

        return pH != null ? pH : (cH != null ? cH : oH);
    }

    boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }
}
/*
PROBLEM 6: Leaky Bucket Queue
Implement fixed-size queue.
If full, drop the oldest element.
*/
class LeakyBucket {
    int[] q;
    int front = 0, rear = -1, size = 0, cap;

    LeakyBucket(int c) {
        cap = c;
        q = new int[c];
    }

    void enqueue(int v) {
        if (size == cap) {
            System.out.println("Dropped: " + dequeue());
        }
        rear = (rear + 1) % cap;
        q[rear] = v;
        size++;
    }
    int dequeue() {
        int x = q[front];
        front = (front + 1) % cap;
        size--;
        return x;
    }
    void process(int k) {
        for (int i = 0; i < k && size > 0; i++)
            System.out.print(dequeue() + " ");
        System.out.println();
    }
    int size() {
        return size;
    }
}
/*
PROBLEM 8: Collapsing Count List
Merge adjacent nodes having same value.
*/

class CountNode {
    String val;
    int cnt;
    CountNode next;

    CountNode(String v, int c) {
        val = v;
        cnt = c;
    }

    public String toString() {
        return "(" + val + "," + cnt + ")";
    }
}

class CollapsingList {

    public CountNode collapse(CountNode h) {
        boolean changed;
        do {
            changed = false;
            CountNode c = h;

            while (c != null && c.next != null) {
                if (c.val.equals(c.next.val)) {
                    c.cnt += c.next.cnt;
                    c.next = c.next.next;
                    changed = true;
                } else {
                    c = c.next;
                }
            }
        } while (changed);

        return h;
    }
}

/*
MAIN CLASS
*/

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1.AvgStack  3.Transpose  4.K-Zip  5.PrimePart  6.Leaky  8.Collapse  0.Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    run1();
                    break;
                case 3:
                    run3();
                    break;
                case 4:
                    run4();
                    break;
                case 5:
                    run5();
                    break;
                case 6:
                    run6();
                    break;
                case 8:
                    run8();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    // RUN METHODS

    static void run1() {
        AverageStack st = new AverageStack(100);

        while (true) {
            System.out.print("push x | pop | top | avg | quit : ");
            String s = sc.next();

            if (s.equals("quit")) break;
            if (s.equals("push")) st.push(sc.nextInt());
            else if (s.equals("pop")) System.out.println(st.pop());
            else if (s.equals("top")) System.out.println(st.top());
            else if (s.equals("avg")) System.out.println(st.getAverage());
        }
    }

    static void run3() {
        System.out.print("Rows: ");
        int r = sc.nextInt();
        System.out.print("Cols: ");
        int c = sc.nextInt();

        int[][] mat = new int[r][c];
        System.out.println("Enter matrix:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                mat[i][j] = sc.nextInt();

        Node2D h = build2D(mat);
        TwoDListTransposer t = new TwoDListTransposer();

        System.out.println("Original:");
        t.print(h);
        System.out.println("Transposed:");
        t.print(t.transpose(h));
    }

    static void run4() {
        System.out.print("Size list1: ");
        int n1 = sc.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < n1; i++) a1[i] = sc.nextInt();

        System.out.print("Size list2: ");
        int n2 = sc.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < n2; i++) a2[i] = sc.nextInt();

        System.out.print("k: ");
        int k = sc.nextInt();

        print(new KZiplineMerger().merge(build(a1), build(a2), k));
    }

    static void run5() {
        System.out.print("Size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        print(new PrimeCompositePartitioner().partition(build(arr)));
    }

    static void run6() {
        System.out.print("Capacity: ");
        LeakyBucket lb = new LeakyBucket(sc.nextInt());

        while (true) {
            System.out.print("enqueue x | process k | size | quit: ");
            String s = sc.next();

            if (s.equals("quit")) break;
            if (s.equals("enqueue")) lb.enqueue(sc.nextInt());
            else if (s.equals("process")) lb.process(sc.nextInt());
            else if (s.equals("size")) System.out.println(lb.size());
        }
    }

    static void run8() {
        System.out.print("Nodes: ");
        int n = sc.nextInt();

        CountNode h = null, t = null;

        for (int i = 0; i < n; i++) {
            String v = sc.next();
            int c = sc.nextInt();

            CountNode node = new CountNode(v, c);
            if (h == null) h = t = node;
            else {
                t.next = node;
                t = node;
            }
        }

        CountNode r = new CollapsingList().collapse(h);
        while (r != null) {
            System.out.print(r + " ");
            r = r.next;
        }
        System.out.println();
    }

    // HELPERS for tranpose  and print linked list

    static Node2D build2D(int[][] m) {
        int r = m.length, c = m[0].length;
        Node2D[][] n = new Node2D[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                n[i][j] = new Node2D(m[i][j]);
                if (j > 0) n[i][j - 1].right = n[i][j];
                if (i > 0) n[i - 1][j].down = n[i][j];
            }
        return n[0][0];
    }
    static ListNode build(int[] arr) {
        ListNode h = new ListNode(arr[0]), c = h;
        for (int i = 1; i < arr.length; i++) {
            c.next = new ListNode(arr[i]);
            c = c.next;
        }
        return h;
    }
    static void print(ListNode h) {
        while (h != null) {
            System.out.print(h.val + " ");
            h = h.next;
        }
        System.out.println();
    }
}


