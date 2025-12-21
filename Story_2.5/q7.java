import java.util.HashSet;

// Question 7: Concert Seat Manager
// Program to find the first customer who books an already booked seat

class q7 {

    static String findDuplicatecustomer(String data[][]) {

        HashSet<String> bookedSeats = new HashSet<>();

        for (int i = 0; i < data.length; i++) {

            String customer = data[i][0];
            String seat = data[i][1];

            if (bookedSeats.contains(seat)) {
                return customer;
            }

            bookedSeats.add(seat);
        }

        return "-1";
    }

    public static void main(String[] args) {

        String input[][] = {
            {"c1", "101"},
            {"c2", "105"},
            {"c3", "101"}
        };

        System.out.println(findDuplicatecustomer(input));
    }
}
