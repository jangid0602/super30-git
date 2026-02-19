import java.util.*;

public class LeakyBucket {
    private final int capacity;
    private final Queue<Object> queue;
    public LeakyBucket(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }
    public void enqueue(Object item) {
        if (queue.size() == capacity) {
            queue.poll(); // Remove the front item to make room
        }
        queue.add(item);
    }
    public Object[] process(int k) {
        // Determine how many items we can actually remove
        int count = Math.min(k, queue.size());
        Object[] processedItems = new Object[count];

        for (int i = 0; i < count; i++) {
            processedItems[i] = queue.poll();
        }

        return processedItems;
    }
    public static void main(String[] args) {
        System.out.println("--- Running Test 1 ---");
        LeakyBucket lb1 = new LeakyBucket(3);
        lb1.enqueue(1);
        lb1.enqueue(2);
        lb1.enqueue(3);
        lb1.enqueue(4);
        System.out.println("Processed (k=2): " + Arrays.toString(lb1.process(2))); // Expected: [2, 3]

    }
}
