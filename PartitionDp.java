import java.util.InputMismatchException;
import java.util.Scanner;

public class PartitionDp {
    public static int solve(int [] arr,int index,int k,int n,int [][]dp) {
        if(index == n && k == 0) return 0;
        if(index == n || k == 0) return Integer.MAX_VALUE;

        if(dp[index][k] != -1) return dp[index][k];

        int max = arr[index];
        int min = arr[index];
        int ans = Integer.MAX_VALUE;

        for(int j=index;j<n;j++){

            max = Math.max(max, arr[j]);
            min = Math.min(min, arr[j]);

            int cost = max - min;

            int next = solve(arr,j+1,k-1,n,dp);

            if(next != Integer.MAX_VALUE)
                ans = Math.min(ans, cost + next);
        }

        return dp[index][k] = ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        System.out.println("Enter the difference");
        int k=sc.nextInt();
        System.out.println("Enter the array");
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int [][]dp=new int[n+1][n];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println("Minimized sum is:"+solve(arr,0,k,n,dp));
    }
}
