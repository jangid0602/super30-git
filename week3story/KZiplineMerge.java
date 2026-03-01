package week3story;

/**
 * Demonstrates K-Zipline Merge of two linked lists.
 * Merges k nodes alternately from two different linked lists.
 */
public class KZiplineMerge {

    // Node class for Integer Linked List.
    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Prints the first linked list
    public static void printLL() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static Node head;
    public static Node tail;

    // Node class for String Linked List
    public static class Node2 {
        String val;
        Node2 next;

        public Node2(String val) {
            this.val = val;
            this.next = null;
        }
    }

    // Prints the second linked list
    public static void printLL2() {
        Node2 temp = head2;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static Node2 head2;
    public static Node2 tail2;

    /**
     * Performs K-Zipline Merge of two linked lists.
     * Prints k nodes from first list, then k nodes from second list,
     * repeatedly until both lists are exhausted.
     *
     * @param k Number of nodes to take alternately from each list
     */
    public static void kZiplineMerge(int k) {
        Node temp = head;
        Node2 temp2 = head2;

        while (temp != null || temp2 != null) {

            // Print k nodes from first list
            for (int i = 0; i < k && temp != null; i++) {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }

            // Print k nodes from second list
            for (int j = 0; j < k && temp2 != null; j++) {
                System.out.print(temp2.val + " -> ");
                temp2 = temp2.next;
            }
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Input: head1 = 1->2->3->4->5->6
        // head2 = A->B->C->D
        // k = 2
        // Output: 1->2->A->B->3->4->C->D->5->6

        Node obj1 = new Node(1);
        Node obj2 = new Node(2);
        Node obj3 = new Node(3);
        Node obj4 = new Node(4);
        Node obj5 = new Node(5);
        Node obj6 = new Node(6);

        obj1.next = obj2;
        obj2.next = obj3;
        obj3.next = obj4;
        obj4.next = obj5;
        obj5.next = obj6;

        head = obj1;

        System.out.println("Input : ");
        printLL();

        Node2 char1 = new Node2("A");
        Node2 char2 = new Node2("B");
        Node2 char3 = new Node2("C");
        Node2 char4 = new Node2("D");

        char1.next = char2;
        char2.next = char3;
        char3.next = char4;

        head2 = char1;

        printLL2();

        System.out.println("Output : ");
        int k = 2;
        kZiplineMerge(k);
    }
}