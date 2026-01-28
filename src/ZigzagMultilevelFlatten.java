import java.util.Scanner;

class MultiNode {
    int val;
    MultiNode next, prev, child;

    MultiNode(int val) {
        this.val = val;
        next = prev = child = null;
    }
}

public class ZigzagMultilevelFlatten {

    private MultiNode createList(int n, Scanner sc) {
        if (n <= 0) return null;

        System.out.print("Enter value 1: ");
        MultiNode head = new MultiNode(sc.nextInt());
        MultiNode curr = head;

        for (int i = 2; i <= n; i++) {
            System.out.print("Enter value " + i + ": ");
            MultiNode node = new MultiNode(sc.nextInt());
            curr.next = node;
            node.prev = curr;
            curr = node;
        }
        return head;
    }

    private void attachChild(MultiNode head, int pos, MultiNode child) {
        MultiNode temp = head;
        int index = 1;

        while (temp != null && index < pos) {
            temp = temp.next;
            index++;
        }
        if (temp != null) {
            temp.child = child;
        }
    }

    private MultiNode getTail(MultiNode head) {
        while (head != null && head.next != null)
            head = head.next;
        return head;
    }

    private void zigzagDFS(MultiNode node, boolean leftToRight) {
        if (node == null) return;

        if (leftToRight) {
            while (node != null) {
                System.out.print(node.val + " ");
                if (node.child != null) {
                    zigzagDFS(node.child, false);
                }
                node = node.next;
            }
        } else {
            MultiNode tail = getTail(node);
            while (tail != null) {
                System.out.print(tail.val + " ");
                if (tail.child != null) {
                    zigzagDFS(tail.child, true);
                }
                tail = tail.prev;
            }
        }
    }

    public static void main(String[] args) {
        ZigzagMultilevelFlatten task = new ZigzagMultilevelFlatten();
        Scanner userInput = new Scanner(System.in);

        try {
            System.out.print("Enter number of nodes in main list: ");
            int n = userInput.nextInt();

            if (n <= 0)
                throw new Exception("List size must be positive");

            MultiNode head = task.createList(n, userInput);

            System.out.print("Enter number of child lists: ");
            int c = userInput.nextInt();

            for (int i = 1; i <= c; i++) {
                System.out.print("\nAttach child list " + i + " at position: ");
                int pos = userInput.nextInt();

                System.out.print("Enter size of child list: ");
                int size = userInput.nextInt();

                MultiNode child = task.createList(size, userInput);
                task.attachChild(head, pos, child);
            }

            System.out.println("\nZigzag Flatten Output:");
            task.zigzagDFS(head, true);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
