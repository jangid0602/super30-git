package Task_2;

import java.util.*;

public class IndentationValidator {

    public static boolean isValidIndentation(List<String> lines) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        String prevLine = "";

        for (String line : lines) {

            // ignore empty lines
            if (line.trim().isEmpty()) {
                continue;
            }

            // count leading spaces
            int spaces = 0;
            while (spaces < line.length() && line.charAt(spaces) == ' ') {
                spaces++;
            }

            // indentation increased
            if (spaces > stack.peek()) {

                // indentation allowed only after :
                if (!prevLine.trim().endsWith(":")) {
                    return false;
                }
                stack.push(spaces);
            }
            // indentation same or decreased
            else {
                while (!stack.isEmpty() && spaces < stack.peek()) {
                    stack.pop();
                }

                if (stack.isEmpty() || spaces != stack.peek()) {
                    return false;
                }
            }

            prevLine = line;
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of lines: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<String> lines = new ArrayList<>();

        System.out.println("Enter code lines:");
        for (int i = 0; i < n; i++) {
            lines.add(sc.nextLine());
        }

        boolean result = isValidIndentation(lines);
        System.out.println(result);

        sc.close();
    }
}

