import java.util.InputMismatchException;
import java.util.Scanner;

public class PlacementMarathon {
    public static int solve(int [] arr,int n,int prev,int curr,int k,int [][]dp){
        if(curr>=n) return 0;
        if(dp[prev+1][curr]!=-1){
            return dp[prev+1][curr];
        }
        int take=0;
        if(prev==-1 || Math.abs(arr[prev]-arr[curr])==k){
            take=solve(arr,n,curr,curr+1,k,dp)+1;
        }
        int skip=solve(arr,n,prev,curr+1,k,dp);
        dp[prev+1][curr]=Math.max(take,skip);
        return dp[prev+1][curr];
    }
    public static void main(String[] args) {
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
        System.out.println(solve(arr,n,-1,0,k,dp));
    }
    }
