import java.util.ArrayList;
import java.util.Scanner;

class Budget{

    public void combinationSum(
            ArrayList<Integer> prices,
            int ind,
            int sum,
            int budget,
            ArrayList<Integer> combination
    ) {
        if (ind >= prices.size() || sum > budget) {
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
        combination.add(prices.get(ind));
        combinationSum(prices, ind, sum + prices.get(ind), budget, combination);
        combination.remove(combination.size() - 1);

        // skip
        combinationSum(prices, ind + 1, sum, budget, combination);
    }

    public void budgetCalculator() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of items : ");
        int size = sc.nextInt();

        ArrayList<Integer> prices = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.print("Enter "+(i+1)+ " item price : ");
            prices.add(sc.nextInt());
        }

        System.out.print("Enter budget: ");
        int budget = sc.nextInt();

        ArrayList<Integer> combination = new ArrayList<>();
        combinationSum(prices, 0, 0, budget, combination);
    }
}

public class BudgetCalculator{
    public static void main(String[] args) {
        Budget calculator = new Budget();
        calculator.budgetCalculator();
    }
}
