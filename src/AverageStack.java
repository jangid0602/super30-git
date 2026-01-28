import java.util.Scanner;

class AverageStack {

    private final int[] stack;
    private int top;
    private long sum;

    public AverageStack(int size) {
        stack = new int[size];
        top = -1;
        sum = 0;
    }

    public void push(int val) throws Exception {
        if (top == stack.length - 1) {
            throw new Exception("Stack Overflow");
        }
        stack[++top] = val;
        sum += val;
        System.out.println(val + " pushed successfully");
    }

    public int pop() throws Exception {
        if (top == -1) {
            throw new Exception("Stack Underflow");
        }
        int val = stack[top--];
        sum -= val;
        return val;
    }

    public int top() throws Exception {
        if (top == -1) {
            throw new Exception("Stack is Empty");
        }
        return stack[top];
    }

    public double getAverage() {
        if (top == -1) {
            return 0.0;
        }
        return (double) sum / (top + 1);
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        try {
            System.out.print("Enter stack size: ");
            int size = userInput.nextInt();

            if (size <= 0) {
                throw new Exception("Invalid stack size");
            }

            AverageStack st = new AverageStack(size);

            String operations = """
                        \n--- MENU ---
                    1. Push
                    2. Pop
                    3. Top
                    4. Get Average
                    5. Display
                    6. Exit
                    """;
            while (true) {
                System.out.println(operations);
                System.out.print("Enter choice: ");

                int choice = userInput.nextInt();

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter value: ");
                            int val = userInput.nextInt();
                            st.push(val);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            int popped = st.pop();
                            System.out.println("Popped value: " + popped);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:
                        try {
                            System.out.println("Top element: " + st.top());
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.println("Average: " + st.getAverage());
                        break;

                    case 5:
                        st.display();
                        break;

                    case 6:
                        System.out.println("Exiting program...");
                        userInput.close();
                        return;

                    default:
                        System.out.println("Invalid choice (Monkey testing handled)");
                }
            }
        } catch (Exception e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}
