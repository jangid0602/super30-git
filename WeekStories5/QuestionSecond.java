import java.util.*;

public class QuestionSecond {
    public List<List<Integer>> getTopView(TreeNode root) {
        Queue<Node> q = new LinkedList<>();

        if (root == null) {
            return new ArrayList<>();
        }
        q.add(new Node(0, root));
        Map<Integer, List<Integer>> map = new TreeMap<>();
        while (!q.isEmpty()) {
            Node current = q.remove();

            if (!map.containsKey(current.hdValue)) {
                List<Integer> newList = new ArrayList<>();
                newList.add(current.HD.value);
                map.put(current.hdValue, newList);
            }

            else if (map.containsKey(current.hdValue)) {
                List<Integer> temp = map.get(current.hdValue);
                temp.add(current.HD.value);
                map.put(current.hdValue, temp);
            }

            if (current.HD.left != null) {
                q.add(new Node(current.hdValue - 1, current.HD.left));
            }

            if (current.HD.right != null) {
                q.add(new Node(current.hdValue + 1, current.HD.right));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Integer list : map.keySet()) {
            result.add(map.get(list));
        }
        return result;
    }

    public static void main(String[] args) {
        QuestionSecond task = new QuestionSecond();
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.print(Message.startInput);
            if (userInput.nextLine().isEmpty()) {
                break;
            }
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
            System.out.println(task.getTopView(root));
            System.out.println(Message.separator);
        }
    }
}
