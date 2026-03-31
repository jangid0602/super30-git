import java.util.Scanner; // Import Scanner class for user input

// 1. Russian Doll Mystery

class RussianDoll {

    Scanner sc = new Scanner(System.in); // Scanner for input

    // Function to start the logic
    void run() {
        System.out.print("Enter Doll Size: ");
        int n = sc.nextInt();
        findKey(n); // Call recursive function
    }

    // Recursive function to find the key
    void findKey(int n) {
        if (n == 1) { // Base case: smallest doll
            System.out.println("Key Found!");
            return;
        }
        findKey(n - 1); // Recursive call for next smaller doll
    }
}

// 2. Staircase Architect

class Staircase {

    Scanner sc = new Scanner(System.in); // Scanner object
    int count = 0; // Variable to store total ways

    // Function to take input and start recursion
    void run() {
        System.out.print("Enter number of steps: ");
        int n = sc.nextInt();

        System.out.println("Possible ways:");
        printWays(n, ""); // Call recursive function

        System.out.println("Total Ways = " + count); // Print total count
    }

    // Recursive function to print all combinations
    void printWays(int n, String path) {
        if (n == 0) { // Base case: reached exact step
            System.out.println(path.trim()); // Print one valid path
            count++; // Increase total count
            return;
        }

        if (n < 0) return; // Invalid path, so stop

        printWays(n - 1, path + "1 "); // Choose 1 step
        printWays(n - 2, path + "2 "); // Choose 2 steps
    }
}

// 3. Digital Ancestry Tree

class AncestryTree {

    Scanner sc = new Scanner(System.in);

