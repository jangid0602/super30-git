package week4story;

public class MazeRunner {
 public static boolean isPathExist(int[][] maze) {
        int n = maze.length;
        return backtrack(maze, 0, 0, n);
    }

    private static boolean backtrack(int[][] maze, int row, int col, int n) {

        // base case: reached destination
        if (row == n - 1 && col == n - 1 && maze[row][col] == 1) {
            return true;
        }

        // check valid cell
        if (row < n && col < n && maze[row][col] == 1) {

            // move Right
            if (backtrack(maze, row, col + 1, n)) {
                return true;
            }

            // move Down
            if (backtrack(maze, row + 1, col, n)) {
                return true;
            }
        }

        // no path from this cell
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0},
            {1, 1}
        };
        System.out.println(isPathExist(maze)); 
    }
}
