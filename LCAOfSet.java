package Story5.java;

public class LCAOfSet {

    public void findLCA(TreeNode root, int value1, int value2) {

        TreeNode lcaNode = findLowestCommonAncestor(root, value1, value2);

        if (lcaNode != null) {
            System.out.println("LCA is: " + lcaNode.value);
        }
    }

    private TreeNode findLowestCommonAncestor(TreeNode node, int value1, int value2) {

        if (node == null) {
            return null;
        }

        if (node.value == value1 || node.value == value2) {
            return node;
        }

        TreeNode left = findLowestCommonAncestor(node.leftChild, value1, value2);
        TreeNode right = findLowestCommonAncestor(node.rightChild, value1, value2);

        if (left != null && right != null) {
            return node;
        }

        if (left != null) {
            return left;
        }

        return right;
    }
}
