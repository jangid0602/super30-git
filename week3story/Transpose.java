package week3story;

public class Transpose {

    static class Node {
        int data;
        Node right;
        Node down;

        Node(int data) {
            this.data = data;
        }
    }

    // ===== SAFE TRANSPOSE =====
    public static Node transpose(Node head) {

        if (head == null)
            return null;

        Node colStart = head;

        while (colStart != null) {

            Node curr = colStart;

            while (curr != null) {
                // swap pointers
                Node temp = curr.right;
                curr.right = curr.down;
                curr.down = temp;

                // move using OLD down (stored in temp after swap)
                curr = curr.right;
            }

            // move to next column (original right)
            colStart = colStart.down;
        }
        return head;
    }
    // ===== Print =====
    public static void print2DLL(Node head) {
        Node row = head;
        while (row != null) {
            Node col = row;
            while (col != null) {
                System.out.print(col.data + " ");
                col = col.right;
            }
            System.out.println();
            row = row.down;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.right = n2;
        n2.right = n3;
        n4.right = n5;
        n5.right = n6;

        n1.down = n4;
        n2.down = n5;
        n3.down = n6;

        Node head = n1;

        System.out.println("Original:");
        print2DLL(head);

        head = transpose(head);

        System.out.println("\nAfter Transpose:");
        print2DLL(head);
    }
}
