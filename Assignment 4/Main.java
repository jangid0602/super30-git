import java.util.*;

public class Main {
    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        boolean keepGoing;
        MenuDescription menuDescriptionObject = new MenuDescription();
        String menu = """
                1. Count unique Palindromes
                2. Fibonacci SEquence - Nth Number
                3. snake_case to camelCaseConversion
                4. Count consonant in a String
                5. Binary to Decimal conversion
                6. Exit

                """;
                
        OUTERMOST_LOOP: do {
            System.out.print("Which of these operations do you want to perform ?\n" + menu + "Just enter the serial number: ");
            String operationNumber = userInput.nextLine();
            SWITCHCASE_BLOCK: switch (operationNumber) {

                case "1" -> {
                    System.out.print("Enter the String in you want to count the number of unique palindromic substrings: ");
                    String input = userInput.nextLine();
                    System.out.println(menuDescriptionObject.countUniquePalindromes(input));
                }

                case "2" -> {
                    System.out.print("Enter the fibonacci element number you want to know: ");
                    int input = userInput.nextInt();
                    userInput.nextLine();
                    System.out.println(menuDescriptionObject.fibonacci(input));
                }

                case "3" -> {
                    System.out.print("SNAKE_CASE: ");
                    String input = userInput.nextLine();
                    System.out.println(menuDescriptionObject.snakeToCamelCase(input));
                }

                case "4" -> {
                    System.out.print("Enter the String: ");
                    String input = userInput.nextLine();
                    System.out.println(menuDescriptionObject.countConsonant(input));
                }

                case "5" -> {
                    System.out.print("Enter the binary number: ");
                    String input = userInput.nextLine();
                    for(int index = 0; index < input.length(); index++){
                        if(input.charAt(index) != '0' && input.charAt(index) != '1'){
                            System.out.println("Invalid input, only enter the binary number !!");
                            break SWITCHCASE_BLOCK;
                        }
                    }
                    int validatedInput = Integer.parseInt(input);
                    System.out.println(menuDescriptionObject.binaryToDecimal(validatedInput));
                }

                case "6" -> {
                    break OUTERMOST_LOOP;
                }

                default -> System.out.println("Invalid input !!");
            }
            System.out.print("Do you want to continue performing operations ?(y/n): ");
            String userResponse = userInput.nextLine();
            keepGoing = userResponse.equalsIgnoreCase("y");
        } while (keepGoing);
        System.out.println("\nBye :)");
    }
}