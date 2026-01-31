package Story_4;

import java.util.*;

public class Task_8 {
    public static String compress(String s) {

        if (s.length() == 0) {
            return "";
        }

        char ch = s.charAt(0);
        int count = 1;
        int i = 1;

        while (i < s.length() && s.charAt(i) == ch) {
            count++;
            i++;
        }

        return count + "" + ch + compress(s.substring(i));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = sc.nextLine();

        System.out.println(compress(input));
    }
}
