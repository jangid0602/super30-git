import java.util.ArrayList;
import java.util.List;

public class Budget_Calculator {
     List<List<Integer>> totalBudget(int[] arr, int target){
         List<List<Integer>> list = new ArrayList<>();
         List<Integer> sum = new ArrayList<>();
         result(arr,0,sum,list,target);
         return list;
    }
    void result(int[] arr, int i, List<Integer> sum, List<List<Integer>> ans, int target){
        if(i == arr.length || target < 0){
            return;
        }

        if(target == 0){
            ans.add(new ArrayList<>(sum));
            return;
        }

         sum.add(arr[i]);
//         result(arr,i+1,sum,ans,target-arr[i]);
         result(arr,i,sum,ans,target-arr[i]);

         sum.remove(sum.size()-1);
         result(arr,i+1,sum,ans,target);
    }
    public static void main(String[] args) {
        Budget_Calculator task = new Budget_Calculator();
        int[] arr = {2,3,5};
        int target = 8;
        System.out.println(task.totalBudget(arr,target));
    }

}
