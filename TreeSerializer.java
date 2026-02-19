package Story5.java;

public class TreeSerializer {

    public void performSerialization() {

        TreeNode root = new TreeNode(1);

        String serializedData = serialize(root);

        System.out.println("Serialized Tree: " + serializedData);
    }

    private String serialize(TreeNode node) {

        if (node == null) {
            return "null ";
        }

        return node.value + " " + serialize(node.leftChild) + serialize(node.rightChild);
    }
}
