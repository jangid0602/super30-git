/*EDIT DISTANCE:

In this there are 2 strings given let a and b and we can perform 3 operations insertion,deletion and replace
on that string to mak=tch string g with b ,and also the cost of each operation is given we have to calculate minimum cost*/
import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of first string");
        int n = sc.nextInt();
        System.out.println("Enter the string");
        String a = sc.next();
        System.out.println("Enter the length of second string");
        int m = sc.nextInt();
        System.out.println("Enter the string");
        String b = sc.next();
        System.out.println("Enter the cost of insertion operation");
        int ci = sc.nextInt();
        System.out.println("Enter the cost of deletion operation");
        int cd = sc.nextInt();
        System.out.println("Enter the cost of replace operation");
        int cr = sc.nextInt();

        //Make a 2d dp array
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Minimum cost is:"+solve(a, b, ci, cd, cr, 0, 0,dp));
    }
    public static int solve(String a,String b,int ci,int cd,int cr,int i,int j,int[][]dp){
        if(i==a.length()){
            return (b.length()-j)*ci;
        }
        if(j==b.length()){
            return (a.length()-i)*cd;
        }
        if(a.charAt(i)==b.charAt(j)){
            return dp[i][j]=solve(a,b,ci,cd,cr,i+1,j+1,dp);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

            //INSERT
            int insert=ci+solve(a,b,ci,cd,cr,i,j+1,dp);
            //DELETE
            int delete=cd+solve(a, b,ci,cd,cr,i+1,j,dp);
            //Replace
            int replace=cr+solve(a,b,ci,cd,cr,i+1,j+1,dp);
            dp[i][j]=Math.min(insert,Math.min(delete,replace));


        return dp[i][j];
    }
}
