package ProblemStatement_3;

public class RobotLabel {
    static String getLabel(int n) {
        if (n % 15 == 0) {
            return "Hazardous";
        } else if (n % 3 == 0) {
            return "Heavy";
        } else if (n % 5 == 0) {
            return "Fragile";
        } else {
            return n + "";
        }
    }

    static void process(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("\"" + getLabel(arr[i]) + "\"");
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
