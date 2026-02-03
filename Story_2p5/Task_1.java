package Codeup.Story_2p5;

import java.util.Scanner;

public class Task_1 {
    public static int cosmicCourier(int route[]) {
        if (route.length == 0) 
            return -1;
        if (route.length == 1) 
            return route[0];

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int count = 0;

        for(int time : route){

//            System.out.println(time);

            if(time > max){
                sMax = max;
                max = time;
                count = 1;
            } else if (time == max) {
                count++;
            } else if (time > sMax) {
                sMax = time;
            }
        }

        if (count == 1){
            return sMax;
        }
        return max;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter lenght of array:");
        int n = sc.nextInt();
        int[] num = new int[n];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }
        int result = cosmicCourier(num);
        System.out.println("Minimise deadline is:" + result);
    }
}
