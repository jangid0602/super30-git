package Codeup.Story_2p5;

import java.util.Scanner;

public class Task_8 {
    public int calculateMaxTemp(int arr[]) {
        if (arr.length == 0) return 0;
        int max = arr[0], count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task_8 m = new Task_8();
        System.out.print("Enter size of temperature array: ");
        int n8 = sc.nextInt();
        int[] temp = new int[n8];
        System.out.print("Enter elements: ");
        for (int i2 = 0; i2 < n8; i2++) temp[i2] = sc.nextInt();
        System.out.println(m.calculatemaxTemp(temp));

    }
}
