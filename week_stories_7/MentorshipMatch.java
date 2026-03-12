import java.util.*;

public class MentorshipMatch {

    public int findMaxScore(int[][] score, int mentor, int bits, int[][] dp) {
        int n = score.length;

        if (mentor == n) {
            return 0;
        }

        if (dp[mentor][bits] != -1) {
            return dp[mentor][bits];
        }

        int maxScore = 0;

        for (int student = 0; student < n; student++) {

            // check if student already assigned
            if (((bits >> student) & 1) == 0) {

                bits ^= (1 << student);

                maxScore = Math.max(
                        maxScore,
                        findMaxScore(score, mentor + 1, bits, dp) + score[mentor][student]
                );

                bits ^= (1 << student); // backtrack
            }
        }

        return dp[mentor][bits] = maxScore;
    }

    public int mentorshipMatch() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of mentor and student: ");
        int n = sc.nextInt();

        int[][] score = new int[n][n];

        System.out.println("Enter score of every student with each mentor:");

        for (int mentor = 0; mentor < n; mentor++) {
            for (int student = 0; student < n; student++) {
                score[mentor][student] = sc.nextInt();
            }
        }

        int bits = 0;

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            maxi <<= 1;
            maxi |= 1;
        }

        int[][] dp = new int[n][maxi + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return findMaxScore(score, 0, bits, dp);
    }

    public static void main(String[] args) {

        MentorshipMatch obj = new MentorshipMatch();
        System.out.println(obj.mentorshipMatch());
    }
}
