import java.util.*;

public class QuestionSix {

    public void getMaxPath(TreeNode root, List<Integer> current, int target, List<List<Integer>> totalAns) {
        if (root == null) {
            return;
        }

        current.add(root.value);
        target -= root.value;

        if (target == 0) {
            totalAns.add(new ArrayList<>(current));
        }
        getMaxPath(root.left, current, target, totalAns);
        getMaxPath(root.right, current, target, totalAns);

        target += current.get(current.size() - 1);
        current.remove(current.size() - 1);
        getMaxPath(root.right, current, target, totalAns);

    }

    public static void main(String[] args) {
        QuestionSix task = new QuestionSix();
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.print(Message.startInput);

            String start = userInput.nextLine(); // FIXED
            if (start.isEmpty())
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

            System.out.print(Message.target);
            int target = 0;

            do {
                try {
                    target = Integer.parseInt(userInput.nextLine());
                    break;
                } catch (Exception e) {
                    System.err.println(Message.error);
                }
            } while (true);

            List<List<Integer>> result = new ArrayList<>();
            TreeNode root = TreeNode.buildTree(list, 0);
            task.getMaxPath(root, new ArrayList<>(), target, result);
            System.out.println(result);
        }

    }
}
