import java.util.*;

/*
 * Menu Driven Implementation
 */

public class WeekFiveProblems {

    /*
     * Integer Tree Node
     */
    static class TreeNode {
        int value; // node value
        TreeNode left; // left child
        TreeNode right; // right child

        TreeNode(int value) {
            this.value = value;
        }
    }

    /*
     * Character Tree Node (Problem 1)
     */
    static class CharTreeNode {
        char value; // character value
        CharTreeNode left;
        CharTreeNode right;

        CharTreeNode(char value) {
            this.value = value;
        }
    }

    /*
     * Integer Tree Builder
     */
    static class IntegerTreeBuilder {

        public static TreeNode buildTree(Scanner sc) {

            System.out.println("Enter number of elements:");
            int n = sc.nextInt();

            if (n == 0)
                return null;

            System.out.println("Enter level order values (-1 for null):");

            Integer[] arr = new Integer[n];

            for (int i = 0; i < n; i++) {
                int input = sc.nextInt();
                arr[i] = (input == -1) ? null : input;
            }

            if (arr[0] == null)
                return null;

            TreeNode root = new TreeNode(arr[0]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int index = 1;

            while (!queue.isEmpty() && index < n) {

                TreeNode current = queue.poll();

                if (arr[index] != null) {
                    current.left = new TreeNode(arr[index]);
                    queue.add(current.left);
                }
                index++;

                if (index < n && arr[index] != null) {
                    current.right = new TreeNode(arr[index]);
                    queue.add(current.right);
                }
                index++;
            }

            return root;
        }
    }

    /*
     * Character Tree Builder
     */
    static class CharTreeBuilder {

        public static CharTreeNode buildTree(Scanner sc) {

            System.out.println("Enter number of elements:");
            int n = sc.nextInt();

            if (n == 0)
                return null;

            System.out.println("Enter level order characters (# for null):");

            String[] arr = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }

            if (arr[0].equals("#"))
                return null;

            CharTreeNode root = new CharTreeNode(arr[0].charAt(0));
            Queue<CharTreeNode> queue = new LinkedList<>();
            queue.add(root);

            int index = 1;

            while (!queue.isEmpty() && index < n) {

                CharTreeNode current = queue.poll();

                if (!arr[index].equals("#")) {
                    current.left = new CharTreeNode(arr[index].charAt(0));
                    queue.add(current.left);
                }
                index++;

                if (index < n && !arr[index].equals("#")) {
                    current.right = new CharTreeNode(arr[index].charAt(0));
                    queue.add(current.right);
                }
                index++;
            }

            return root;
        }
    }

    /*
     * 1. Palindromic Path Finder
     */
    static class PalindromicPathFinder {

        private int pathCount = 0; // stores valid paths count

        public int countPaths(CharTreeNode root) {
            dfs(root, 0);
            return pathCount;
        }

        private void dfs(CharTreeNode node, int mask) {

            if (node == null)
                return;

            mask ^= (1 << (node.value - 'a')); // toggle bit

            if (node.left == null && node.right == null) {

                if ((mask & (mask - 1)) == 0) { // palindrome check
                    pathCount++;
                }
            }

            dfs(node.left, mask);
            dfs(node.right, mask);
        }
    }

    /*
     * 2. Vertical Silhouette
     */
    static class VerticalSilhouette {

        static class NodeInfo {
            TreeNode node;
            int hd;
            int level;

            NodeInfo(TreeNode node, int hd, int level) {
                this.node = node;
                this.hd = hd;
                this.level = level;
            }
        }

        public void printVertical(TreeNode root) {

            TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

            Queue<NodeInfo> queue = new LinkedList<>();
            queue.add(new NodeInfo(root, 0, 0));

            while (!queue.isEmpty()) {

                NodeInfo current = queue.poll();

                map.putIfAbsent(current.hd, new TreeMap<>());
                map.get(current.hd)
                        .putIfAbsent(current.level, new ArrayList<>());

                map.get(current.hd)
                        .get(current.level)
                        .add(current.node.value);

                if (current.node.left != null)
                    queue.add(new NodeInfo(current.node.left,
                            current.hd - 1,
                            current.level + 1));

                if (current.node.right != null)
                    queue.add(new NodeInfo(current.node.right,
                            current.hd + 1,
                            current.level + 1));
            }

            System.out.println("Vertical Order:");

            for (var column : map.values()) {

                List<Integer> result = new ArrayList<>();

                for (var level : column.values()) {
                    Collections.sort(level);
                    result.addAll(level);
                }

                System.out.println(result);
            }
        }
    }

    /*
     * 3. Distant Cousins
     */
    static class DistantCousins {

        public void findCousins(TreeNode root, int target) {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            boolean found = false;

            while (!queue.isEmpty() && !found) {

                int size = queue.size();
                List<Integer> cousins = new ArrayList<>();

                for (int i = 0; i < size; i++) {

                    TreeNode current = queue.poll();

                    if ((current.left != null && current.left.value == target) ||
                            (current.right != null && current.right.value == target)) {

                        found = true;

                    } else {

                        if (current.left != null) {
                            queue.add(current.left);
                            cousins.add(current.left.value);
                        }

                        if (current.right != null) {
                            queue.add(current.right);
                            cousins.add(current.right.value);
                        }
                    }
                }

                if (found) {
                    System.out.println("Cousins: " + cousins);
                    return;
                }
            }

            System.out.println("No cousins found.");
        }
    }

    /*
     * 4. Minimum Camera Coverage
     */
    static class MinimumCameraCoverage {

        private int cameraCount = 0;

        public int getMinimumCameras(TreeNode root) {

            if (dfs(root) == 0)
                cameraCount++;

            return cameraCount;
        }

