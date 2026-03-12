import java.util.Scanner;

class WordMirror {

    public boolean isPalindrome(String input, int s, int e) {
        if (s >= e)
            return true;

        if (input.charAt(s) != input.charAt(e))
            return false;

        return isPalindrome(input, s + 1, e - 1);
    }

    public boolean wordMirror() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.next();

        return isPalindrome(input, 0, input.length() - 1);
    }
}

class TestWordMirror {
    public static void main(String[] args) {
        WordMirror word = new WordMirror();

        if (word.wordMirror())
            System.out.println("String is palindrome");
        else
            System.out.println("String is not palindrome");
    }
}
