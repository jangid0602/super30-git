//The Security Log Analyzer

public class Week4_Task6 {

    private int[] prefixSum;

    
    public SecurityLogAnalyzer(int[] logins) {

        prefixSum = new int[logins.length];
        prefixSum[0] = logins[0];

        for (int i = 1; i < logins.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + logins[i];
        }
    }

    
    public int query(int i, int j) {

        if (i == 0) {
            return prefixSum[j];
        }
        return prefixSum[j] - prefixSum[i - 1];
    }

    public static void main(String[] args) {

        
        int[] data1 = {10, 50, 20, 80, 15};
        SecurityLogAnalyzer analyzer1 = new SecurityLogAnalyzer(data1);
        System.out.println(analyzer1.query(1, 3)); // 150

        
        int[] data2 = {5, 5, 5, 5};
        SecurityLogAnalyzer analyzer2 = new SecurityLogAnalyzer(data2);
        System.out.println(analyzer2.query(0, 2)); // 15

        
        int[] data3 = {100};
        SecurityLogAnalyzer analyzer3 = new SecurityLogAnalyzer(data3);
        System.out.println(analyzer3.query(0, 0)); // 100
    }
}