        private int dfs(TreeNode node) {

            if (node == null)
                return 1;

            int left = dfs(node.left);
            int right = dfs(node.right);

            if (left == 0 || right == 0) {
                cameraCount++;
                return 2;
            }

            if (left == 2 || right == 2)
                return 1;

            return 0;
        }
    }

    /*
     * 5. Serializer & Deserializer
     */
    static class SerializerDeserializer {

        public String serialize(TreeNode root) {

            StringBuilder sb = new StringBuilder();
            serializeHelper(root, sb);
            return sb.toString();
        }

        private void serializeHelper(TreeNode node,
                StringBuilder sb) {

            if (node == null) {
                sb.append("null,");
                return;
            }

            sb.append(node.value).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }

        public TreeNode deserialize(String data) {

            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

            return deserializeHelper(queue);
        }

        private TreeNode deserializeHelper(Queue<String> queue) {

            String value = queue.poll();

            if (value.equals("null"))
                return null;

            TreeNode node = new TreeNode(Integer.parseInt(value));

            node.left = deserializeHelper(queue);
            node.right = deserializeHelper(queue);

            return node;
        }
    }

    /*
     * 6. Tree Path Maximum K-Sum
     */
    static class TreePathMaximumKSum {

        private int maxLength = 0;

        public int getLongestPath(TreeNode root, int k) {
            dfs(root, 0, k, 0);
            return maxLength;
        }

        private void dfs(TreeNode node,
                int sum,
                int k,
                int length) {

            if (node == null)
                return;

            sum += node.value;
            length++;

            if (sum == k)
                maxLength = Math.max(maxLength, length);

            dfs(node.left, sum, k, length);
            dfs(node.right, sum, k, length);
        }
    }

    /*
     * 7. Boundary Traversal
     */
    static class BoundaryTraversal {

        public void printBoundary(TreeNode root) {

            if (root == null)
                return;

            System.out.print(root.value + " ");

            printLeft(root.left);
            printLeaves(root);
            printRight(root.right);
        }

        private void printLeft(TreeNode node) {

            if (node == null ||
                    (node.left == null &&
                            node.right == null))
                return;

            System.out.print(node.value + " ");

            if (node.left != null)
                printLeft(node.left);
            else
                printLeft(node.right);
        }

        private void printLeaves(TreeNode node) {

            if (node == null)
                return;

            if (node.left == null &&
                    node.right == null) {

                System.out.print(node.value + " ");
                return;
            }

            printLeaves(node.left);
            printLeaves(node.right);
        }

        private void printRight(TreeNode node) {

            if (node == null ||
                    (node.left == null &&
                            node.right == null))
                return;

            if (node.right != null)
                printRight(node.right);
            else
                printRight(node.left);

            System.out.print(node.value + " ");
        }
    }

    /*
     * 8. LCA of a Set
     */
    static class LowestCommonAncestorOfSet {

        public TreeNode findLCA(TreeNode root,
                Set<Integer> set) {

            if (root == null)
                return null;

            if (set.contains(root.value))
                return root;

            TreeNode left = findLCA(root.left, set);
            TreeNode right = findLCA(root.right, set);

            if (left != null && right != null)
                return root;

            return (left != null) ? left : right;
        }
    }

    /*
     * MAIN METHOD
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nChoose Problem (1-8) or 0 to Exit:");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("Program Ended.");
                break;
            }

            switch (choice) {

                case 1:
                    CharTreeNode charRoot = CharTreeBuilder.buildTree(sc);
                    PalindromicPathFinder solver = new PalindromicPathFinder();
                    System.out.println("Total Palindromic Paths: "
                            + solver.countPaths(charRoot));
                    break;

                case 2:
                    TreeNode root2 = IntegerTreeBuilder.buildTree(sc);
                    new VerticalSilhouette().printVertical(root2);
                    break;

                case 3:
                    TreeNode root3 = IntegerTreeBuilder.buildTree(sc);
                    System.out.println("Enter target value:");
                    int target = sc.nextInt();
                    new DistantCousins().findCousins(root3, target);
                    break;

                case 4:
                    TreeNode root4 = IntegerTreeBuilder.buildTree(sc);
                    MinimumCameraCoverage camera = new MinimumCameraCoverage();
                    System.out.println("Minimum Cameras Needed: "
                            + camera.getMinimumCameras(root4));
                    break;

                case 5:
                    TreeNode root5 = IntegerTreeBuilder.buildTree(sc);
                    SerializerDeserializer sd = new SerializerDeserializer();
                    String data = sd.serialize(root5);
                    System.out.println("Serialized: " + data);
                    sd.deserialize(data);
                    System.out.println("Deserialization Successful.");
                    break;

                case 6:
                    TreeNode root6 = IntegerTreeBuilder.buildTree(sc);
                    System.out.println("Enter K value:");
                    int k = sc.nextInt();
                    TreePathMaximumKSum kSolver = new TreePathMaximumKSum();
                    System.out.println("Longest Path Length: "
                            + kSolver.getLongestPath(root6, k));
                    break;

                case 7:
                    TreeNode root7 = IntegerTreeBuilder.buildTree(sc);
                    new BoundaryTraversal().printBoundary(root7);
                    break;

                case 8:
                    TreeNode root8 = IntegerTreeBuilder.buildTree(sc);
                    System.out.println("Enter number of nodes in set:");
                    int m = sc.nextInt();
                    Set<Integer> set = new HashSet<>();
                    System.out.println("Enter values:");
                    for (int i = 0; i < m; i++)
                        set.add(sc.nextInt());
                    TreeNode lca = new LowestCommonAncestorOfSet()
                            .findLCA(root8, set);
                    System.out.println("LCA: "
                            + (lca != null ? lca.value : "Not Found"));
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        }

        sc.close();
    }
}
