package ProblemStatement_8;

public class WeatherData {
    public static int countRecords(String[] arr) {

        int count = 1;
        int max = Integer.parseInt(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int curr = Integer.parseInt(arr[i]);
            if (curr > max) {
                count++;
                max = curr;
            }
        }

        return count;
    }
}
