package week3story;

public class ListPartition {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public boolean isPrime(Node curr) {
        // prime -> A Number which has only two factors.

        if (curr.data <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(curr.data); i++) {
            if (curr.data % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isComposite(Node curr) {
        // Composite -> A number which has more than two factors.
        if (curr.data <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(curr.data); i++) {
            if (curr.data % i == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isOne(Node curr) {
        if (curr.data == 1) {
            return true;
        }
        return false;
    }

    public void printPrime() {
        Node curr = head;

        while (curr != null) {
            if (isPrime(curr)) {
                System.out.print(curr.data + " -> ");
                curr = curr.next;
            } else {
                curr = curr.next;
            }
        }
    }

    public void printComposite() {
        Node curr = head;

        while (curr != null) {
            if (isComposite(curr)) {
                System.out.print(curr.data + " -> ");
                curr = curr.next;
            } else {
                curr = curr.next;
            }
        }
    }

    public void printOne() {
        Node curr = head;

        while (curr != null) {
            if (isOne(curr)) {
                System.out.print(curr.data + " -> ");
                curr = curr.next;
            } else {
                curr = curr.next;
            }
        }
        System.out.println("null");
    }

    public void printLL() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListPartition ll = new ListPartition();
        ll.addFirst(7);
        ll.addFirst(5);
        ll.addFirst(6);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(4);
        ll.addFirst(3);

        System.out.println("Input:");
        ll.printLL();
        System.out.println("Output:");
        ll.printPrime();
        ll.printComposite();
        ll.printOne();
        System.out.println("Size : " + size);

    }
}