package Story_4;

import java.util.*;

public class Task_6 {
    public static void generateTeams(
            String[] devs,
            int index,
            List<String> current,
            List<List<String>> result
    ) {

        result.add(new ArrayList<>(current));

        for (int i = index; i < devs.length; i++) {
            current.add(devs[i]);
            generateTeams(devs, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of developers: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] devs = new String[n];
        System.out.println("Enter developer names:");
        for (int i = 0; i < n; i++) {
            devs[i] = sc.nextLine();
        }

        List<List<String>> result = new ArrayList<>();
        generateTeams(devs, 0, new ArrayList<>(), result);

        for (List<String> team : result) {
            System.out.println(team);
        }
    }
}
