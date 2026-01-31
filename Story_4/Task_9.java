package Story_4;

import java.util.*;

public class Task_9 {
    public static void findCombinations(
            int[] prices,
            int index,
            int target,
            List<Integer> current,
            List<List<Integer>> result
    ) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < prices.length; i++) {
            current.add(prices[i]);
            findCombinations(prices, i, target - prices[i], current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter item prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.print("Enter total budget: ");
        int budget = sc.nextInt();

        List<List<Integer>> result = new ArrayList<>();
        findCombinations(prices, 0, budget, new ArrayList<>(), result);

        for (List<Integer> combo : result) {
            System.out.println(combo);
        }
    }
}

