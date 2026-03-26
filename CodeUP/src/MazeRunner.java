import java.util.*;

public class MazeRunner {
     boolean findPath(int[][] maze, int row, int col, boolean[][] visited) {

        int n = maze.length;

        if (row == n - 1 && col == n - 1 && maze[row][col] == 1) {
            return true;
        }

        if (row < 0 || col < 0 || row >= n || col >= n ||
                maze[row][col] == 0 || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;

        if (findPath(maze, row, col + 1, visited)) {
            return true;
        }

        if (findPath(maze, row + 1, col, visited)) {
            return true;
        }
        visited[row][col] = false;

        return false;
    }

    public static void main(String[] args) {
        MazeRunner task = new MazeRunner();
        Scanner userInput = new Scanner(System.in);
        while(true) {
            try {
                System.out.print("Enter maze size N (-1 exits ): ");
                int n = Integer.parseInt(userInput.nextLine());
                if(n == -1) break;
                int[][] maze = new int[n][n];
                boolean[][] visited = new boolean[n][n];

                System.out.println("Enter maze values (0 or 1):");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        maze[i][j] = Integer.parseInt(userInput.nextLine());
                    }
                }

                if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
                    System.out.println(false);
                    return;
                }

                boolean result = task.findPath(maze, 0, 0, visited);
                System.out.println(result);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input!  enter integers only.");
            } catch (Exception e) {
                System.out.println("plz try to enter valid data.");
            }
        }
    }
}