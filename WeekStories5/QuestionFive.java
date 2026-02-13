import java.util.*;

public class QuestionFive {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    public void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(Message.nullValue).append(",");
            return;
        }

        sb.append(node.value).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return deserializeHelper(queue);
    }

    public TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();

        if (val.equals(Message.nullValue)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);

        return node;
    }

    public static void main(String[] args) {
        QuestionFive task = new QuestionFive();
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
            String serialized = task.serialize(root);
            System.out.println("Serialized: " + serialized);
            TreeNode deserializedRoot = task.deserialize(serialized);
            System.out.println("Deserialization successful: " + (deserializedRoot != null));
            System.out.println(Message.separator);
        }
    }
}
