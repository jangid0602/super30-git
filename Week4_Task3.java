//The Factory floor robot

import java.util.ArrayList;
import java.util.List;

public class Week4_Task3 {

    public static List<String> getLabels(int[] weights) {

        List<String> labels = new ArrayList<>();

        for (int weight : weights) {

            if (weight % 15 == 0) {
                labels.add("Hazardous");
            } 
            else if (weight % 3 == 0) {
                labels.add("Heavy");
            } 
            else if (weight % 5 == 0) {
                labels.add("Fragile");
            } 
            else {
                labels.add(Integer.toString(weight));
            }
        }

        return labels;
    }

    public static void main(String[] args) {

        int[] a = {15, 6, 10, 7};
        int[] b = {3, 5, 30};
        int[] c = {1, 2, 4};

        System.out.println(getLabels(a));
        System.out.println(getLabels(b));
        System.out.println(getLabels(c));
    }
}