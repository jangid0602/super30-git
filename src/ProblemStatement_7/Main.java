package ProblemStatement_7;

public class Main {
    public static void main(String[] args) {

        String[][] a = {{"C1","101"},{"C2","105"},{"C3","101"}};
        System.out.println(SeatManager.firstDuplicate(a));

        String[][] b = {{"C1","101"},{"C2","105"},{"C3","103"},{"C4","105"}};
        System.out.println(SeatManager.firstDuplicate(b));

        String[][] c = {{"C1","10"},{"C2","20"}};
        System.out.println(SeatManager.firstDuplicate(c));
    }
}
