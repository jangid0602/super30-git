package Story_4;
import java.util.*;

public class Task_1 {
    public static void findKey(int size){
        if(size == 1){
            System.out.println("Key Found!");
            return;
        }
        System.out.println("Doll (" + size + ")");
        findKey(size-1);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Doll size: ");
        int size = sc.nextInt();

        findKey(size);
    }
}
