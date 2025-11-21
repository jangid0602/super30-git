package ProblemStatement1;

public class Trend {

    public int getScore(int arr[], int k) {
        int n = arr.length;
        int score = 0;

        for (int i = 0; i + k <= n; i++) {

            int val[] = new int[k];
            int freq[] = new int[k];
            int used = 0;

            for (int j = i; j < i + k; j++) {
                int x = arr[j];

                int pos = -1;
                for (int a = 0; a < used; a++) {
                    if (val[a] == x) {
                        pos = a;
                        break;
                    }
                }

                if (pos == -1) {
                    val[used] = x;
                    freq[used] = 1;
                    used++;
                } else {
                    freq[pos]++;
                }
            }

            int max = 0;
            for (int j = 0; j < used; j++) {
                if (freq[j] > max) {
                    max = freq[j];
                }
            }

            int c = 0;
            for (int j = 0; j < used; j++) {
                if (freq[j] == max) {
                    c++;
                }
            }

            if (c == 1) {
                score++;
            }
        }

        return score;
    }
}
