import java.util.List;

public class CharTreeNode {

    char ch;
    CharTreeNode left;
    CharTreeNode right;

    public CharTreeNode(char ch) {
        this.ch = ch;
        this.left = null;
        this.right = null;
    }

    public static CharTreeNode buildTree(List<Character> arr, int i) {
        CharTreeNode root = null;

        if (i < arr.size() && arr.get(i) != -1) {
            root = new CharTreeNode(arr.get(i));

            root.left = buildTree(arr, 2 * i + 1);

            root.right = buildTree(arr, 2 * i + 2);
        }
        return root;
    }
}