package Codeup.Story_2p5;

import java.util.HashMap;
import java.util.Scanner;

public class Task_4 {
    public static char extraChar(String original, String scrambled) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < original.length(); i++) {
            char ch = original.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < scrambled.length(); i++) {
            char ch = scrambled.charAt(i);
            if (!map.containsKey(ch)) return ch;
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) < 0) return ch;
        }
        return ' ';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter original string: ");
        String original = sc.next();
        System.out.println("Enter scrambled string: ");
        String scrambled = sc.next();
        System.out.println("Extra char is: " + extraChar(original,scrambled));
    }
}
