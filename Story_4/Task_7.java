package Story_4;

import java.util.*;

public class Task_7 {

    public static void generateCodes(
            int[] digits,
            boolean[] used,
            List<Integer> current
    ) {

        if (current.size() == digits.length) {
            for (int num : current) {
                System.out.print(num);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(digits[i]);

                generateCodes(digits, used, current);

                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of digits: ");
        int n = sc.nextInt();

        int[] digits = new int[n];
        System.out.println("Enter digits:");
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }

        boolean[] used = new boolean[n];
        generateCodes(digits, used, new ArrayList<>());
    }
}
