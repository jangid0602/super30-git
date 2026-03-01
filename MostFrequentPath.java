import java.util.Scanner;

class MostFrequentPath {
    void findMostFrequent(String[] users, String[] pages, int n) {
        String best = "";   // stores the final most frequent path
        int bestFreq = 0;   // stores how many times the best path occurs

        for (int i = 0; i < n - 1; i++) {
            // A valid 2-step path must be by the SAME user
            if (!users[i].equals(users[i + 1])) continue;

            // Create the current 2-step path (example: "home,search")
            String curr = pages[i] + "," + pages[i + 1];
            int freq = 0;   // count how many times this path appears

            // Count the frequency of this path by checking all pairs
            for (int j = 0; j < n - 1; j++) {
                if (users[j].equals(users[j + 1])) {
                    String temp = pages[j] + "," + pages[j + 1];

                    // if it matches the current path, increase count
                    if (temp.equals(curr)) {
                        freq++;
                    }
                }
            }
            // choose the path with the highest count
            // If counts are equal, choose alphabetically smaller one
            if (freq > bestFreq) {
                bestFreq = freq;
                best = curr;
            } 
            else if (freq == bestFreq && curr.compareTo(best) < 0) {
                best = curr;
            }
        }
        System.out.println("Most frequent 2-step path: " + best);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of actions: ");
        int n = sc.nextInt();
        sc.nextLine();         
        String[] users = new String[n];
        String[] pages = new String[n];

        System.out.println("Enter actions in format 'user,page' (e.g., u1,home):");
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().split(",");
            users[i] = p[0];
            pages[i] = p[1];
        }
        // Create object and call the function
        MostFrequentPath obj = new MostFrequentPath();     
        obj.findMostFrequent(users, pages, n);
    }
}
