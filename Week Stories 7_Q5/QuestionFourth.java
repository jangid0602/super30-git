import java.util.Arrays;

public class QuestionFourth {
    public static int getMaxLength(int n, int k, int[] arr, int preElement, int currElement, int[][] dp) {
        if (n <= currElement) {
            return 0;
        }
        if (dp[preElement + 1][currElement] != -1) return dp[preElement + 1][currElement];
        int combine = 0;
        if (preElement == -1 || Math.abs(arr[preElement] - arr[currElement]) == k) {
            combine = getMaxLength(n, k, arr, currElement, currElement + 1, dp) + 1;
        }
        int notCombine = getMaxLength(n, k, arr, preElement, currElement + 1, dp);
        dp[preElement + 1][currElement] = Math.max(combine, notCombine);
        return dp[preElement + 1][currElement];
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
            System.out.println(getMaxLength(N, K, arr, -1, 0, dp));
        }
        System.out.println(Message.greeting);
    }
}
