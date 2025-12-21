//Aim of Question 3 is to read numbers from the user and display output based on given conditions using loops and if-else statements.
import java.util.Scanner;

public class q3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("enter size of array: ");
        int n = sc.nextInt();

        int w[] = new int[n];

        System.out.println("enter elements:");
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }

        System.out.println("result:");

        for (int i = 0; i < n; i++) {

            if (w[i] % 15 == 0) {
                System.out.println("Hazardous");
            }
            else if (w[i] % 3 == 0) {
                System.out.println("Heavy");
            }
            else if (w[i] % 5 == 0) {
                System.out.println("Fragile");
            }
            else {
                System.out.println(w[i]);
            }
        }
    }
}
