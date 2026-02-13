import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionFour {
    int cameras = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 2) {
            cameras++;
        }
        return cameras;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 1;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == 2 || right == 2) {
            cameras++;
            return 0;
        }

        if (left == 0 || right == 0) {
            return 1;
        }

        return 2;
    }

    public static void main(String[] args) {
        QuestionFour task = new QuestionFour();
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.print(Message.startInput);
            if (userInput.nextLine().isEmpty()) {
                break;
            }
            List<Integer> list = new ArrayList<>();
            System.out.println(Message.camera);
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
            System.out.println(task.minCameraCover(root));
            System.out.println(Message.separator);
        }
    }
}
