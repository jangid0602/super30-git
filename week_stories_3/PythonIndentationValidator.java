import java.util.*;
import java.util.Stack;

public class PythonIndentationValidator {

    static boolean isValidIndentation(String[] lines) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // base indentation

        for (String line : lines) {

            // Ignore empty lines
            if (line.trim().isEmpty()) {
                continue;
            }

            // Count leading spaces
            int spaces = 0;
            while (spaces < line.length() && line.charAt(spaces) == ' ') {
                spaces++;
            }

            int currentIndent = spaces;
            int previousIndent = stack.peek();

            // Same indentation → OK
            if (currentIndent == previousIndent) {
                continue;
            }

            // Increased indentation
            if (currentIndent > previousIndent) {
                stack.push(currentIndent);
            }
            // Decreased indentation
            else {
                while (!stack.isEmpty() && stack.peek() > currentIndent) {
                    stack.pop();
                }

                // No matching indentation found
                if (stack.isEmpty() || stack.peek() != currentIndent) {
                    return false;
                }
            }
        }

        return true;
    }
    
   public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of lines: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] lines = new String[n];

        System.out.println("Enter Python code lines:");
        for (int i = 0; i < n; i++) {
            lines[i] = sc.nextLine();
        }

        boolean result = isValidIndentation(lines);

        System.out.println("\nIs indentation valid? " + result);

        sc.close();
    }
}






