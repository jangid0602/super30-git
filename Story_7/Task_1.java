package Story_7;
import java.util.*;

public class Task_1 {
    public static int maxRevenue(int[] A) {
        int n = A.length;

        int prev2 = 0;
        int prev1 = 0;

        for (int i = 0; i < n; i++) {

            int val;
            if ((i + 1) % 7 == 0) {
                val = 2 * A[i];
            } else {
                val = A[i];
            }

            int curr = Math.max(prev1, prev2 + val);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] A = new int[n];
        System.out.println("Enter revenue values:");

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int result = maxRevenue(A);
        System.out.println("Maximum Revenue: " + result);

        sc.close();
    }
}
