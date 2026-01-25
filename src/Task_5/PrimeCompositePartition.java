package Task_5;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PrimeCompositePartition {

    // Prime Check
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Partition Function
    public static ListNode partitionPrimes(ListNode head) {

        ListNode primeDummy = new ListNode(0);
        ListNode compDummy  = new ListNode(0);
        ListNode oneDummy   = new ListNode(0);

        ListNode pTail = primeDummy;
        ListNode cTail = compDummy;
        ListNode oTail = oneDummy;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val == 1) {
                oTail.next = curr;
                oTail = curr;
            }
            else if (isPrime(curr.val)) {
                pTail.next = curr;
                pTail = curr;
            }
            else {
                cTail.next = curr;
                cTail = curr;
            }
            curr = curr.next;
        }

        // terminate last list
        oTail.next = null;

        // connect lists: prime -> composite -> one
        pTail.next = compDummy.next;
        cTail.next = oneDummy.next;

        return primeDummy.next;
    }

    // Create Linked List
    public static ListNode createList(Scanner sc, int n) {
        if (n == 0) return null;

        ListNode head = new ListNode(sc.nextInt());
        ListNode curr = head;

        for (int i = 1; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }
        return head;
    }

    // Print Linked List
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        ListNode head = createList(sc, n);

        head = partitionPrimes(head);

        System.out.println("Partitioned List:");
        printList(head);

        sc.close();
    }
}
