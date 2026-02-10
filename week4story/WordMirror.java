package week4story;

import java.util.Scanner;

public class WordMirror {

    /**
     * Recursively checks if the given string is a palindrome.
     *
     * @param str   The input string to be checked
     * @param right The starting index from the left side
     * @param left  The starting index from the right side
     * @return true if the string is a palindrome, false otherwise
     */
    public boolean checkPalindrome(String str, int right, int left) {

        // Base case: all characters have been checked
        if (right >= left) {
            return true;
        }

        // If characters at current positions do not match
        if (str.charAt(right) != str.charAt(left)) {
            return false;
        }

        // Recursive call: move towards the center
        return checkPalindrome(str, right + 1, left - 1);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sc.nextLine();

        int right = 0;
        int left = str.length() - 1;
        WordMirror obj = new WordMirror();

        System.out.println(obj.checkPalindrome(str, right, left));
        
        sc.close();
    }
}
