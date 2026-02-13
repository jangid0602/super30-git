import java.util.*;

public  class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public static TreeNode buildTree(List<Integer> arr, int i) {
        TreeNode root = null;

        if (i < arr.size() && arr.get(i) != -1) {
            root = new TreeNode(arr.get(i));

            root.left = buildTree(arr, 2 * i + 1);

            root.right = buildTree(arr, 2 * i + 2);
        }
        return root;
    }
}
