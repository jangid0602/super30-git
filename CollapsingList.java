import java.util.Stack;

public class CollapsingList {
    static class Node {
        Object value;
        int count;
        Node next;

        Node(Object value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public Node collapse(Node head) {
        if (head == null) return null;

        Stack<Node> stack = new Stack<>();
        Node curr = head;

        while (curr != null) {
            if (!stack.isEmpty() && stack.peek().value.equals(curr.value)) {
                stack.peek().count += curr.count; // Merge counts
            } else {
                stack.push(new Node(curr.value, curr.count));
            }
            curr = curr.next;
        }

        // Reconstruct the linked list from the stack
        Node resultHead = null;
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            temp.next = resultHead;
            resultHead = temp;
        }

        return resultHead;
    }
}