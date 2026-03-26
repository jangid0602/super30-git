import java.util.Scanner;
public class RussianDoll{
    public static boolean doll(int size){
        if(size == 1) return true;
        else if(size < 1) return false;
        return doll(size-1);
    }
    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter size : ");
        int size = userInput.nextInt();
        boolean flag = doll(size);
        if(flag) System.out.print("Key found!");
        else System.out.print("Key not found!");
    }
}