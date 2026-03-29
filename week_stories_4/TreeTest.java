import java.util.Scanner;

class Node {
    int wealth;
    Node left;
    Node right;

    Node(int wealth) {
        this.wealth = wealth;
    }
}

class AncestryTree {

    Scanner sc = new Scanner(System.in);

    // Preorder input: root left right
    public Node takeInput() {
        int wealth = sc.nextInt();

        if (wealth == -1) {
            return null;
        }

        Node root = new Node(wealth);
        root.left = takeInput();
        root.right = takeInput();

        return root;
    }

    // Total Legacy = self + descendants
    public int calculateLegacy(Node person) {
        if (person == null)
            return 0;

        return person.wealth + calculateLegacy(person.left) + calculateLegacy(person.right);
    }
}

class TreeTest {
    public static void main(String[] args) {
        AncestryTree tree = new AncestryTree();

        System.out.println("Enter tree data in preorder (-1 for no node):");
        Node root = tree.takeInput();

        System.out.println("Total Legacy: " + tree.calculateLegacy(root));
    }
}


