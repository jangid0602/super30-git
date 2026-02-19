package Story5.java;

import java.util.Scanner; /**
 * Problem 2: Vertical Silhouette
 */
public class VerticalSilhouette {

    /**
     * Displays vertical grouping
     */
    public void showVerticalSilhouette() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int totalNodes = scanner.nextInt();

        int[] treeArray = new int[totalNodes];

        System.out.println("Enter node values in level order:");
        for (int index = 0; index < totalNodes; index++) {
            treeArray[index] = scanner.nextInt();
        }

        printVertical(treeArray, 0, 0);
    }

    private void printVertical(int[] treeArray, int currentIndex, int horizontalDistance) {

        if (currentIndex >= treeArray.length) {
            return;
        }

        printVertical(treeArray, currentIndex * 2 + 1, horizontalDistance - 1);

        System.out.println("HD " + horizontalDistance + ": " + treeArray[currentIndex]);

        printVertical(treeArray, currentIndex * 2 + 2, horizontalDistance + 1);
    }
}
