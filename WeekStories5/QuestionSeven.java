import java.util.*;

public class QuestionSeven {

    public List<Integer> getBoundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        result.add(root.value);

        addLeftBoundary(root.left, result);

        addLeaves(root.left, result);
        addLeaves(root.right, result);

        addRightBoundary(root.right, result);

        return result;
    }

    public void addLeftBoundary(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (!isLeaf(node))
                result.add(node.value);

            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    public void addRightBoundary(TreeNode node, List<Integer> result) {
        Stack<Integer> stack = new Stack<>();

        while (node != null) {
            if (!isLeaf(node))
                stack.push(node.value);

            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }

        while (!stack.isEmpty())
            result.add(stack.pop());
    }

    private void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        if (isLeaf(node)) {
            result.add(node.value);
            return;
        }

        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        QuestionSeven task = new QuestionSeven();
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.print(Message.startInput);
            if (userInput.nextLine().isEmpty())
                break;

            List<Integer> list = new ArrayList<>();
            System.out.println(Message.inputRules);

            while (true) {
                System.out.print(Message.userInstruction);
                try {
                    String num = userInput.nextLine();
                    if (num.isEmpty())
                        break;

                    list.add(Integer.parseInt(num));
                } catch (Exception e) {
                    System.out.println(Message.error);
                }
            }

            TreeNode root = TreeNode.buildTree(list, 0);
            System.out.println(task.getBoundary(root));
            System.out.println(Message.separator);
        }
    }
}
