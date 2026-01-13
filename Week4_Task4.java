//The Spy's Cipher

import java.util.HashMap;
import java.util.Map;

public class Week4_Task4 {

    public static char findExtraCharacter(String original, String scrambled) {

        Map<Character, Integer> count = new HashMap<>();

        
        for (char ch : scrambled.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        
        for (char ch : original.toCharArray()) {
            count.put(ch, count.get(ch) - 1);
        }

        
        for (char ch : count.keySet()) {
            if (count.get(ch) == 1) {
                return ch;
            }
        }

        return ' '; 
    }

    public static void main(String[] args) {

        System.out.println(findExtraCharacter("abcd", "abcde"));
        System.out.println(findExtraCharacter("aabc", "abacx"));
        System.out.println(findExtraCharacter("hello", "hlleo"));
    }
}