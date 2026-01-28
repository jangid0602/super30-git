import java.util.Scanner;

class Node2D {
    int val;
    Node2D right, down;

    Node2D(int val) {
        this.val = val;
        right = down = null;
    }
}

public class Transpose2DLinkedList {

    private Node2D createList(int rows, int cols, Scanner sc) {
        Node2D[][] nodes = new Node2D[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter value [" + i + "][" + j + "]: ");
                nodes[i][j] = new Node2D(sc.nextInt());
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j + 1 < cols)
                    nodes[i][j].right = nodes[i][j + 1];
                if (i + 1 < rows)
                    nodes[i][j].down = nodes[i + 1][j];
            }
        }
        return nodes[0][0];
    }

    private void transpose(Node2D head) {
        Node2D row = head;

        while (row != null) {
            Node2D curr = row;
            while (curr != null) {
                Node2D temp = curr.right;
                curr.right = curr.down;
                curr.down = temp;
                curr = curr.down;
            }
            row = row.right;
        }
    }

    private void display(Node2D head) {
        Node2D row = head;
        while (row != null) {
            Node2D curr = row;
            while (curr != null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
            System.out.println();
            row = row.down;
        }
    }

    public static void main(String[] args) {
        Transpose2DLinkedList task = new Transpose2DLinkedList();
        Scanner userInput = new Scanner(System.in);
        try {
            System.out.print("Enter number of rows: ");
            int rows = userInput.nextInt();
            System.out.print("Enter number of columns: ");
            int cols = userInput.nextInt();

            if (rows <= 0 || cols <= 0)
                throw new Exception("Rows and columns must be positive");

            Node2D head = task.createList(rows, cols, userInput);

            System.out.println("\nOriginal 2D Linked List:");
            task.display(head);

            task.transpose(head);

            System.out.println("\nTransposed 2D Linked List:");
            task.display(head);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
