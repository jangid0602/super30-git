package ProblemStatement3;

import java.util.*;

public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String user[] = new String[n];
        String page[] = new String[n];

        int i = 0;
        while (i < n) {
            String s = sc.nextLine();


            if (s.trim().length() == 0) {
                continue;
            }

            int k = s.indexOf(',');

            if (k != -1) {

                user[i] = s.substring(0, k).trim();
                page[i] = s.substring(k + 1).trim();
            } else {

                int sp = s.indexOf(' ');
                if (sp != -1) {
                    user[i] = s.substring(0, sp).trim();
                    page[i] = s.substring(sp + 1).trim();
                } else {

                    user[i] = "u" + i;
                    page[i] = s.trim();
                }
            }

            i++;
        }

        Path up = new Path();
        String ans = up.best(user, page, n);

        System.out.println(ans);
    }
}
