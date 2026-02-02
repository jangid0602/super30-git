import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    String name;
    List<Task> subTasks = new ArrayList<>();

    Task(String name) {
        this.name = name;
    }
}

public class ProjectBuilder {

    static Scanner userInput = new Scanner(System.in);

    static Task buildTask(int level) {
        System.out.print("Enter task name: ");
        String name = userInput.nextLine();

        Task task = new Task(name);

        System.out.print("Enter number of sub-tasks for \"" + name + "\": ");
        int count = Integer.parseInt(userInput.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("Sub-task " + (i + 1) + " of \"" + name + "\":");
            task.subTasks.add(buildTask(level + 1));
        }

        return task;
    }

    static void printTasks(Task task, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(task.name);

        for (Task sub : task.subTasks) {
            printTasks(sub, level + 1);
        }
    }

    public static void main(String[] args) {
        while(true) {
            System.out.print("for exit (0) :- ");
            try {
                if (0 == Integer.parseInt(userInput.nextLine())) break;
                System.out.println("Build your project tasks:");
                Task root = buildTask(0);

                System.out.println("\nTask Hierarchy:");
                printTasks(root, 0);

            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }
}
