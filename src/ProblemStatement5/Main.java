package ProblemStatement5;

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

        LongestBalanced lb = new LongestBalanced();
        int ans = lb.getLongest(nums);

        System.out.println("Longest length = " + ans);
    }
}

