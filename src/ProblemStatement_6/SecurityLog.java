package ProblemStatement_6;

public class SecurityLog {
    int[] prefix;

    SecurityLog(int[] data) {
        prefix = new int[data.length];
        prefix[0] = data[0];

        for (int i = 1; i < data.length; i++) {
            prefix[i] = prefix[i - 1] + data[i];
        }
    }

    int getLogins(int i, int j) {
        if (i == 0) {
            return prefix[j];
        }
        return prefix[j] - prefix[i - 1];
    }
}
