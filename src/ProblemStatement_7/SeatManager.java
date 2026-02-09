package ProblemStatement_7;
import java.util.HashSet;

public class SeatManager {
    static String firstDuplicate(String[][] data) {
        HashSet<String> seats = new HashSet<>();

        for (int i = 0; i < data.length; i++) {
            String seat = data[i][1];
            if (seats.contains(seat)) {
                return data[i][0];
            }
            seats.add(seat);
        }
        return "-1";
    }
}