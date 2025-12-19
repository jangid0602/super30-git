import java.util.Scanner;

class FactoryFloor {

    // Method to label items
    static void labelItems(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] % 15 == 0) {
                System.out.print("Hazardous ");
            }
            else if (arr[i] % 3 == 0) {
                System.out.print("Heavy ");
            }
            else if (arr[i] % 5 == 0) {
                System.out.print("Fragile ");
            }
            else {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weights = new int[n];

        System.out.println("Enter item weights:");
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.println("Output:");
        labelItems(weights);
    }
}
