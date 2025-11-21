package ProblemStatement2;

public class Scramble {

    public boolean check(String big, String small) {

        int n = big.length();
        int m = small.length();

        if (m > n) return false;

        int need[] = new int[26];
        for (int i = 0; i < m; i++) {
            char ch = small.charAt(i);
            need[ch - 'a']++;
        }

        for (int i = 0; i + m <= n; i++) {

            int have[] = new int[26];

            for (int j = i; j < i + m; j++) {
                char ch = big.charAt(j);
                have[ch - 'a']++;
            }

            boolean same = true;
            for (int k = 0; k < 26; k++) {
                if (have[k] != need[k]) {
                    same = false;
                    break;
                }
            }

            if (same) return true;
        }

        return false;
    }
}