    // Function to take wealth input
    void run() {
        System.out.print("Enter number of family members: ");
        int n = sc.nextInt();

        int[] arr = new int[n]; // Array to store wealth

        for (int i = 0; i < n; i++) {
            System.out.print("Enter wealth of member " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Total Legacy = " + sum(arr, 0)); // Call recursive sum
    }

    // Recursive function to calculate sum
    int sum(int[] arr, int i) {
        if (i == arr.length) return 0; // Base case: end of array
        return arr[i] + sum(arr, i + 1); // Add current + recursive sum
    }
}

// 4. Word Mirror

class WordMirror {

    Scanner sc = new Scanner(System.in);

    // Function to take word input
    void run() {
        System.out.print("Enter word: ");
        String s = sc.next();
        System.out.println("Output: " + isPalindrome(s, 0, s.length() - 1));
    }

    // Recursive function to check palindrome
    boolean isPalindrome(String s, int l, int r) {
        if (l >= r) return true; // Base case: middle reached
        if (s.charAt(l) != s.charAt(r)) return false; // Mismatch found
        return isPalindrome(s, l + 1, r - 1); // Recursive inward check
    }
}

// 5. Maze Runner

class MazeRunner {

    Scanner sc = new Scanner(System.in);

    // Function to take maze input
    void run() {
        System.out.print("Enter N (Maze size): ");
        int n = sc.nextInt();

        int[][] maze = new int[n][n]; // Matrix for maze

        System.out.println("Enter Maze Matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                maze[i][j] = sc.nextInt();

        System.out.println("Path Exists = " + solveMaze(maze, 0, 0, n));
    }

    // Recursive function to check path
    boolean solveMaze(int[][] maze, int i, int j, int n) {
        if (i == n - 1 && j == n - 1) return true; // Destination reached
        if (i >= n || j >= n || maze[i][j] == 0) return false; // Invalid cell

        return solveMaze(maze, i + 1, j, n) || solveMaze(maze, i, j + 1, n); // Down or Right
    }
}

// 6. Perfect Team Assembly

class TeamAssembly {

    Scanner sc = new Scanner(System.in);

    // Function to take developer input
    void run() {
        System.out.print("Enter number of developers: ");
        int n = sc.nextInt();

        String[] arr = new String[n]; // Store developer names

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Developer " + (i + 1) + ": ");
            arr[i] = sc.next();
        }

        printSubsets(arr, "", 0); // Call recursion
    }

    // Recursive function to print all subsets
    void printSubsets(String[] arr, String curr, int i) {
        if (i == arr.length) { // Base case: all elements processed
            System.out.println("[" + curr.trim() + "]");
            return;
        }

        printSubsets(arr, curr, i + 1); // Exclude current element
        printSubsets(arr, curr + arr[i] + " ", i + 1); // Include current element
    }
}

//  7. Secure Vault Code

class VaultCode {

    Scanner sc = new Scanner(System.in);

    // Function to take digits input
    void run() {
        System.out.print("Enter number of digits: ");
        int n = sc.nextInt();

        int[] arr = new int[n]; // Store digits

        for (int i = 0; i < n; i++) {
            System.out.print("Enter digit " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        permute(arr, 0); // Call permutation logic
    }

    // Recursive function for permutations
    void permute(int[] arr, int i) {
        if (i == arr.length) { // Base case: one permutation formed
            for (int x : arr) System.out.print(x);
            System.out.println();
            return;
        }

        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j); // Swap values
            permute(arr, i + 1); // Recursive call
            swap(arr, i, j); // Backtrack
        }
    }

    // Function to swap two values
    void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

// 8. String Tiling

class StringTiling {

    Scanner sc = new Scanner(System.in);

    // Function to take string input
    void run() {
        System.out.print("Enter string: ");
        String s = sc.next();
        compress(s, 0, 1); // Call compression function
        System.out.println();
    }

    // Recursive function to compress string
    void compress(String s, int i, int count) {
        if (i == s.length() - 1) { // Last character reached
            System.out.print(count + "" + s.charAt(i));
            return;
        }

        if (s.charAt(i) == s.charAt(i + 1))
            compress(s, i + 1, count + 1); // Increase count
        else {
            System.out.print(count + "" + s.charAt(i)); // Print result
            compress(s, i + 1, 1); // Reset count
        }
    }
}

// 9. Budget Calculator

class BudgetCalculator {

    Scanner sc = new Scanner(System.in);

    // Function to take price and budget input
    void run() {
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] arr = new int[n]; // Store prices

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter Budget: ");
        int budget = sc.nextInt();

        findSum(arr, 0, budget, ""); // Call recursive function
    }

    // Recursive function to find combinations
    void findSum(int[] arr, int i, int sum, String res) {
        if (sum == 0) { // Budget matched
            System.out.println("[" + res.trim() + "]");
            return;
        }

        if (i == arr.length || sum < 0) return; // Invalid case

        findSum(arr, i, sum - arr[i], res + arr[i] + " "); // Include item
        findSum(arr, i + 1, sum, res); // Exclude item
    }
}

// 10. Project Builder

class ProjectBuilder {

    Scanner sc = new Scanner(System.in);

    // Function to take task input
    void run() {
        System.out.print("Enter number of task levels: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] tasks = new String[n]; // Store tasks

        for (int i = 0; i < n; i++) {
            System.out.print("Enter task " + (i + 1) + ": ");
            tasks[i] = sc.nextLine();
        }

        printTasks(tasks, 0); // Call recursive print
    }

    // Recursive function to print tasks with indentation
    void printTasks(String[] arr, int i) {
        if (i == arr.length) return;

        for (int k = 0; k < i; k++) System.out.print("  "); // Print spaces
        System.out.println(arr[i]); // Print task

        printTasks(arr, i + 1); // Recursive call
    }
}

// Main Class
public class Week4Story {

    // Main function where program execution starts
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Scanner object for input

        // Creating objects of all problem classes
        RussianDoll rd = new RussianDoll();
        Staircase st = new Staircase();
        AncestryTree at = new AncestryTree();
        WordMirror wm = new WordMirror();
        MazeRunner mr = new MazeRunner();
        TeamAssembly ta = new TeamAssembly();
        VaultCode vc = new VaultCode();
        StringTiling stg = new StringTiling();
        BudgetCalculator bc = new BudgetCalculator();
        ProjectBuilder pb = new ProjectBuilder();

        // Infinite loop so user can run multiple problems
        while (true) {

            // Display menu
            System.out.println("\n===== WEEK 4 STORY MENU =====");
            System.out.println("1. Russian Doll Mystery");
            System.out.println("2. Staircase Architect");
            System.out.println("3. Digital Ancestry Tree");
            System.out.println("4. Word Mirror");
            System.out.println("5. Maze Runner");
            System.out.println("6. Perfect Team Assembly");
            System.out.println("7. Secure Vault Code");
            System.out.println("8. String Tiling Challenge");
            System.out.println("9. Budget Calculator");
            System.out.println("10. Project Builder Blueprint");
            System.out.println("0. Exit");

            // Taking user choice
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            // Switch case to call selected problem
            switch (ch) {
                case 1:
                    rd.run();
                    break;
                case 2:
                    st.run();
                    break;
                case 3:
                    at.run();
                    break;
                case 4:
                    wm.run();
                    break;
                case 5:
                    mr.run();
                    break;
                case 6:
                    ta.run();
                    break;
                case 7:
                    vc.run();
                    break;
                case 8:
                    stg.run();
                    break;
                case 9:
                    bc.run();
                    break;
                case 10:
                    pb.run();
                    break;
                case 0:
                    System.exit(0); // Exit program
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
