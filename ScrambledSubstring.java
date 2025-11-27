import java.util.Scanner;

class ScrambledSubstring {

    // Check if two strings have the same letters
    static boolean sameLetters(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] count = new int[26]; // a-z letters
        for (int i = 0; i < a.length(); i++){
            count[a.charAt(i) - 'a']++;
        }        
        for (int i = 0; i < b.length(); i++){ 
            count[b.charAt(i) - 'a']--;
        }
        for (int c : count){
            if (c != 0) 
            return false;
        }
        return true;
    }

    // search for scrambled substring
    static boolean findScrambled(String superStr, String subStr) {
        for (int i = 0; i <= superStr.length() - subStr.length(); i++) {
            if (sameLetters(superStr.substring(i, i + subStr.length()), subStr))
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Superstring: ");
        String superStr = sc.nextLine();

        System.out.print("Substring: ");
        String subStr = sc.nextLine();

        System.out.println(findScrambled(superStr, subStr)); // true or false
    }
}
