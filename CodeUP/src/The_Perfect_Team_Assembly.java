import java.util.*;

public class The_Perfect_Team_Assembly {

    private List<List<String>> subSet(String[] input) {
        List<List<String>> result = new ArrayList<>();
        genSubSet(input, 0, new ArrayList<>(), result);
        return result;
    }

    private void genSubSet(String[] input, int i,
                           List<String> current,
                           List<List<String>> result) {

        if (i == input.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // include
        current.add(input[i]);
        genSubSet(input, i + 1, current, result);

        // exclude
        current.remove(current.size() - 1);
        genSubSet(input, i + 1, current, result);
    }

    public static void main(String[] args) {
        The_Perfect_Team_Assembly task = new The_Perfect_Team_Assembly();
        String[] arr = {"DevA", "DevB"};
        System.out.println(task.subSet(arr));
    }
}
