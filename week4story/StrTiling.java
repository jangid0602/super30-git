package week4story;

import java.util.Scanner;

public class StrTiling {

    /**
     * Compresses the given string recursively by
     * printing the count followed by the character.
     *
     * Example:
     * Input  : aaabbc
     * Output : 3a2b1c
     *
     * @param str   The input string to be compressed
     * @param i     The current index being processed
     * @param count The count of consecutive characters
     */
    public void compressString(String str, int i, int count) {

        // Base case: last character of the string
        if (i == str.length() - 1) {
            System.out.println(count + "" + str.charAt(i));
            return;
        }

        // If current character is same as next character
        if (str.charAt(i) == str.charAt(i + 1)) {
            // Increase count and move to next index
            compressString(str, i + 1, count + 1);
        } else {
            // Print count and character when sequence breaks
            System.out.print(count + "" + str.charAt(i));
            // Reset count and move to next character
            compressString(str, i + 1, 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sc.nextLine();

        StrTiling obj = new StrTiling();
        
        int i = 0;
        int count = 1;
        obj.compressString(str, i, count);

        sc.close();
    }
}
