import java.util.Scanner;

public class LeakyBucket {

     String[] queue;
     int front, rear, size, capacity;

    LeakyBucket(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

  private void enqueue(String item) throws Exception {
        if (capacity == 0)
            throw new Exception("Bucket capacity is zero");

        if (size == capacity) {
            front = (front + 1) % capacity;
            size--;
            System.out.println("Bucket full. Oldest item dropped.");
        }

        queue[rear] = item;
        rear = (rear + 1) % capacity;
        size++;
        System.out.println("Enqueued: " + item);
    }

   private void process(int k) throws Exception {
        if (k < 0)
            throw new Exception("k cannot be negative");

        if (size == 0) {
            System.out.println("Bucket is empty");
            return;
        }

        System.out.println("Processing items:");
        while (k-- > 0 && size > 0) {
            System.out.println(queue[front]);
            front = (front + 1) % capacity;
            size--;
        }
    }

   private void display() {
        if (size == 0) {
            System.out.println("Bucket is empty");
            return;
        }

        System.out.print("Current Bucket: ");
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % capacity;
            System.out.print(queue[idx] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        try {
            System.out.print("Enter bucket capacity: ");
            int capacity = userInput.nextInt();

            if (capacity < 0)
                throw new Exception("Capacity cannot be negative");

            LeakyBucket bucket = new LeakyBucket(capacity);

            while (true) {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Enqueue");
                System.out.println("2. Process");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                int choice = userInput.nextInt();

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter item: ");
                            String item = userInput.next();
                            bucket.enqueue(item);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("Enter number of items to process: ");
                            int k = userInput.nextInt();
                            bucket.process(k);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:
                        bucket.display();
                        break;

                    case 4:
                        System.out.println("Exiting program...");
                        userInput.close();
                        return;

                    default:
                        System.out.println("Invalid choice (Monkey input handled)");
                }
            }

        } catch (Exception e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}
