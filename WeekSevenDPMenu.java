package Story7;

import java.util.Scanner;

class WeekSevenDPMenu {

    /*
       1. Startup Revenue Maxima
      */
    public static int calculateMaximumRevenue(int totalDays, int[] revenueArray) {

        int[] dp = new int[totalDays + 2];

        for (int day = totalDays - 1; day >= 0; day--) {

            int todayRevenue = revenueArray[day];

            if ((day + 1) % 7 == 0) {
                todayRevenue = todayRevenue * 2;
            }

            int workToday = todayRevenue + dp[day + 2];
            int restToday = dp[day + 1];

            dp[day] = workToday > restToday ? workToday : restToday;
        }

        return dp[0];
    }

    /*
       2. Circular Office Security
       */
    public static int linearCabinCalculation(int[] cabinValues, int start, int end) {

        int previousValue = 0;
        int currentValue = 0;

        for (int index = start; index <= end; index++) {

            int takeCabin = previousValue + cabinValues[index];
            int skipCabin = currentValue;

            previousValue = currentValue;
            currentValue = takeCabin > skipCabin ? takeCabin : skipCabin;
        }

        return currentValue;
    }

    /*
       3. Palindromic Deployment
       */
    public static int findMinimumInsertions(String text) {

        int length = text.length();
        int[][] dp = new int[length][length];

        for (int gap = 1; gap < length; gap++) {

            for (int left = 0; left + gap < length; left++) {

                int right = left + gap;

                if (text.charAt(left) == text.charAt(right)) {
                    dp[left][right] = dp[left + 1][right - 1];
                }
                else {

                    int leftInsert = dp[left + 1][right];
                    int rightInsert = dp[left][right - 1];

                    dp[left][right] = leftInsert < rightInsert ?
                            leftInsert + 1 : rightInsert + 1;
                }
            }
        }

        return dp[0][length - 1];
    }

    /*
       4. Placement Marathon
      */
    public static int longestSubsequence(int[] skillArray, int size, int difference) {

        int[] dp = new int[size];
        int maximumLength = 1;

        for (int i = 0; i < size; i++) {

            dp[i] = 1;

            for (int j = 0; j < i; j++) {

                if (skillArray[i] - skillArray[j] == difference) {

                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }

            if (dp[i] > maximumLength) {
                maximumLength = dp[i];
            }
        }

        return maximumLength;
    }

    /*
       5. Jaipur Tech-Hub Routes
       */
    public static boolean checkPrime(int number) {

        if (number < 2) return false;

        for (int i = 2; i * i <= number; i++) {

            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int digitSum(int number) {

        int sum = 0;

        while (number > 0) {

            sum = sum + number % 10;
            number = number / 10;
        }

        return sum;
    }

    public static int countPrimeDigitNumbers(int left, int right) {

        int count = 0;

        for (int num = left; num <= right; num++) {

            int sum = digitSum(num);

            if (checkPrime(sum)) {
                count++;
            }
        }

        return count;
    }

    /*
       MAIN MENU
       */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== WEEK 7 DP MENU =====");
            System.out.println("1. Startup Revenue Maxima");
            System.out.println("2. Circular Office Security");
            System.out.println("3. Palindromic Deployment");
            System.out.println("4. Placement Marathon");
            System.out.println("5. Jaipur Tech-Hub Routes");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 6) {
                System.out.println("Program Ended.");
                break;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter number of days: ");
                    int days = scanner.nextInt();

                    int[] revenueArray = new int[days];

                    System.out.println("Enter daily revenues:");

                    for (int i = 0; i < days; i++) {
                        revenueArray[i] = scanner.nextInt();
                    }

                    int revenueResult = calculateMaximumRevenue(days, revenueArray);

                    System.out.println("Maximum Revenue: " + revenueResult);
                    break;


                case 2:

                    System.out.print("Enter number of cabins: ");
                    int cabins = scanner.nextInt();

                    int[] cabinValues = new int[cabins];

                    System.out.println("Enter cabin values:");

                    for (int i = 0; i < cabins; i++) {
                        cabinValues[i] = scanner.nextInt();
                    }

                    int caseOne = linearCabinCalculation(cabinValues, 0, cabins - 2);
                    int caseTwo = linearCabinCalculation(cabinValues, 1, cabins - 1);

                    int result = caseOne > caseTwo ? caseOne : caseTwo;

                    System.out.println("Maximum Value Audited: " + result);
                    break;


                case 3:

                    System.out.print("Enter string: ");
                    String text = scanner.next();

                    int insertionResult = findMinimumInsertions(text);

                    System.out.println("Minimum Insertions Needed: " + insertionResult);
                    break;


                case 4:

                    System.out.print("Enter number of students: ");
                    int size = scanner.nextInt();

                    int[] skillArray = new int[size];

                    System.out.println("Enter skill values:");

                    for (int i = 0; i < size; i++) {
                        skillArray[i] = scanner.nextInt();
                    }

                    System.out.print("Enter difference K: ");
                    int difference = scanner.nextInt();

                    int longest = longestSubsequence(skillArray, size, difference);

                    System.out.println("Longest Subsequence Length: " + longest);
                    break;


                case 5:

                    System.out.print("Enter L: ");
                    int left = scanner.nextInt();

                    System.out.print("Enter R: ");
                    int right = scanner.nextInt();

                    int count = countPrimeDigitNumbers(left, right);

                    System.out.println("Numbers with Prime Digit Sum: " + count);
                    break;


                default:
                    System.out.println("Invalid Choice!");
            }
        }

        scanner.close();
    }
}
