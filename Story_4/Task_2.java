package Story_4;
import java.util.*;

public class Task_2 {
    public static int ways(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return ways(n - 1) + ways(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        System.out.println(ways(n));
    }
}
