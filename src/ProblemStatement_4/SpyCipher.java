package ProblemStatement_4;

public class SpyCipher {
    static char findExtra(String a, String b) {

        int[] freq = new int[256];

        for (int i = 0; i < a.length(); i++) {
            freq[a.charAt(i)]++;
        }

        for (int i = 0; i < b.length(); i++) {
            freq[b.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (freq[i] < 0) {
                return (char) i;
            }
        }

        return ' ';
    }
}
