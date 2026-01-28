import java.util.Scanner;

class PrimeNode {
    int val;
    PrimeNode next;

    PrimeNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PrimeCompositePartition {

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    private PrimeNode createList(int n, Scanner sc) {
        if (n <= 0) return null;

        System.out.print("Enter value 1: ");
        PrimeNode head = new PrimeNode(sc.nextInt());
        PrimeNode curr = head;

        for (int i = 2; i <= n; i++) {
            System.out.print("Enter value " + i + ": ");
            curr.next = new PrimeNode(sc.nextInt());
            curr = curr.next;
        }
        return head;
    }

    private void display(PrimeNode head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        PrimeNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    private PrimeNode partition(PrimeNode head) {
        PrimeNode primeD = new PrimeNode(0);
        PrimeNode compD = new PrimeNode(0);
        PrimeNode oneD  = new PrimeNode(0);

        PrimeNode p = primeD;
        PrimeNode c = compD;
        PrimeNode o = oneD;

        while (head != null) {
            if (head.val == 1) {
                o.next = head;
                o = o.next;
            } else if (isPrime(head.val)) {
                p.next = head;
                p = p.next;
            } else {
                c.next = head;
                c = c.next;
            }
            head = head.next;
        }

        p.next = compD.next;
        c.next = oneD.next;
        o.next = null;

        return primeD.next;
    }

    public static void main(String[] args) {
        PrimeCompositePartition task = new PrimeCompositePartition();
        Scanner userInput = new Scanner(System.in);

        try {
            System.out.print("Enter number of nodes: ");
            int n = userInput.nextInt();

            if (n < 0)
                throw new Exception("Number of nodes cannot be negative");

            System.out.println("\nEnter linked list elements:");
            PrimeNode head = task.createList(n, userInput);

            System.out.println("\nOriginal List:");
            task.display(head);

            head = task.partition(head);

            System.out.println("\nPartitioned List (Prime -> Composite -> 1):");
            task.display(head);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            userInput.close();
        }
    }
}
