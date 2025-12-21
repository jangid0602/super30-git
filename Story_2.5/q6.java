// Question 6: Security Log Analyzer
// Program to find total logins between given days using prefix sum

class q6 {

    static int findsum(int arr[], int i, int j) {

        int prefix[] = new int[arr.length];

        prefix[0] = arr[0];

        for (int k = 1; k < arr.length; k++) {
            prefix[k] = prefix[k - 1] + arr[k];
        }

        if (i == 0) {
            return prefix[j];
        } else {
            return prefix[j] - prefix[i - 1];
        }
    }

    public static void main(String args[]) {

        int logins[] = {10, 50, 20, 80};

        int start = 1;
        int end = 3;

        int result = findsum(logins, start, end);

        System.out.println("Total logins = " + result);
    }
}
