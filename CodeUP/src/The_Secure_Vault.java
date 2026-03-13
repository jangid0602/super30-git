import java.util.*;

public class The_Secure_Vault {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }


    private void backtrack(int[] arr, int start, List<List<Integer>> result) {
        if (start == arr.length) {
            List<Integer> temp = new ArrayList<>();
            for (int n : arr) {
                temp.add(n);
            }
            result.add(temp);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            backtrack(arr, start + 1, result);
            swap(arr, start, i); // backtrack
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        The_Secure_Vault task = new The_Secure_Vault();
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your list size (-1 to exit): ");
            int size;

            try {
                size = Integer.parseInt(userInput.nextLine());
                if (size == -1) {
                    System.out.println("Exiting program...");
                    break;
                }

                int[] arr = new int[size];
                System.out.println("Enter " + size + " numbers:");
                for (int i = 0; i < size; i++) {
                    arr[i] = Integer.parseInt(userInput.nextLine());
                }

                List<List<Integer>> permutations = task.permute(arr);
                System.out.println("Permutations:");
                System.out.println(permutations);

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        userInput.close();
    }
}

