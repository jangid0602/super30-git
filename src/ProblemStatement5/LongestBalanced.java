package ProblemStatement5;

public class LongestBalanced {

    public int getLongest(int nums[]) {

        int size = nums.length;
        int best = 0;

        for (int i = 0; i < size; i++) {

            int c1 = 0;   // count of 1
            int c2 = 0;   // count of 2

            for (int j = i; j < size; j++) {

                if (nums[j] == 1) {
                    c1++;
                } else if (nums[j] == 2) {
                    c2++;
                }

                if (c1 == c2) {
                    int len = j - i + 1;
                    if (len > best) {
                        best = len;
                    }
                }
            }
        }

        return best;
    }
}
