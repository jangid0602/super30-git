import java.util.HashMap;

public class q4 {

    public static char findextra(String original, String scrambled) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : scrambled.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : original.toCharArray()) {
            map.put(c, map.get(c) - 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(findextra("abcd", "abcde"));
    }
}
