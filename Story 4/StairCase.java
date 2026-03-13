import java.util.Scanner;
public class StairCase{
    public static int climibingMethod(int stair){
        if(stair == 1 || stair == 2) return stair;
        return climibingMethod(stair-1) + climibingMethod(stair-2);
    }
    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a number of stair : ");
        int stair = userInput.nextInt();
        int method = climibingMethod(stair);
        System.out.print("There are " + method + " way to reach at the top.");
    }
}