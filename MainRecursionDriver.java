package Story4.java;

import java.util.Scanner;

/**
 * MainRecursionDriver
 *
 * Acts as the entry point for all
 * 10 recursion and backtracking assignments.
 */
public class MainRecursionDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int userChoice;

        do {
            System.out.println("\n========= RECURSION ASSIGNMENTS MENU =========");
            System.out.println("1. Russian Doll Mystery");
            System.out.println("2. Staircase Architect");
            System.out.println("3. Digital Ancestry Tree");
            System.out.println("4. Word Mirror (Palindrome)");
            System.out.println("5. Maze Runner");
            System.out.println("6. Perfect Team Assembly");
            System.out.println("7. Secure Vault Code");
            System.out.println("8. String Tiling Challenge");
            System.out.println("9. Budget Calculator");
            System.out.println("10. Project Builder's Blueprint");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            userChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (userChoice) {

                case 1:
                    runRussianDoll(scanner);
                    break;

                case 2:
                    runStaircase(scanner);
                    break;

                case 3:
                    runAncestryTree(scanner);
                    break;

                case 4:
                    runPalindrome(scanner);
                    break;

                case 5:
                    runMaze(scanner);
                    break;

                case 6:
                    runTeamAssembly(scanner);
                    break;

                case 7:
                    runVault(scanner);
                    break;

                case 8:
                    runStringCompression(scanner);
                    break;

                case 9:
                    runBudgetCalculator(scanner);
                    break;

                case 10:
                    runProjectBlueprint(scanner);
                    break;

                case 0:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (userChoice != 0);

        scanner.close();
    }

      // 1. Russian Doll Mystery

    private static void runRussianDoll(Scanner scanner) {

        System.out.print("Enter number of dolls: ");
        int dollCount = scanner.nextInt();

        RussianDollMystery.Doll innerMost =
                new RussianDollMystery.Doll(true, null);

        RussianDollMystery.Doll current = innerMost;

        for (int i = 1; i < dollCount; i++) {
            current = new RussianDollMystery.Doll(false, current);
        }

        System.out.println(
                RussianDollMystery.findKey(current)
                        ? "Key Found!"
                        : "Key Not Found!"
        );
    }

      // 2. Staircase Architect

    private static void runStaircase(Scanner scanner) {

        System.out.print("Enter number of steps: ");
        int steps = scanner.nextInt();

        System.out.println("Total Ways: "
                + StaircaseArchitect.countWays(steps));
    }

      // 3. Digital Ancestry Tree

    private static void runAncestryTree(Scanner scanner) {

        System.out.print("Enter parent wealth: ");
        int parentWealth = scanner.nextInt();

        System.out.print("Enter number of children: ");
        int childCount = scanner.nextInt();

        DigitalAncestryTree.Person[] children =
                new DigitalAncestryTree.Person[childCount];

        for (int i = 0; i < childCount; i++) {
            System.out.print("Enter wealth of child " + (i + 1) + ": ");
            children[i] = new DigitalAncestryTree.Person(
                    scanner.nextInt(), new DigitalAncestryTree.Person[0]);
        }

        DigitalAncestryTree.Person parent =
                new DigitalAncestryTree.Person(parentWealth, children);

        System.out.println("Total Legacy: "
                + DigitalAncestryTree.calculateTotalWealth(parent));
    }

       // 4. Word Mirror

    private static void runPalindrome(Scanner scanner) {

        System.out.print("Enter a word: ");
        String word = scanner.nextLine();

        System.out.println("Is Palindrome: "
                + WordMirror.isPalindrome(word));
    }

       // 5. Maze Runner

    private static void runMaze(Scanner scanner) {

        System.out.print("Enter maze size: ");
        int size = scanner.nextInt();

        int[][] maze = new int[size][size];

        System.out.println("Enter maze values (1=open, 0=blocked):");
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                maze[row][column] = scanner.nextInt();
            }
        }

        System.out.println("Path Exists: "
                + MazeRunner.pathExists(maze, 0, 0));
    }

       // 6. Perfect Team Assembly

    private static void runTeamAssembly(Scanner scanner) {

        System.out.print("Enter number of team members: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        String[] members = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter member name: ");
            members[i] = scanner.nextLine();
        }

        String[] currentTeam = new String[count];
        PerfectTeamAssembly.generateTeams(members, 0, currentTeam, 0);
    }

      // 7. Secure Vault Code

    private static void runVault(Scanner scanner) {

        System.out.print("Enter number of digits: ");
        int count = scanner.nextInt();

        int[] digits = new int[count];
        for (int i = 0; i < count; i++) {
            digits[i] = scanner.nextInt();
        }

        SecureVaultCode.generateCodes(
                digits,
                new boolean[count],
                new int[count],
                0
        );
    }

      // 8. String Tiling Challenge

    private static void runStringCompression(Scanner scanner) {

        System.out.print("Enter string: ");
        String text = scanner.nextLine();

        System.out.println("Compressed: "
                + StringTilingChallenge.compress(text, 0, 1));
    }

       // 9. Budget Calculator

    private static void runBudgetCalculator(Scanner scanner) {

        System.out.print("Enter number of items: ");
        int count = scanner.nextInt();

        int[] prices = new int[count];
        System.out.println("Enter item prices:");
        for (int i = 0; i < count; i++) {
            prices[i] = scanner.nextInt();
        }

        System.out.print("Enter total budget: ");
        int budget = scanner.nextInt();

        int[] selected = new int[budget];

        System.out.println("Valid combinations:");
        BudgetCalculator.findCombinations(
                prices, 0, budget, selected, 0);
    }

      // 10. Project Builder Blueprint

    private static void runProjectBlueprint(Scanner scanner) {

        System.out.print("Enter main task name: ");
        String mainTask = scanner.nextLine();

        System.out.print("Enter number of sub-tasks: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        String[] subTasks = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter sub-task " + (i + 1) + ": ");
            subTasks[i] = scanner.nextLine();
        }

        ProjectBuilderBlueprint.printTasks(mainTask, subTasks, 0);
    }
}
