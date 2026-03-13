import java.util.Arrays;

public class QuestionFifth {
    public static int minSum(int[] arr, int N, int K) {
        int[][] dp = new int[K + 1][N + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        for (int k = 1; k <= K; k++) {

            for (int i = 1; i <= N; i++) {

                int max = arr[i - 1];
                int min = arr[i - 1];

                for (int j = i; j >= 1; j--) {

                    max = Math.max(max, arr[j - 1]);
                    min = Math.min(min, arr[j - 1]);

                    if (dp[k - 1][j - 1] != Integer.MAX_VALUE) {
                        int cost = max - min;
                        dp[k][i] = Math.min(dp[k][i], (dp[k - 1][j - 1] + cost));
                    }
                }
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) {
        while (true) {
            System.out.print(Message.firstMessage);
            String size = Message.userInput.nextLine();
            if (size.isEmpty()) break;
            int N;
            while (true) {
                try {
                    N = Integer.parseInt(size);
                    break;
                } catch (Exception e) {
                    System.out.println(Message.inValidData);
                }
            }
            System.out.print(Message.kValue);
            int K;
            while (true) {
                try {
                    K = Integer.parseInt(Message.userInput.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println(Message.inValidData);
                }
            }
            System.out.println(Message.listData);
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                while (true) {
                    System.out.print(Message.inputValue(i));
                    try {
                        arr[i] = Integer.parseInt(Message.userInput.nextLine());
                        break;
                    } catch (Exception e) {
                        System.out.println(Message.inValidData);
                    }
                }
            }
            int[][] dp = new int[N + 1][N];
            for (int[] ints : dp) {
                Arrays.fill(ints, -1);
            }
            System.out.println(minSum(arr,N,K));
        }
        System.out.println(Message.greeting);
    }
}
