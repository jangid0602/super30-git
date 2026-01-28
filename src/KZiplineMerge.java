import java.util.Scanner;

class ZipNode {
    int val;
    ZipNode next;

    ZipNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class KZiplineMerge {

    private ZipNode createList(int n, Scanner sc) {
        if (n <= 0) return null;

        System.out.print("Enter value 1: ");
        ZipNode head = new ZipNode(sc.nextInt());
        ZipNode curr = head;

        for (int i = 2; i <= n; i++) {
            System.out.print("Enter value " + i + ": ");
            curr.next = new ZipNode(sc.nextInt());
            curr = curr.next;
        }
        return head;
    }

    private void display(ZipNode head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        ZipNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    private ZipNode merge(ZipNode h1, ZipNode h2, int k) throws Exception {
        if (k <= 0)
            throw new Exception("k must be greater than 0");

        ZipNode dummy = new ZipNode(0);
        ZipNode curr = dummy;

        while (h1 != null || h2 != null) {

            for (int i = 0; i < k && h1 != null; i++) {
                curr.next = h1;
                h1 = h1.next;
                curr = curr.next;
            }

            for (int i = 0; i < k && h2 != null; i++) {
                curr.next = h2;
                h2 = h2.next;
                curr = curr.next;
            }
        }
        curr.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        KZiplineMerge task = new KZiplineMerge();
        Scanner userInput = new Scanner(System.in);

        try {
            System.out.print("Enter number of nodes in List 1: ");
            int n1 = userInput.nextInt();

            System.out.print("Enter number of nodes in List 2: ");
            int n2 = userInput.nextInt();

            if (n1 < 0 || n2 < 0)
                throw new Exception("Size cannot be negative");

            System.out.println("\nEnter elements of List 1");
            ZipNode head1 = task.createList(n1, userInput);

            System.out.println("\nEnter elements of List 2");
            ZipNode head2 = task.createList(n2, userInput);

            System.out.print("\nEnter value of k: ");
            int k = userInput.nextInt();

            System.out.println("\nList 1:");
            task.display(head1);

            System.out.println("List 2:");
            task.display(head2);

            ZipNode merged = task.merge(head1, head2, k);

            System.out.println("\nK-Zipline Merged List:");
            task.display(merged);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            userInput.close();
        }
    }
}
