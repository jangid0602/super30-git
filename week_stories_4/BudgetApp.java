import java.util.ArrayList;
import java.util.Scanner;

class BudgetCalculator {

    public void combinationSum(
            ArrayList<Integer> prices,
            int i,
            int sum,
            int budget,
            ArrayList<Integer> combination
    ) {
        if (i >= prices.size() || sum > budget) {
            return;
        }

        if (sum == budget) {
            System.out.print("[");
            for (int idx = 0; idx < combination.size(); idx++) {
                if (idx == combination.size() - 1)
                    System.out.print(combination.get(idx));
                else
                    System.out.print(combination.get(idx) + ", ");
            }
            System.out.println("]");
            return;
        }

        // take
        combination.add(prices.get(i));
        combinationSum(prices, i, sum + prices.get(i), budget, combination);
        combination.remove(combination.size() - 1);

        // skip
        combinationSum(prices, i + 1, sum, budget, combination);
    }

    public void budgetCalculator() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of prices: ");
        int size = sc.nextInt();

        ArrayList<Integer> prices = new ArrayList<>();
        System.out.println("Enter prices:");
        for (int i = 0; i < size; i++) {
            prices.add(sc.nextInt());
        }

        System.out.print("Enter budget: ");
        int budget = sc.nextInt();

        ArrayList<Integer> combination = new ArrayList<>();
        combinationSum(prices, 0, 0, budget, combination);
    }
}

public class BudgetApp {
    public static void main(String[] args) {
        BudgetCalculator calculator = new BudgetCalculator();
        calculator.budgetCalculator();
    }
}

