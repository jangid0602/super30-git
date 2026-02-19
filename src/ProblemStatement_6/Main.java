package ProblemStatement_6;

public class Main {
    public static void main(String[] args) {

        int[] a = {10, 50, 20, 80, 15};
        SecurityLog s1 = new SecurityLog(a);
        System.out.println(s1.getLogins(1, 3));

        int[] b = {5, 5, 5, 5};
        SecurityLog s2 = new SecurityLog(b);
        System.out.println(s2.getLogins(0, 2));

        int[] c = {100};
        SecurityLog s3 = new SecurityLog(c);
        System.out.println(s3.getLogins(0, 0));
    }
}
