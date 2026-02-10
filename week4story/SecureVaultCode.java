package week4story;

import java.util.Scanner;

public class SecureVaultCode{

    /**
     * Generates and prints all permutations of a string.
     *
     * @param str The remaining string whose permutations are to be generated
     * @param ans The accumulated permutation formed so far
     */
    public void findPermutation(String str, String ans) {

        // Base case: if no characters are left
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        // Recursive case: choose each character one by one
        for (int i = 0; i < str.length(); i++) {

            // Current character to be fixed
            char curr = str.charAt(i);

            // Remaining string after removing current character
            String newStr = str.substring(0, i) + str.substring(i + 1);

            // Recursive call with updated values
            findPermutation(newStr, ans + curr);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input : ");
        String str = sc.nextLine();

        SecureVaultCode obj = new SecureVaultCode();
        System.out.println("Output : ");
        
        obj.findPermutation(str, "");
        System.out.println();

        sc.close();
    }
}
