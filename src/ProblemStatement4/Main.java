package ProblemStatement4;

import java.util.*;

public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();

        int nums[] = new int[size];

        System.out.println("Enter nums:");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter k:");
        int k = sc.nextInt();

        PairSum p = new PairSum();
        int ans = p.getPairs(nums, k);

        System.out.println("Total pairs = " + ans);
    }
}
