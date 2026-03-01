import java.util.Scanner;

class Cosmic {

    static int minDeadline(int[] arr) {
        int n = arr.length;

        // Find original maximum
        int originalMax = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > originalMax) {
                originalMax = arr[i];
            }
        }

        int answer = originalMax;

        // Try removing one element
        for (int i = 0; i < n; i++) {
            int currentMax = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                if (j != i) {
                    if (arr[j] > currentMax) {
                        currentMax = arr[j];
                    }
                }
            }

            if (currentMax < answer) {
                answer = currentMax;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of routes: ");
        int n = sc.nextInt();

        int[] routes = new int[n];

        System.out.println("Enter route times:");
        for (int i = 0; i < n; i++) {
            routes[i] = sc.nextInt();
        }

        int result = minDeadline(routes);
        System.out.println("Minimum possible deadline: " + result);
    }
}
