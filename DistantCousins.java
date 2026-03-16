package Story5.java;

import java.util.Scanner;

public class DistantCousins {

    public void findCousins() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter total nodes:");
        int totalNodes = scanner.nextInt();

        int[] treeArray = new int[totalNodes];

        System.out.println("Enter tree values in level order:");
        for (int i = 0; i < totalNodes; i++) {
            treeArray[i] = scanner.nextInt();
        }

        System.out.println("Enter value to find cousins:");
        int targetValue = scanner.nextInt();

        int targetIndex = findIndex(treeArray, targetValue);

        if (targetIndex == -1) {
            System.out.println("Node not found.");
            return;
        }

        int parentIndex = (targetIndex - 1) / 2;

        for (int i = 0; i < totalNodes; i++) {
            if ((i - 1) / 2 != parentIndex && getDepth(i) == getDepth(targetIndex)) {
                System.out.println("Cousin: " + treeArray[i]);
            }
        }
    }

    private int findIndex(int[] array, int value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private int getDepth(int index) {

        int depth = 0;

        while (index > 0) {
            index = (index - 1) / 2;
            depth++;
        }

        return depth;
    }
}
