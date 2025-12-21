// Aim: To take an array from the user and find the minimum possible maximum value
// by removing at most one element.

import java.util.Scanner;

public class q1 {

    static int answer(int arr[], int n) {

        // if array has only one element
        if (n == 1) {
            return arr[0];
        }

        int max = arr[0];
        int second = -1;
        int count = 0;

        // finding maximum element
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // counting how many times max appears
        for (int i = 0; i < n; i++) {
            if (arr[i] == max) {
                count++;
            }
        }

        // if max occurs more than once
        if (count > 1) {
            return max;
        }

        // finding second maximum
        for (int i = 0; i < n; i++) {
            if (arr[i] != max) {
                if (second == -1 || arr[i] > second) {
                    second = arr[i];
                }
            }
        }

        return second;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("enter size of array:");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("answer is:");
        System.out.println(answer(arr, n));
    }
}
