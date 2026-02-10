package week3story;

public class CollapsingCountList {
    public static class Node {
        String value;
        int count;
        Node next;

        public Node(String value, int count) {
            this.value = value;
            this.count = count;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static void printLL(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print("(" + temp.value + "," + temp.count + ")" + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void collapse(Node head) {
        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.value.equals(curr.next.value)) {
                curr.count = curr.count + curr.next.count;
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node("A", 1);
        Node n2 = new Node("A", 2);
        Node n3 = new Node("A", 3);
        Node n4 = new Node("B", 1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        head = n1;
        tail = n4;

        System.out.println("Input : ");
        printLL(head);
        System.out.println("Output : ");
        collapse(head);
        printLL(head);
    }
}
