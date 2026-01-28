import java.util.Scanner;

public class CStringInterweaverJava {

    public char[] interweave(char[] s1, char[] s2) {
        int len1 = s1.length;
        int len2 = s2.length;

        char[] result = new char[len1 + len2];

        int i = 0, j = 0, k = 0;

        while (i < len1 && j < len2) {
            result[k++] = s1[i++];
            result[k++] = s2[j++];
        }

        while (i < len1) {
            result[k++] = s1[i++];
        }

        while (j < len2) {
            result[k++] = s2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        CStringInterweaverJava task = new CStringInterweaverJava();
        Scanner userInput = new Scanner(System.in);

        try {
            System.out.print("Enter first string: ");
            String str1 = userInput.next();

            System.out.print("Enter second string: ");
            String str2 = userInput.next();

            // Convert to char arrays
            char[] s1 = str1.toCharArray();
            char[] s2 = str2.toCharArray();

            char[] result = task.interweave(s1, s2);

            System.out.print("Interwoven String: ");
            for (char c : result) {
                System.out.print(c);
            }
            System.out.println();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
