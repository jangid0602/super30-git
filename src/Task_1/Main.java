package Task_1;

import java.util.*;

public class Main {

    static class AverageStack {

        List<Integer> list = new ArrayList<>();

        // check empty
        public boolean isEmpty() {
            return list.size() == 0;
        }

        // push operation
        public void push(int data) {
            list.add(data);
            System.out.println("null");
        }

        // pop operation
        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            return list.remove(list.size() - 1);
        }

        // top operation
        public int top() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

        // average finder
        public double getAverage() {
            if (isEmpty()) {
                return 0.0;
            }
            double sum = 0;
            for (int x : list) {
                sum += x;
            }
            return sum / list.size();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AverageStack obj = new AverageStack();

        System.out.println(
                "Enter operations (AverageStack, push, pop, top, getAverage, exit):"
        );

        while (true) {

            String input = sc.next();

            if (input.equals("AverageStack")) {
                System.out.println("null");
            }

            else if (input.equals("push")) {
                System.out.println("Enter the element to be pushed");

                if (sc.hasNextInt()) {
                    int n = sc.nextInt();
                    obj.push(n);
                } else {
                    System.out.println("Invalid input! Please enter an integer.");
                    sc.next(); // clear invalid token
                }
            }

            else if (input.equals("pop")) {
                System.out.println(obj.pop());
            }

            else if (input.equals("top")) {
                System.out.println(obj.top());
            }

            else if (input.equals("getAverage")) {
                System.out.println(obj.getAverage());
            }

            else if (input.equals("exit")) {
                break;
            }

            else {
                System.out.println("Not a valid operation");
            }
        }

        sc.close();
    }
}

