import java.util.Scanner;

class CountNode {
    char value;
    int count;
    CountNode next;

    CountNode(char value, int count) {
        this.value = value;
        this.count = count;
        this.next = null;
    }
}

public class CollapsingCountList {

    private CountNode createList(int n, Scanner sc) {
        if (n <= 0) return null;

        System.out.print("Enter value for node 1: ");
        char val = sc.next().charAt(0);
        System.out.print("Enter count for node 1: ");
        int cnt = sc.nextInt();

        CountNode head = new CountNode(val, cnt);
        CountNode curr = head;

        for (int i = 2; i <= n; i++) {
            System.out.print("Enter value for node " + i + ": ");
            val = sc.next().charAt(0);
            System.out.print("Enter count for node " + i + ": ");
            cnt = sc.nextInt();

            curr.next = new CountNode(val, cnt);
            curr = curr.next;
        }
        return head;
    }

    private CountNode collapse(CountNode head) {
        if (head == null) return null;

        CountNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.value == curr.next.value) {
                curr.count += curr.next.count;
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    private void display(CountNode head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        CountNode temp = head;
        while (temp != null) {
            System.out.print("(" + temp.value + ", " + temp.count + ") -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        CollapsingCountList task = new CollapsingCountList();
        Scanner userInput = new Scanner(System.in);

        try {
            System.out.print("Enter number of nodes: ");
            int n = userInput.nextInt();

            if (n < 0)
                throw new Exception("Number of nodes cannot be negative");

            System.out.println("\nEnter node data:");
            CountNode head = task.createList(n, userInput);

            System.out.println("\nOriginal List:");
            task.display(head);

            head = task.collapse(head);

            System.out.println("\nCollapsed List:");
            task.display(head);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            userInput.close();
        }
    }
}
