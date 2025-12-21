import java.util.Scanner;

public class WeatherStationAggregator {

    // Method to count record-breaking days
    public static int countRecordDays(int[] temps) {
        int count = 0;

        for (int i = 0; i < temps.length; i++) {
            boolean isRecord = true;

            for (int j = 0; j < i; j++) {
                if (temps[j] >= temps[i]) {
                    isRecord = false;
                    break;
                }
            }

            if (isRecord) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] temps = new int[n];
        System.out.println("Enter temperatures:");
        for (int i = 0; i < n; i++) {
            temps[i] = sc.nextInt();
        }

        int result = countRecordDays(temps);
        System.out.println("Record-breaking days = " + result);
    }
}
