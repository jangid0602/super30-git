package Story5.java;

public class BoundaryTraversal {

    public void printBoundary(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.println(root.value);

        printLeftBoundary(root.leftChild);
        printLeaves(root);
        printRightBoundary(root.rightChild);
    }

    private void printLeftBoundary(TreeNode node) {

        if (node == null) {
            return;
        }

        System.out.println(node.value);
        printLeftBoundary(node.leftChild);
    }

    private void printLeaves(TreeNode node) {

        if (node == null) {
            return;
        }

        if (node.leftChild == null && node.rightChild == null) {
            System.out.println(node.value);
        }

        printLeaves(node.leftChild);
        printLeaves(node.rightChild);
    }

    private void printRightBoundary(TreeNode node) {

        if (node == null) {
            return;
        }

        printRightBoundary(node.rightChild);
        System.out.println(node.value);
    }
}
