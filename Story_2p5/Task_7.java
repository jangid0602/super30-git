package Codeup.Story_2p5;

import java.util.HashSet;
import java.util.Scanner;

public class Task_7 {
    public String ticketplat(String[][] bookings) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < bookings.length; i++) {
            int seat = Integer.parseInt(bookings[i][1]);
            if (hs.contains(seat)) return bookings[i][0];
            hs.add(seat);
        }
        return "-1";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task_7 m = new Task_7();
        System.out.println("Enter number of bookings: ");
        int n7 = sc.nextInt();
        String[][] b = new String[n7][2];
        for (int k = 0; k < n7; k++) {
            b[k][0] = sc.next();
            b[k][1] = sc.next();
        }
        System.out.println(m.ticketplat(b));
    }
}
