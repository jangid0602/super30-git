import java.util.Scanner;

class Node {
    char value;
    int count;
    Node next;

    Node(char value, int count) {
        this.value = value;
        this.count = count;
        this.next = null;
    }
}

public class CollapsingCountList {

    // Collapse function
    static Node collapse(Node head) {
        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.value == curr.next.value) {
                // merge
                curr.count = curr.count + curr.next.count;
                curr.next = curr.next.next; // delete next node
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    // Print linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print("(" + temp.value + ", " + temp.count + ")");
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method (User Input)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("List is empty");
            return;
        }

        // Input first node
        System.out.print("Enter value and count for node 1: ");
        char value = sc.next().charAt(0);
        int count = sc.nextInt();

        Node head = new Node(value, count);
        Node tail = head;

        // Input remaining nodes
        for (int i = 2; i <= n; i++) {
            System.out.print("Enter value and count for node " + i + ": ");
            value = sc.next().charAt(0);
            count = sc.nextInt();

            tail.next = new Node(value, count);
            tail = tail.next;
        }

        System.out.print("\nOriginal List: ");
        printList(head);

        head = collapse(head);

        System.out.print("Collapsed List: ");
        printList(head);

        sc.close();
    }
}

