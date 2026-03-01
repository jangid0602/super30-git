import java.util.Scanner;
class Interweaver {

    static String interweave(String s1, String s2) {

        StringBuilder result = new StringBuilder();

        int i = 0, j = 0;

        // Take characters alternately
        while (i < s1.length() && j < s2.length()) {
            result.append(s1.charAt(i));
            result.append(s2.charAt(j));
            i++;
            j++;
        }

        // Append remaining characters of s1
        while (i < s1.length()) {
            result.append(s1.charAt(i));
            i++;
        }

        // Append remaining characters of s2
        while (j < s2.length()) {
            result.append(s2.charAt(j));
            j++;
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first String: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second String: ");
        String s2 = sc.nextLine();

        System.out.println(interweave(s1, s2));
   }
}

