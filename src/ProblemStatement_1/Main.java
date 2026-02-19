package ProblemStatement_1;

public class Main {
    public static void main(String[] args) {

        int[] a = {10, 5, 8, 12, 6};
        int[] b = {3, 3, 3, 3};
        int[] c = {1, 100, 2};

        System.out.println(DeadlineCalculator.minimumDeadline(a));
        System.out.println(DeadlineCalculator.minimumDeadline(b));
        System.out.println(DeadlineCalculator.minimumDeadline(c));
    }
}
