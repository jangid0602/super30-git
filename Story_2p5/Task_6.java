package Codeup.Story_2p5;

import java.util.Scanner;

public class Task_6 {
    public int prefixsum(int arr[], int i, int j) {
        if (i < 0 || j >= arr.length) return 0;
        int sum = 0;
        while (i <= j) sum += arr[i++];
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task_6 m = new Task_6();
        System.out.print("Enter size of login array: ");
        int n6 = sc.nextInt();
        int[] log = new int[n6];
        System.out.print("Enter elements: ");
        for (int i = 0; i < n6; i++) log[i] = sc.nextInt();
        System.out.print("Enter i and j: ");
        int i = sc.nextInt();
        int j = sc.nextInt();
        System.out.println(m.prefixsum(log, i, j));

    }
}
