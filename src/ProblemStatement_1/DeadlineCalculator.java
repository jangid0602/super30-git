package ProblemStatement_1;

public class DeadlineCalculator {

    public static int minimumDeadline(int[] arr) {

        if (arr.length == 1) {
            return arr[0];
        }

        int max = arr[0];
        int secondMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }

        if (secondMax == max) {
            return max;
        }

        return secondMax;
    }
}
