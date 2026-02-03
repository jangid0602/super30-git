package Codeup.Story_2p5;

import java.util.Arrays;
import java.util.Scanner;

public class Task_3 {
    public static String[] factoryFloor(int arr[]) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 15 == 0) result[i] = "Hazardous";
            else if (arr[i] % 3 == 0) result[i] = "Heavy";
            else if (arr[i] % 5 == 0) result[i] = "Fragile";
            else result[i] = String.valueOf(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter lenght of array:");
        int n = sc.nextInt();
        int [] num = new int[n];
        System.out.println("Enter elements of array:");
        for(int i=0;i< num.length;i++){
            num[i] = sc.nextInt();
        }
        String[] result = factoryFloor(num);
        System.out.println(Arrays.toString(result));
    }
}
