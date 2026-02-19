public class PrimePartition {
    private static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    public Node partitionPrimes(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node primeHead = new Node(0), p = primeHead;
        Node compHead = new Node(0), c = compHead;
        Node oneHead = new Node(0), o = oneHead;

        Node curr = head;
        while (curr != null) {

            if (curr.val < 1) {
                throw new IllegalArgumentException("Invalid input: Values must be >= 1");
            }

            Node nextTemp = curr.next;
            curr.next = null;

            if (curr.val == 1) {
                o.next = curr;
                o = o.next;
            } else if (isPrime(curr.val)) {
                p.next = curr;
                p = p.next;
            } else {
                c.next = curr;
                c = c.next;
            }
            curr = nextTemp;
        }
        p.next = compHead.next;
        Node currentTail = (c != compHead) ? c : p;
        currentTail.next = oneHead.next;

        return primeHead.next;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrimePartition solver = new PrimePartition();

        // Creating the list: 3 -> 4 -> 1 -> 2 -> 6 -> 5 -> 7
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(7);

        System.out.print("Input:  ");
        printList(head);

        Node result = solver.partitionPrimes(head);

        System.out.print("Output: ");
        printList(result);
    }
}