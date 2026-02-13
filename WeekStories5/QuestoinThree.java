import java.util.*;

public class QuestoinThree {

    Set<Integer> result = new HashSet<>();
    TreeNode parent = null;
    public Set<Integer> getDisCousins(Set<Integer> arr, int X) {
        List<Integer> list = new ArrayList<>();
        if (!arr.contains(X))
            return new HashSet<>();
        for (Integer integer : arr) {
            list.add(integer);
        }
        TreeNode root = TreeNode.buildTree(list, 0);

        int level = findLevelDFS(root, X, 0);
        if (level < 2) {
            return new HashSet<>();
        }
        getLevelValue(root, 0, level, X);

        if (result.contains(parent.left.value) && parent.left != null) {
            result.remove(parent.left.value);
        }
        if (result.contains(parent.right.value) && parent.right != null) {
            result.remove(parent.right.value);

        }

        return result;
    }

    public void getLevelValue(TreeNode root, int level, int k, int target) {
        if (root == null) {
            return;
        }

        if ((root.left != null && root.left.value == target) ||
                (root.right != null && root.right.value == target)) {
            parent = root;
        }

        if (level == k) {
            result.add(root.value);
            return;
        }

        getLevelValue(root.left, level + 1, k, target);
        getLevelValue(root.right, level + 1, k, target);
    }

    public int findLevelDFS(TreeNode root, int target, int level) {
        if (root == null)
            return -1;

        if (root.value == target)
            return level;

        int left = findLevelDFS(root.left, target, level + 1);
        if (left != -1)
            return left;

        return findLevelDFS(root.right, target, level + 1);
    }

    public static void main(String[] args) {
        QuestoinThree task = new QuestoinThree();
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.print(Message.startInput);

            String start = userInput.nextLine().trim(); 
            if (start.isEmpty())
                break;

            Set<Integer> list = new HashSet<>();
            System.out.println(Message.inputRules);

            while (true) {
                System.out.print(Message.userInstruction);
                try {
                    String num = userInput.nextLine().trim();

                    if (num.isEmpty())
                        break;

                    list.add(Integer.parseInt(num));
                } catch (Exception e) {
                    System.out.println(Message.error);
                }
            }

            System.out.print(Message.target);
            int X = 0;

            while (true) {
                try {
                    X = Integer.parseInt(userInput.nextLine().trim());
                    break;
                } catch (Exception e) {
                    System.out.println(Message.error);
                }
            }

            System.out.println(task.getDisCousins(list, X));
        }
    }
}
