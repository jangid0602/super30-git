public class QuestionFirst {
    static int solve(int[] arr, int index, int n, int[] dp) {
        if (index >= n) return 0;
        if (dp[index] != -1) {
            return dp[index];
        }
        int skip = solve(arr, index + 1, n, dp);
        int mul = 1;
        if ((index + 1) % 7 == 0) mul = 2;
        int take = solve(arr, index + 2, n, dp) + arr[index] * mul;
        return dp[index] = Math.max(take, skip);
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
            System.out.println(Message.listData);
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                while(true) {
                    System.out.print(Message.inputValue(i));
                    try {
                        arr[i] = Integer.parseInt(Message.userInput.nextLine());
                        break;
                    } catch (Exception e) {
                        System.out.println(Message.inValidData);
                    }
                }
            }

            int[] dp = new int[N];
            for (int i = 0; i < N; i++) {
                dp[i] = -1;
            }
            System.out.println(solve(arr, 0, N, dp));

        }
        System.out.println(Message.greeting);
    }
}