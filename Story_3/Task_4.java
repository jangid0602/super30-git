package Codeup.Story_3;

import java.util.Scanner;

public class Task_4 {

    static class Node {
        String val;
        Node next;

        Node(String val) {
            this.val = val;
            this.next = null;
        }
    }
        // K-Zipline Merge Function
        public static Node kZiplineMerge(Node head1, Node head2, int k) {
            Node dummy = new Node("0");
            Node tail = dummy;

            Node p1 = head1;
            Node p2 = head2;

            while (p1 != null || p2 != null) {

                // take k nodes from list1
                int count = 0;
                while (p1 != null && count < k) {
                    tail.next = p1;
                    tail = p1;
                    p1 = p1.next;
                    count++;
                }

                // take k nodes from list2
                count = 0;
                while (p2 != null && count < k) {
                    tail.next = p2;
                    tail = p2;
                    p2 = p2.next;
                    count++;
                }
            }

            tail.next = null;
            return dummy.next;
        }

        // Create Linked List
        public static Node createList(Scanner sc, int n) {
            if (n == 0) return null;

            Node head = new Node(sc.next());
            Node curr = head;

            for (int i = 1; i < n; i++) {
                curr.next = new Node(sc.next());
                curr = curr.next;
            }
            return head;
        }

        // Print Linked List
        public static void printList(Node head) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val);
                if (temp.next != null) System.out.print(" -> ");
                temp = temp.next;
            }
            System.out.println();
        }


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter size of list 1: ");
            int n1 = sc.nextInt();
            System.out.println("Enter elements of list 1:");
            Node head1 = createList(sc, n1);

            System.out.print("Enter size of list 2: ");
            int n2 = sc.nextInt();
            System.out.println("Enter elements of list 2:");
            Node head2 = createList(sc, n2);

            System.out.print("Enter value of k: ");
            int k = sc.nextInt();

            Node result = kZiplineMerge(head1, head2, k);

            System.out.println("Merged List:");
            printList(result);
        }
    }

