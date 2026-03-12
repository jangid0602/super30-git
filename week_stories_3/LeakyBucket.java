import java.util.*;

class LeakyBucket {

    int capacity;
    Queue<Object> queue;

    // Constructor
    LeakyBucket(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    // Enqueue item
    void enqueue(Object item) {
        if (queue.size() == capacity) {
            queue.remove();   // drop oldest item
        }
        queue.add(item);
    }

    // Process k items
    List<Object> process(int k) {
        List<Object> result = new ArrayList<>();

        while (k > 0 && !queue.isEmpty()) {
            result.add(queue.remove());
            k--;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take bucket capacity
        System.out.print("Enter bucket capacity: ");
        int capacity = sc.nextInt();

        LeakyBucket bucket = new LeakyBucket(capacity);

        while (true) {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Process");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter item: ");
                String item = sc.next();   // taking input as String
                bucket.enqueue(item);

            } else if (choice == 2) {
                System.out.print("Enter number of items to process: ");
                int k = sc.nextInt();
                System.out.println("Processed items: " + bucket.process(k));

            } else if (choice == 3) {
                System.out.println("Program ended.");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
