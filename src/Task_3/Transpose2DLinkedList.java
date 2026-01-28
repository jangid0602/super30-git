package Task_3;

import java.util.*;

class Node {
    int val;
    Node right;
    Node down;

    Node(int val) {
        this.val = val;
        this.right = null;
        this.down = null;
    }
}

public class Transpose2DLinkedList {

    // Function to transpose the 2D linked list
    public static Node transpose(Node head) {
        if (head == null) return null;

        Node row = head;

        while (row != null) {
            Node col = row;

            while (col != null) {
                // swap right and down
                Node temp = col.right;
                col.right = col.down;
                col.down = temp;

                // move to next column (original right)
                col = col.down;
            }

            // move to next row (original down)
            row = row.right;
        }

        return head;
    }

    // Print 2D linked list
    public static void print2DList(Node head) {
        Node row = head;
        while (row != null) {
            Node col = row;
            while (col != null) {
                System.out.print(col.val + " ");
                col = col.right;
            }
            System.out.println();
            row = row.down;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();

        if (r == 0 || c == 0) {
            System.out.println("Empty list");
            return;
        }

        Node[][] nodes = new Node[r][c];

        System.out.println("Enter elements row-wise:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                nodes[i][j] = new Node(sc.nextInt());
            }
        }

        // connect right & down pointers
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (j + 1 < c)
                    nodes[i][j].right = nodes[i][j + 1];
                if (i + 1 < r)
                    nodes[i][j].down = nodes[i + 1][j];
            }
        }

        Node head = nodes[0][0];

        System.out.println("\nOriginal 2D Linked List:");
        print2DList(head);

        head = transpose(head);

        System.out.println("\nTransposed 2D Linked List:");
        print2DList(head);

        sc.close();
    }
}
