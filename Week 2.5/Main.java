/*
 * This Class is used to call the functions that are stored in the file called Stories. The functions are as follows :
 * 
 * 1. The Cosmic Courier Challenge
 * 2. The Digital Library System
 * 3. The Factory Floor Robot
 * 4. The Spy’s Cipher
 * 5. The Corporate Hierarchy System
 * 6. The Security Log Analyzer
 * 7. The Concert Seat Manage
 * 8. The Weather Station Data Aggregator
 */
import java.util.Scanner;

public class Main {
    public static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        boolean keepGoing;
        Stories storiesObject = new Stories();
        Stories.Library lib = new Stories.Library();
        String options = """
                1. The Cosmic Courier Challenge
                2. The Digital Library System
                3. The Factory Floor Robot
                4. The Spy’s Cipher
                5. The Corporate Hierarchy System
                6. The Security Log Analyzer
                7. The Concert Seat Manage
                8. The Weather Station Data Aggregator
                """;
                do {
                    System.out.print("Which of these stories would you like to explore ? :\n" + options + "enter operation to perform: ");
                    String optionNumber = userInput.nextLine();
                    switch(optionNumber){

                        case "1" -> {
                            System.out.print("Total no of routes: ");
                            int size = userInput.nextInt();
                            userInput.nextLine();
                            System.out.print("Enter the different routes: ");
                            int[] num = new int[size];
                            for(int index = 0; index < size; index++){
                                num[index] = userInput.nextInt();
                            }
                            userInput.nextLine();
                            System.out.println("Minimum possible deadline after removing a single route: " + storiesObject.cosmicCourier(num));
                        }

                        case "2" -> {
                            System.out.print("How many books to add: ");
                            int size = userInput.nextInt();
                            userInput.nextLine();
                            for (int i = 0; i < size ; i++) {
                                String title = userInput.nextLine();
                                lib.addBook(title);
                            }
                            System.out.print("Enter search title: ");
                            String search = userInput.nextLine();
                            lib.searchPartial(search);
                            break;
                        }

                        case "3" -> {
                            System.out.print("Total no of items: ");
                            int size = userInput.nextInt();
                            userInput.nextLine();
                            System.out.print("Weight of each item: ");
                            int[] arr = new int[size];
                            for(int index = 0; index < size; index++){
                                arr[index] = userInput.nextInt();
                            }
                            userInput.nextLine();
                            String[] r = storiesObject.itemsWeight(arr);
                            for(int i = 0; i < r.length; i++) System.out.print(r[i] + " ");
                            System.out.println();
                        }

                        case "4" -> {
                            System.out.print("Enter original string: ");
                            String original = userInput.nextLine();
                            System.out.print("Enter scrambled string: ");
                            String scrambled = userInput.nextLine();
                            System.out.println(storiesObject.extraCharacter(original,scrambled));
                            break;
                        }

                        case "5" -> {
                            System.out.print("Enter number of employees: ");
                            int size = userInput.nextInt();
                            userInput.nextLine();
                            Stories.Employee[] emp = new Stories.Employee[size];
                            for (int i = 0 ; i < size ; i++) {
                                System.out.print("Enter type (1-Employee,2-Manager,3-Executive): ");
                                int type = userInput.nextInt();
                                System.out.print("Enter base salary: ");
                                double sal = userInput.nextDouble();
                                userInput.nextLine();
                                if (type == 1) emp[i] = new Stories.Employee(sal);
                                else if (type == 2) emp[i] = new Stories.Manager(sal);
                                else emp[i] = new Stories.Executive(sal);
                            }
                            System.out.println(storiesObject.totalBonus(emp));
                            break;
                        }

                        case "6" -> {
                            System.out.print("enter the number of logins: ");
                            int size = userInput.nextInt();
                            userInput.nextLine();
                            System.out.print("Enter login data: ");
                            int[] arr = new int[size];
                            for(int index = 0; index < size; index++){
                                arr[index] = userInput.nextInt();
                            }
                            System.out.print("Enter range: ");
                            int[] range = new int[2];
                            for(int index = 0; index < 2; index++){
                                range[index] = userInput.nextInt();
                            }
                            userInput.nextLine();
                            System.out.println("The sum of the minumum time slots is: " + storiesObject.rangeSum(arr, range));
                        }

                        case "7" -> {
                            System.out.print("Enter number of bookings: ");
                            int size = userInput.nextInt();
                            userInput.nextLine();
                            String[][] bookings = new String[size][2];
                            System.out.print("Enter customer id with seat number: ");
                            for (int i = 0; i < size; i++) {
                                bookings[i][0] = userInput.next();
                                bookings[i][1] = userInput.next();
                            }
                            userInput.nextLine();
                            System.out.println("Sorry!! " + storiesObject.firstDuplicateSeat(bookings) + " is unavailable at the moment :(");
                            break;
                        }

                        case "8" -> {
                            System.out.print("Enter size of temperature array: ");
                            int size = userInput.nextInt();
                            userInput.nextLine();
                            int[] temp = new int[size];
                            System.out.print("Enter elements: ");
                            for (int i = 0; i < size; i++) temp[i] = userInput.nextInt();
                            userInput.nextLine();
                            System.out.println(storiesObject.countMaxTempDays(temp));
                            break;
                        }

                        default -> System.out.println("Invalid Input!");
                    }
                    System.out.print("Do you want explore further (y/n)?: ");
                    String userResponse = userInput.nextLine();
                    keepGoing = userResponse.equalsIgnoreCase("y");
                } while (keepGoing);

                System.out.println(".\n.\n.\nBYE :)");
                
    }
}
