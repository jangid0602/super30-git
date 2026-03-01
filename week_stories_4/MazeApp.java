import java.util.ArrayList;
import java.util.Scanner;

class MazeRunner {

    public int[][] inputGrid() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows/columns: ");
        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        System.out.println("Enter grid values:");
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                grid[r][c] = sc.nextInt();
            }
        }
        return grid;
    }

    public boolean findPath(int[][] grid, int r, int c) {
        int n = grid.length;

        if (r < 0 || r >= n || c < 0 || c >= n)
            return false;

        if (grid[r][c] == 0)
            return false;

        if (r == n - 1 && c == n - 1)
            return true;

        return findPath(grid, r + 1, c) || findPath(grid, r, c + 1);
    }

    public boolean mazeRunner() {
        int[][] grid = inputGrid();
        return findPath(grid, 0, 0);
    }
}

public class MazeApp {
    public static void main(String[] args) {
        MazeRunner runner = new MazeRunner();

        if (runner.mazeRunner())
            System.out.println("True");
        else
            System.out.println("False");
    }
}

