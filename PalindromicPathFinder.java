package Story5.java;
import java.util.Scanner;
/**
 * Basic Tree Node Structure
 * Used by all tree-based problems
 */
class TreeNode {

    int value;
    char character;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int nodeValue) {
        this.value = nodeValue;
        this.leftChild = null;
        this.rightChild = null;
    }

    TreeNode(char nodeCharacter) {
        this.character = nodeCharacter;
        this.leftChild = null;
        this.rightChild = null;
    }

}

public class PalindromicPathFinder {

    private int palindromeCount = 0;

    public void findPalindromicPaths() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int totalNodes = scanner.nextInt();

        char[] nodeValues = new char[totalNodes + 1];

        System.out.println("Enter characters for nodes (1 to N):");
        for (int index = 1; index <= totalNodes; index++) {
            nodeValues[index] = scanner.next().charAt(0);
        }

        // For simplicity, assuming tree is rooted at 1
        int[] frequency = new int[26];

        explorePaths(1, nodeValues, frequency);

        System.out.println("Total Palindromic Paths: " + palindromeCount);
    }

    private void explorePaths(int currentNode, char[] nodeValues, int[] frequency) {

        if (currentNode >= nodeValues.length) {
            return;
        }

        int characterIndex = nodeValues[currentNode] - 'a';
        frequency[characterIndex]++;

        if (isPalindromePossible(frequency)) {
            palindromeCount++;
        }

        explorePaths(currentNode * 2, nodeValues, frequency);
        explorePaths(currentNode * 2 + 1, nodeValues, frequency);

        frequency[characterIndex]--;
    }

    private boolean isPalindromePossible(int[] frequency) {

        int oddCount = 0;

        for (int i = 0; i < 26; i++) {
            if (frequency[i] % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }
}
