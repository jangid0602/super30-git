import java.util.*;
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class The_Digital_Ancestry {
    int index = -1;

        private TreeNode buildTree(List<Integer> list) {
            index++;

            if (index >= list.size()) {
                return null;
            }

            if (list.get(index) == -1) {
                return null;
            }

            TreeNode root = new TreeNode(list.get(index));
            root.left = buildTree(list);
            root.right = buildTree(list);
            return root;
        }



    private int printTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.value;
        sum += printTree(root.left);
        sum += printTree(root.right);

        return sum;
    }

    public static void main() {

        The_Digital_Ancestry task = new The_Digital_Ancestry();
        Scanner userInput = new Scanner(System.in);
        String rules = """
                Notes :- where you want null node, (just enter -1)
                        like :- In array [ 1 2 3 4 5 ]
                        1 -> root node
                        2 -> left child of root
                        3 -> right child of root
                        { (2 left -> 4), (2 right -> 5)}
                """;
        System.out.println(rules);
        List<Integer> list = new ArrayList<>();
        while (true) {
            try {
                System.out.print("\u001B[33mEnter value (0 to exit):- ");
                int value = Integer.parseInt(userInput.nextLine());
                if (value == 0){
                    break;
                }
                list.add(value);
            } catch (Exception error) {
                System.out.println("\u001B[31mError :- "+error.getMessage());
            }

        }
        System.out.println("\u001B[33m"+task.printTree(task.buildTree(list)));

    }
}

