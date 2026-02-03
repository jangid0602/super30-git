import java.util.Scanner;
public class RatInAMaze{
    public static boolean puzzle(int[][] matrix,  int sr, int sc, int dr, int dc){ // s-> starting, d-> destination, r-> row, c-> column
        if(sr == dr && sc == dc) return true;
        else if(sr > dr || sc > dc) return false;
        else if(sr == dr && matrix[sr][sc+1] == 1) return puzzle(matrix, sr, sc+1, dr, dc);
        else if(sc == dc && matrix[sr+1][sc] == 1) return puzzle(matrix, sr+1, sc, dr, dc);
        else if(matrix[sr][sc+1] == 1){
            return puzzle(matrix, sr, sc+1, dr, dc);
        }
        else if(matrix[sr+1][sc] == 1){
            return puzzle(matrix, sr+1, sc, dr, dc);
        }
        return false;
    }
    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter grid size : ");
        int size = userInput.nextInt();
        int matrix[][] = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print("Enter matrix["+i+"]["+j+"] element(0/1) : ");
                matrix[i][j] = userInput.nextInt();
            }
        }
        boolean flag = puzzle(matrix, 0, 0, size-1, size-1);
        System.out.print("is possible to reach the destination : " + flag);
    }
}