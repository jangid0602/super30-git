//The Cosmic Courier Challenge


public class Week4_Task1 {

    public static int minimumDeadline(int[] routes) {

        if (routes.length <= 1) {
            return 0; 
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        
        for (int time : routes) {
            if (time > max) {
                secondMax = max;
                max = time;
            } else if (time > secondMax) {
                secondMax = time;
            }
        }

        
        return secondMax;
    }

    public static void main(String[] args) {

        int[] routes1 = {10, 5, 8, 12, 6};
        int[] routes2 = {3, 3, 3, 3};
        int[] routes3 = {1, 100, 2};

        System.out.println(minimumDeadline(routes1)); 
        System.out.println(minimumDeadline(routes2)); 
        System.out.println(minimumDeadline(routes3)); 
    }
}