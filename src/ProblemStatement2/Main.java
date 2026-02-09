package ProblemStatement2;

import java.util.*;

public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        String big = sc.nextLine();
        String small = sc.nextLine();

        Scramble s = new Scramble();
        boolean ans = s.check(big, small);

        System.out.println(ans);
    }
}


