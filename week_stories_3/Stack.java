import java.util.ArrayList;
import java.util.Scanner;

public class stack {
    static class AverageStack {
        static int total = 0, size = 0;
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        public static void push(int data) {
            list.add(data);
            size++;
            total += data;
        }

        public static int pop() {

            if (list.isEmpty()) {
                return -1;
            }

            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            size--;
            total -= top();
            return top;
        }

        public static int top() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

        public static double getAverage() {
            return total / size;
        }

    }

    public static void main(String[] args) {
        AverageStack st = new AverageStack();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Average Stack Menu ---");
            System.out.println("1 Push");
            System.out.println("2 Pop");
            System.out.println("3 Top");
            System.out.println("4 Get Average");
            System.out.println("0 Exit Stack");
            System.out.print("Enter choice: ");

            int op = sc.nextInt();

            if (op == 0)
                break;

            switch (op) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    st.push(val);
                    break;

                case 2:
                    int popped = st.pop();
                    if (popped == -1)
                        System.out.println("Stack is empty");
                    else
                        System.out.println("Popped: " + popped);
                    break;

                case 3:
                    int top = st.top();
                    if (top == -1)
                        System.out.println("Stack is empty");
                    else
                        System.out.println("Top: " + top);
                    break;

                case 4:
                    System.out.println("Average: " + st.getAverage());
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
