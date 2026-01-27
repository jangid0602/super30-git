import java.util.Scanner;
class Node{
    String value;
    Node next;
    Node down;
    Node(String value){
        this.value = value;
    }
}
public class TransposeNodeOfLL{
    public static Node input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        if (rows == 0 || cols == 0) return null;

        Node[][] nodes = new Node[rows][cols];

        System.out.println("Enter values row-wise:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nodes[i][j] = new Node(sc.next());
            }
        }

        // link next and down
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j + 1 < cols)
                    nodes[i][j].next = nodes[i][j + 1];
                if (i + 1 < rows)
                    nodes[i][j].down = nodes[i + 1][j];
            }
        }

        return nodes[0][0]; // head node
    }

    public static void print(Node head){
        Node row = head, col;
        while(row != null){
            col = row;
            while(col != null){
                System.out.print(col.value + " ");
                col = col.next;
            }
            System.out.println();
            row = row.down;
        }
    }
    public static void transpose(Node head){
        Node row = head, col;
        while(row != null){
            col = row;
            while(col != null){
                Node temp = col.next;
                col.next = col.down;
                col.down = temp;
                col = col.next;
            }
            row = row.down;
        }
    }
    public static void main(String[] args){
        Node a = input();
        System.out.println("Original list : ");
        print(a);
        transpose(a);
        System.out.println("Transposed list : ");
        print(a);
    }
}