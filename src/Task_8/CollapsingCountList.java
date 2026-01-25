package Task_8;

import java.util.*;

class ListNode {
    String value;
    int count;
    ListNode next;

    ListNode(String value, int count) {
        this.value = value;
        this.count = count;
        this.next = null;
    }
}

public class CollapsingCountList {

    // Collapse Function
    public static ListNode collapse(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.value.equals(curr.next.value)) {
                // merge
                curr.count += curr.next.count;
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    // Create List
    public static ListNode createList(Scanner sc, int n) {
        if (n == 0) return null;

        System.out.println("Enter value and count:");
        String val = sc.next();
        int cnt = sc.nextInt();

        ListNode head = new ListNode(val, cnt);
        ListNode curr = head;

        for (int i = 1; i < n; i++) {
            val = sc.next();
            cnt = sc.nextInt();
            curr.next = new ListNode(val, cnt);
            curr = curr.next;
        }
        return head;
    }

    // Print List
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print("(" + temp.value + ", " + temp.count + ")");
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        ListNode head = createList(sc, n);

        System.out.println("\nOriginal List:");
        printList(head);

        head = collapse(head);

        System.out.println("\nCollapsed List:");
        printList(head);

        sc.close();
    }
}
