import java.util.Scanner;

public class CountPair{
  static void set(int[] arr,int n){
    int count=0;
    for (int i=0;i<arr.length;i++){
        if (arr[i]==-1)continue;
        for (int j=i+1; j<arr.length;j++ ){
            if(arr[j]==-1)continue;
             if (arr[i]+arr[j]==n) {
                System.out.println("pair"+ arr[i]+"," + arr[j]);
                count++;
                arr[i]=-1;
                arr[j]=-1;
                break;
             }
        }
    }
    if(count==0){
        System.out.println("nothing found");
    }else{
      System.out.println( "total pairs:" + count);
    }
   }
   public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the size: ");
    int size=sc.nextInt();

    System.out.println("enter the element: ");
    int[] arr= new int[size];
    for(int i=0;i<size;i++){
        arr[i] = sc.nextInt();
    } 
    System.out.println("enter the target: ");
    int n = sc.nextInt();

    set(arr,n);
   }
}