package Task_6;

import java.util.*;

class LeakyBucket {
    Queue<Integer> q;
    int capacity;

    LeakyBucket(int capacity) {
        this.capacity = capacity;
        q = new ArrayDeque<>();
    }

    void enqueue(int x) {
        if (q.size() == capacity) {
            q.poll(); // drop front
        }
        q.offer(x);
        System.out.println("Element added");
    }

    void process(int k) {
        if (q.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Processed elements: ");
        while (k > 0 && !q.isEmpty()) {
            System.out.print(q.poll() + " ");
            k--;
        }
        System.out.println();
    }

    void display() {
        if (q.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue elements: " + q);
        }
    }
}

public class LeakyBucket_Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements");
        int capacity = sc.nextInt();

        LeakyBucket lb = new LeakyBucket(capacity);

        while (true) {
            System.out.println("\nchoose operation to perform");
            System.out.println("1.Enqueue");
            System.out.println("2.process");
            System.out.println("3.Display");
            System.out.println("4.exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter element");
                    int x = sc.nextInt();
                    lb.enqueue(x);
                    break;

                case 2:
                    System.out.println("Enter number of elements to process");
                    int k = sc.nextInt();
                    lb.process(k);
                    break;

                case 3:
                    lb.display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
