package Codeup.Story_3;

import java.util.*;

public class Task_6 {

    static class LeakyBucket {
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
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of elements: ");
            int capacity = sc.nextInt();

            LeakyBucket lb = new LeakyBucket(capacity);

            while (true) {
                System.out.println("""
                        ==========Choose an operation==========
                        1.Enqueue
                        2.Process
                        3.Display
                        4.Exit
                        """);

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
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
    }

