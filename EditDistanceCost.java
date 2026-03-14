 public class EditDistanceCost {

    public static int minCost(String s1, String s2, int ci, int cd, int cu) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++)
            dp[i][0] = i * cd;

        for(int j=0;j<=m;j++)
            dp[0][j] = j * ci;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){

                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];

                else{
                    dp[i][j]=Math.min(
                        ci + dp[i][j-1],
                        Math.min(cd + dp[i-1][j],
                                 cu + dp[i-1][j-1])
                    );
                }
            }
        }

        return dp[n][m];
    }

   
} 
