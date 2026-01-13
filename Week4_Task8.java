//The Weather Station Data Aggregator

public class Week4_Task8 {

    public static int countRecordDays(String[] temps) {

        int recordDays = 0;
        int maxTemp = Integer.MIN_VALUE;

        for (String t : temps) {
            int temp = Integer.parseInt(t);

            if (temp > maxTemp) {
                recordDays++;
                maxTemp = temp;
            }
        }

        return recordDays;
    }

    public static void main(String[] args) {

        String[] data1 = {"15", "22", "15", "30", "28", "31"};
        String[] data2 = {"5", "1", "2", "3", "4"};
        String[] data3 = {"10", "10", "10"};

        System.out.println(countRecordDays(data1)); 
        System.out.println(countRecordDays(data2)); 
        System.out.println(countRecordDays(data3)); 
    }
}