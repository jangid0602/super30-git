package ProblemStatement1;

import java.util.*;

public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Size: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Group size: ");
        int k = sc.nextInt();

        Trend t = new Trend();
        int ans = t.getScore(arr, k);

        System.out.println(ans);
    }
}
