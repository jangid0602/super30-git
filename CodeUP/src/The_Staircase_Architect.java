import java.util.Arrays;
import java.util.Scanner;

public class The_Staircase_Architect {
    int[] arr = new int[10000];

    private int stairCase(int value) throws Exception {
        if (value <= 0) {
            throw new Exception("Enter value greater than 0");
        }

        if (arr[value] != -1) {
            return arr[value];
        }
        return stairCase(value - 1) + stairCase(value - 2);
    }

    public static void main(String[] args) {
        The_Staircase_Architect task = new The_Staircase_Architect();
        Scanner userInput = new Scanner(System.in);
        Arrays.fill(task.arr, -1);
        task.arr[1] = 1;
        task.arr[2] = 2;
        task.arr[3] = 3;
        while (true) {
            try {
                System.out.print("\u001B[34mEnter value (-1 exit) :- ");
                int value = Integer.parseInt(userInput.nextLine());
                if (value == -1) break;
                int result = task.arr[value] = task.stairCase(value);
                System.out.println("\u001B[33m"+result);
            } catch (Exception error) {
                System.out.println("\u001B[31mError :- " + error.getMessage());
            }
        }
        System.out.println("\u001B[35mHave Nice day");

    }
}
