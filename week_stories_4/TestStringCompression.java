import java.util.Scanner;

class StringCompression {

    public String compress(String s, int index, int count) {

        if (index == s.length()) {
            return count + "" + s.charAt(index - 1);
        }

        if (index == 0) {
            return compress(s, index + 1, 1);
        }

        if (s.charAt(index) != s.charAt(index - 1)) {
            return count + "" + s.charAt(index - 1)
                + compress(s, index + 1, 1);
        }

        return compress(s, index + 1, count + 1);
    }
}

class TestStringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.next();

        StringCompression obj = new StringCompression();
        String result = obj.compress(input, 0, 0);

        System.out.println(result);
    }
}


