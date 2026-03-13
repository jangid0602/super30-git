
public class QuestionSix {
    public static int getMaxProfit(int[][] ads, int T) {
        int n = ads.length;
        int[][] dp = new int[n + 1][T + 1];
        for (int i = 1; i <= n; i++) {
            int duration = ads[i - 1][0];
            int profit = ads[i - 1][1];

            for (int t = 0; t <= T; t++) {

                dp[i][t] = dp[i - 1][t];

                if (t >= duration) {
                    dp[i][t] = Math.max(dp[i][t],
                            profit + dp[i - 1][t - duration]);
                }

                if (t >= 2 * duration) {
                    dp[i][t] = Math.max(dp[i][t],
                            profit + profit / 2 + dp[i - 1][t - 2 * duration]);
                }
            }
        }

        return dp[n][T];

    }

    public static void main(String[] args) {
        while (true) {
            System.out.print(Message.firstMessage);
            String number = Message.userInput.nextLine();
            if (number.isEmpty()) break;
            int n;
            while (true) {
                try {
                    n = Integer.parseInt(number);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(Message.inValidData);
                }
            }
            System.out.print(Message.videoTime);
            int time;
            while (true) {
                try {
                    time = Integer.parseInt(Message.userInput.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(Message.inValidData);
                }
            }
            int[][] arr = new int[n][2];

            for (int i = 0; i < arr.length; i++) {
                while (true) {
                    System.out.print(Message.adVideoTime);
                    try {
                        arr[i][0] = Integer.parseInt(Message.userInput.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(Message.inValidData);
                    }
                }

                while (true) {
                    System.out.print(Message.adVideoProfit);
                    try {
                        arr[i][1] = Integer.parseInt(Message.userInput.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(Message.inValidData);
                    }
                }

            }
            System.out.println(getMaxProfit(arr, time));
        }
    }
}
