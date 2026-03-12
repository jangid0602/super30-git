import java.util.*;

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Mergelinkedlist {

    // K-Zipline Merge Function
    static Node kziplinemerge(Node head1, Node head2, int k) {

        if (head1 == null) return head2;
        if (head2 == null) return head1;
        if (k <= 0) return head1;

        Node curr1 = head1;
        Node curr2 = head2;
        Node tail = null;
        Node newHead = head1;

        boolean takenewNode = true;

        while (curr1 != null && curr2 != null) {

            int count = 0;

            if (takenewNode) {
                while (curr1 != null && count < k) {
                    tail = curr1;
                    curr1 = curr1.next;
                    count++;
                }
                tail.next = curr2;
            } else {
                while (curr2 != null && count < k) {
                    tail = curr2;  
                    curr2 = curr2.next;
                    count++;
                }
                tail.next = curr1;
            }

            takenewNode = !takenewNode;
        }

        return newHead;
    }

    // 🔹 Create Linked List using User Input
    static Node createList(Scanner sc, int n) {
        if (n == 0) return null;

        String data = sc.next();
        Node head = new Node(data);
        Node curr = head;

        for (int i = 1; i < n; i++) {
            data = sc.next();
            curr.next = new Node(data);
            curr = curr.next;
        }
        return head;
    }

    // 🔹 Print Linked List
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 🔹 Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input List 1
        System.out.print("Enter size of first linked list: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements of first linked list:");
        Node head1 = createList(sc, n1);

        // Input List 2
        System.out.print("Enter size of second linked list: ");
        int n2 = sc.nextInt();
        System.out.println("Enter elements of second linked list:");
        Node head2 = createList(sc, n2);

        // Input k
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        System.out.println("\nList 1:");
        printList(head1);

        System.out.println("List 2:");
        printList(head2);

        Node result = kziplinemerge(head1, head2, k);

        System.out.println("\nAfter K-Zipline Merge:");
        printList(result);

        sc.close();
    }
}
