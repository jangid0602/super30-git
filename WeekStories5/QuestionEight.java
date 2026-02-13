import java.util.*;

public class QuestionEight {

    public int getLCA(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode current = q.poll();
                if (current != null)
                    list.add(current.value);

                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
            }
            result.add(new ArrayList<>(list));
        }

        int ans = -1;

        for (int i = result.size() - 1; i >= 0; i--) {
            int temp = result.get(i).get(0);
            boolean flag = true;
            for (int j = 0; j < result.get(i).size(); j++) {
                if (temp != result.get(i).get(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = temp;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        QuestionEight task = new QuestionEight();
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.print(Message.startInput);
            if (userInput.nextLine().isEmpty())
                break;
            System.out.println(Message.eight);
            List<Integer> list = new ArrayList<>();
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
            System.out.println(task.getLCA(root));
            System.out.println(Message.separator);
        }

    }
}
