import java.util.Scanner;

class StaircaseArchitect {

    public int staircaseArchitect(int n) {
        if (n == 0) {
            return 1;
        } 
        if (n < 0) {
            return 0;
        }
        return staircaseArchitect(n - 1) + staircaseArchitect(n - 2);
    }
}

class TestStaircase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        StaircaseArchitect stair = new StaircaseArchitect();
        System.out.println(stair.staircaseArchitect(n));
    }
}


