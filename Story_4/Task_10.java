package Story_4;

import java.util.*;

class Task {
    String name;
    Task subTask;

    Task(String name) {
        this.name = name;
        this.subTask = null;
    }
}

public class Task_10 {

    public static Task buildTask(Scanner sc, String taskName) {
        Task task = new Task(taskName);

        System.out.print("\nEnter sub-task name (or type 'done'): ");
        String next = sc.nextLine();

        if (!next.equalsIgnoreCase("done")) {
            task.subTask = buildTask(sc, next);
        }

        return task;
    }


    public static void printTasks(Task task, int level) {
        System.out.println(task.name);

        if (task.subTask != null) {
            printTasks(task.subTask, level + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter task name: ");
        String rootName = sc.nextLine();

        Task root = buildTask(sc, rootName);

        printTasks(root, 0);
    }
}
