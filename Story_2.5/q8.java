public class q8 {

    static int countrecords(int[] temp) {
        int count = 1;
        int max = temp[0];

        for (int i = 1; i < temp.length; i++) {
            if (temp[i] > max) {
                count++;
                max = temp[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] temps = {15, 22, 15, 30, 28, 31};
        System.out.println(countrecords(temps));
    }
}
