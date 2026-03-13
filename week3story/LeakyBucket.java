package week3story;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeakyBucket {
    private Queue<Object> queue;
    private int capacity;

    // Constructor
    public LeakyBucket(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    // Enqueue operation
    public void enqueue(Object item) {
        if (queue.size() == capacity) {
            queue.poll(); // drop front item
        }
        queue.offer(item);
    }

    // Process k items
    public Object[] process(int k) {
        List<Object> processed = new ArrayList<>();

        while (k > 0 && !queue.isEmpty()) {
            processed.add(queue.poll());
            k--;
        }

        return processed.toArray();
    }

    // ---- Test Driver ----
    public static void main(String[] args) {

        // Test Case 1
        LeakyBucket lb1 = new LeakyBucket(3);
        lb1.enqueue(1);
        lb1.enqueue(2);
        lb1.enqueue(3);
        lb1.enqueue(4);  
        System.out.println(Arrays.toString(lb1.process(2))); 

        // Test Case 2
        LeakyBucket lb2 = new LeakyBucket(2);
        lb2.enqueue("A");
        System.out.println(Arrays.toString(lb2.process(2))); 
        lb2.enqueue("B");
        lb2.enqueue("C"); 
        lb2.enqueue("D");
        System.out.println(Arrays.toString(lb2.process(1)));
    }
}
