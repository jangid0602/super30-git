import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PythonIndentation{

        public static boolean isValidIndentation(List<String> lines) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            String prevLine = "";

            for (String line : lines) {
                if (line.trim().isEmpty()) {        // remove empty lines.
                    continue;
                }

                int spaces = 0;     // count space (leading)
                while (spaces < line.length() && line.charAt(spaces) == ' ') {
                    spaces++;
                }

                if (spaces > stack.peek()) {

                    // indentation allowed only after :
                    if (!prevLine.trim().endsWith(":")) {
                        return false;
                    }
                    stack.push(spaces);
                }
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
            Scanner userInput = new Scanner(System.in);
            try{
                System.out.print("Enter number of lines: ");
                int line = userInput.nextInt();
                userInput.nextLine(); // consume newline

                List<String> lines = new ArrayList<>();

                System.out.println("Enter code lines:");
                for (int i = 0; i < line; i++) {
                    lines.add(userInput.nextLine());
                }

                boolean result = isValidIndentation(lines);
                System.out.println(result);
            }
            catch(Exception e){
                System.out.print("Invalid Input!");
            }
        }
    }
