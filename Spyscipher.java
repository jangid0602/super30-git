import java.util.Scanner;

class Spyscipher {

    static char findExtraChar(String original, String scrambled) {

        int[] freq = new int[256]; // ASCII characters

        // Count characters of original
        for (int i = 0; i < original.length(); i++) {
            freq[original.charAt(i)]++;
        }

        // Subtract characters of scrambled
        for (int i = 0; i < scrambled.length(); i++) {
            freq[scrambled.charAt(i)]--;
        }

        // The character with -1 count is extra
        for (int i = 0; i < 256; i++) {
            if (freq[i] == -1) {
                return (char) i;
            }
        }

        return ' ';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original string: ");
        String original = sc.nextLine();

        System.out.print("Enter scrambled string: ");
        String scrambled = sc.nextLine();

        char result = findExtraChar(original, scrambled);
        System.out.println("Extra character: " + result);
    }
}
