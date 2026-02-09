package ProblemStatement4;

public class PairSum {

    public int getPairs(int nums[], int k) {

        int size = nums.length;
        boolean used[] = new boolean[size];
        int pairs = 0;

        for (int i = 0; i < size; i++) {

            if (used[i]) continue;

            for (int j = i + 1; j < size; j++) {

                if (used[j]) continue;

                if (nums[i] + nums[j] == k) {
                    used[i] = true;
                    used[j] = true;
                    pairs++;
                    break;
                }
            }
        }

        return pairs;
    }
}



