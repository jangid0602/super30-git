package Story_4;

import java.util.*;

public class Task_5 {
    public static boolean isPath(int[][] maze, int row, int col, int n) {

        if (row >= n || col >= n || maze[row][col] == 0) {
            return false;
        }

        if (row == n - 1 && col == n - 1) {
            return true;
        }

        if (isPath(maze, row, col + 1, n)) {
            return true;
        }

        if (isPath(maze, row + 1, col, n)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of maze (N): ");
        int n = sc.nextInt();

        int[][] maze = new int[n][n];

        System.out.println("Enter maze values (0 = blocked, 1 = open):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        boolean result = isPath(maze, 0, 0, n);
        System.out.println("Path Exists: " + result);
    }
}
