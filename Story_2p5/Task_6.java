package Codeup.Story_2p5;

import java.util.Scanner;

public class Task_6 {
    int [] prefixSum;
    public int[] buildPrefixsum(int[] arr) {
        int n = arr.length;
        prefixSum = new int[n];
        if(n>0){
            prefixSum[0] = arr[0];
            for(int i = 1;i< arr.length;i++){
                prefixSum[i] = prefixSum[i-1] + arr[i];
            }
        }
        return prefixSum;
    }

    public int login(int i,int j){
        if(i<0 || j>prefixSum.length)return 0;
        return prefixSum[j] - prefixSum[i-1];
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
        m.buildPrefixsum(log);
        System.out.println(m.login(i, j));
    }
}
