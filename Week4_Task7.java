//The Concert Seat Manager

import java.util.HashSet;

public class Week4_Task7 {

    
    public static String findDuplicateSeat(String[][] requests) {

        HashSet<String> bookedSeats = new HashSet<>();

        for (String[] request : requests) {
            String customer = request[0];
            String seat = request[1];

          
            if (bookedSeats.contains(seat)) {
                return customer;
            }

            bookedSeats.add(seat);
        }

        return "-1"; 
    }

    public static void main(String[] args) {

       
        String[][] input1 = {{"C1", "101"},{"C2", "105"},{"C3", "101"}};
        System.out.println(findDuplicateSeat(input1)); 

      
        String[][] input2 = {{"C1", "101"},{"C2", "105"},{"C3", "103"},{"C4", "105"}};
        System.out.println(findDuplicateSeat(input2)); 

        
        String[][] input3 = {
            {"C1", "10"},
            {"C2", "20"}
        };
        System.out.println(findDuplicateSeat(input3)); 
    }
}