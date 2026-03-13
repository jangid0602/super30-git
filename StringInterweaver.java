public class StringInterweaver {
    public String interweave(String s1, String s2) {
        if (s1 == null) return s2;
        if (s2 == null) return s1;

        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = 0;

        // Loop until we reach the end of either string
        while (i < s1.length() && j < s2.length()) {
            result.append(s1.charAt(i++));
            result.append(s2.charAt(j++));
        }

        // Append the remaining characters of s1 (if any)
        if (i < s1.length()) {
            result.append(s1.substring(i));
        }

        // Append the remaining characters of s2 (if any)
        if (j < s2.length()) {
            result.append(s2.substring(j));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        StringInterweaver interweaver = new StringInterweaver();

        // Example Test Case
        String s1 = "ACE";
        String s2 = "BDFGH";

        String result = interweaver.interweave(s1, s2);

        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("Interwoven: " + result);
        // Expected Output: ABCDEFGH
    }
}