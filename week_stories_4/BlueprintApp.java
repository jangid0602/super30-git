import java.util.ArrayList;
import java.util.Scanner;

class BuildersBlueprint {

    public ArrayList<String> inputTasks() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();
        sc.nextLine(); // buffer clear

        ArrayList<String> tasks = new ArrayList<>();

        System.out.print("Enter parent task: ");
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print("Enter subtask of " + tasks.get(i - 1) + ": ");
            }
            String task = sc.nextLine();
            tasks.add(task);
        }
        return tasks;
    }

    public void printTasks(ArrayList<String> tasks, int i) {
        if (i >= tasks.size()) {
            return;
        }
        System.out.println(tasks.get(i));
        printTasks(tasks, i + 1);
    }

    public void builderBlueprint() {
        ArrayList<String> tasks = inputTasks();
        printTasks(tasks, 0);
    }
}

public class BlueprintApp {
    public static void main(String[] args) {
        BuildersBlueprint blueprint = new BuildersBlueprint();
        blueprint.builderBlueprint();
    }
}

