package Story5.java;

import java.util.Scanner;

public class Week5MainDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==== WEEK 5 ASSIGNMENTS MENU ====");
        System.out.println("1. Palindromic Path Finder");
        System.out.println("2. Vertical Silhouette");
        System.out.println("3. Distant Cousins");
        System.out.println("5. Serializer & Deserializer");
        System.out.println("7. Boundary Traversal");
        System.out.println("8. LCA of a Set");

        System.out.println("Enter your choice:");
        int userChoice = scanner.nextInt();

        switch (userChoice) {

            case 1:
                new PalindromicPathFinder().findPalindromicPaths();
                break;

            case 2:
                new VerticalSilhouette().showVerticalSilhouette();
                break;

            case 3:
                new DistantCousins().findCousins();
                break;

            case 5:
                new TreeSerializer().performSerialization();
                break;

            case 7:
                TreeNode sampleRoot = new TreeNode(1);
                new BoundaryTraversal().printBoundary(sampleRoot);
                break;

            case 8:
                TreeNode root = new TreeNode(1);
                new LCAOfSet().findLCA(root, 1, 1);
                break;

            default:
                System.out.println("Invalid Choice.");
        }
    }
}
