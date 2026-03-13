package week3story;

import java.util.Stack;

public class Average {
    public static void main(String[] args) {
       
        AverageStack obj = new AverageStack();
        obj.push(10);
        obj.push(20);
        System.out.println(obj.getAverage());

        obj.push(30);
        System.out.println(obj.getAverage());

        System.out.println(obj.pop());
        System.out.println(obj.getAverage());
    }
}

class AverageStack {
    private Stack<Integer> stack;
    private long sum;

    public AverageStack() {
        stack = new Stack<>();
        sum = 0;
    }

    public void push(int val) { // O(1)
        stack.push(val);
        sum += val;
    }
    public int pop() { // O(1)
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        int removed = stack.pop();
        sum -= removed;
        return removed;
    }

    public int top() { // O(1)
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return stack.peek();
    }

    public double getAverage() { // O(1)
        // We return 0.0 to avoid division by zero.
        if (stack.isEmpty()) {
            return 0.0;
        }
        return (double) sum / stack.size();
    }
}