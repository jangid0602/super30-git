import java.util.Scanner;

class Node {
    String data;
    Node prev;
    Node next;
    Node child;

    Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
        this.child = null;
    }
}

class Traversal {

    Scanner sc = new Scanner(System.in);

    Node createList(String state) {
        String data = sc.next();
        if (data.equals("-1")) return null;

        Node head = new Node(data);

        System.out.println("Enter child values of " + data + ":");
        head.child = createList("child");

        if (!state.equals("left")) {
            System.out.println("Enter right values of " + data + ":");
            head.next = createList("right");
            if (head.next != null)
                head.next.prev = head;
        }

        if (!state.equals("right")) {
            System.out.println("Enter left values of " + data + ":");
            head.prev = createList("left");
            if (head.prev != null)
                head.prev.next = head;
        }

        return head;
    }

    void printList(Node head, boolean leftToRight) {
        if (head == null) return;

        if (leftToRight) {
            Node left = head;
            while (left.prev != null)
                left = left.prev;

            while (left != null) {
                System.out.print(left.data + " ");
                if (left.child != null)
                    printList(left.child, false);
                left = left.next;
            }
        } else {
            Node right = head;
            while (right.next != null)
                right = right.next;

            while (right != null) {
                System.out.print(right.data + " ");
                if (right.child != null)
                    printList(right.child, true);
                right = right.prev;
            }
        }
    }

    void zigzagTraverse() {
        Node head = createList("start");
        printList(head, true);
    }
}

public class ZigzagFlattenEasy {
    public static void main(String[] args) {
        Traversal t = new Traversal();
        t.zigzagTraverse();
    }
}

