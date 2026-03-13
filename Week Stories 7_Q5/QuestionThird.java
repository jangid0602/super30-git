import java.util.Scanner;

public class QuestionThird {
    public static int getMin(String s1, String s2, int ci, int cd, int cu) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0) {
                    dp[i][j] = j * ci;
                }
                if (j == 0) {
                    dp[i][j] = i * cd;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = dp[i][j - 1] + ci;
                    int del = dp[i - 1][j] + cd;
                    int rep = dp[i - 1][j - 1] + cu;
                    dp[i][j] = Math.min(add, Math.min(del, rep));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        while (true) {
            System.out.print(Message.inputDataWord1);
            String str1 = Message.userInput.nextLine();
            if (str1.isEmpty()) break;
            System.out.print(Message.inputDataWord2);
            String str2 = Message.userInput.nextLine();

            int[] costs = new int[3];
            for (int i = 0; i < costs.length; i++) {
                System.out.print(i == 0 ? Message.insertCost : i == 1 ? Message.deleteCost : Message.upgradeCost);
                try {
                    costs[i] = Integer.parseInt(Message.userInput.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println(Message.inValidData);
                }
            }
            System.out.println(getMin(str1, str2, costs[0], costs[1], costs[2]));
            System.out.println(Message.greeting);
        }

    }
}

