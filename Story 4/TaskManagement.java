import java.util.ArrayList;
import java.util.Scanner;

public class TaskManagement{
    public static void printTasks(ArrayList<String> tasks, int ind, String space) {
        if (ind >= tasks.size()) {
            return;
        }
        System.out.println(space + tasks.get(ind));
        printTasks(tasks, ind + 1, space + "  ");
    }
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter number of task : ");
        int number = userInput.nextInt();       // number of tasks.
        userInput.nextLine();
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("Main");
        for(int i=0; i<number; i++){
            System.out.print("Enter sub task of "+tasks.get(i)+" : ");
            String task = userInput.nextLine();
            tasks.add(task);
        }
        printTasks(tasks, 0, "");
    }
}
