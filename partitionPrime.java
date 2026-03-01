import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class ListPartition {

    Scanner sc = new Scanner(System.in);

    // Insert node at tail
    void insertIntoNode(Node[] headTail, String data) {
        Node newNode = new Node(data);

        if (headTail[0] == null) {
            headTail[0] = newNode; // head
            headTail[1] = newNode; // tail
        } else {
            headTail[1].next = newNode;
            headTail[1] = newNode;
        }
    }

    // Take input until -1
    void takeInput(Node[] headTail) {
    String data;
    System.out.println("Enter Elements here(type -1 when input is given))");
    while (true) {
        data = sc.next();      // input lo
        if (data.equals("-1")) // stop condition
            break;
        insertIntoNode(headTail, data);
    }
}
    // Print linked list
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
   // Prime check
    boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    // Partition logic
    void partition(Node[] headRef) {

        Node head = headRef[0];
        if (head == null || head.next == null) return;

        Node primeHead = null, primeTail = null;
        Node compositeHead = null, compositeTail = null;
        Node oneHead = null, oneTail = null;

        Node current = head;

        while (current != null) {
            int value = Integer.parseInt(current.data);

            if (value == 1) {
                if (oneHead == null) {
                    oneHead = oneTail = current;
                } else {
                    oneTail.next = current;
                    oneTail = oneTail.next;
                }
            }
            else if (isPrime(value)) {
                if (primeHead == null) {
                    primeHead = primeTail = current;
                } else {
                    primeTail.next = current;
                    primeTail = primeTail.next;
                }
            }
            else {
                if (compositeHead == null) {
                    compositeHead = compositeTail = current;
                } else {
                    compositeTail.next = current;
                    compositeTail = compositeTail.next;
                }
            }
            current = current.next;
        }

        // Decide new head
        if (primeHead != null) {
            headRef[0] = primeHead;
        } else if (compositeHead != null) {
            headRef[0] = compositeHead;
        } else {
            headRef[0] = oneHead;
        }

        // Connect lists
        if (primeTail != null) {
            primeTail.next = (compositeHead != null) ? compositeHead : oneHead;
        }

        if (compositeTail != null) {
            compositeTail.next = oneHead;
        }

        if (oneTail != null) {
            oneTail.next = null;
        }
    }

    // Driver function
    void listPartition() {
        Node[] headTail = new Node[2]; // [0] = head, [1] = tail
        
        takeInput(headTail);
        partition(headTail);
        printList(headTail[0]);
    }
}

public class partitionPrime {
    public static void main(String[] args) {
        ListPartition lp = new ListPartition();
        lp.listPartition();
    }
}













