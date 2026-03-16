/*
 * This is the Main class and is used just to take the input from the user and call the functions.
 * 
 * 1. The Startup wages Maxima
 * 2. Codeup Mentorship Matching
 * 3. The Minimal Tech-Stack Swap
 * 4. Placement Marathon
 * 5. The Optimal Server Latency
 * 
 * Ownwer -> Ayush Joshi
 * Last Updated -> 13/03/2026
 */
import java.util.Scanner;

public class Main {
    public static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        boolean keepGoing;
        Stories storiesObject = new Stories();
        String options = """
                1. The Startup wages Maxima
                2. Codeup Mentorship Matching
                3. The Minimal Tech-Stack Swap
                4. Placement Marathon
                5. The Optimal Server Latency
                """;
                do {
                    System.out.print("Which of these stories would you like to explore ? :\n" + options + "\nenter operation to perform: ");
                    String optionNumber = userInput.nextLine();
                    switch(optionNumber){

                        case "1" -> {
                            System.out.print("Total no of days: ");
                            int size = userInput.nextInt();
                            userInput.nextLine();
                            System.out.print("Enter wages for each day: ");
                            int[] wages = new int[size];
                            for(int index = 0; index < size; index++){
                                wages[index] = userInput.nextInt();
                            }
                            userInput.nextLine();
                            System.out.println("Maximum wages generated: " + storiesObject.startupwagesMaxima(wages));
                        }

                        case "2" -> {
                            System.out.print("Enter number of Mentors/Students (N): ");
                            int n = userInput.nextInt();
                            int[][] scores = new int[n][n];
                            System.out.println("Enter the compatibility matrix (" + n + "x" + n + "):");
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                    scores[i][j] = userInput.nextInt();
                                }
                            }
                            userInput.nextLine();
                            int result = storiesObject.mentorshipMatching(n, scores);
                            System.out.println("Maximum total compatibility score: " + result);
                        }

                        case "3" -> {
                            System.out.print("Enter current tech stack (S1): ");
                            String s1 = userInput.nextLine();
                            System.out.print("Enter target tech stack (S2): ");
                            String s2 = userInput.nextLine();
                            System.out.print("Enter costs (Insert Delete Upgrade) separated by space: ");
                            int ci = userInput.nextInt();
                            int cd = userInput.nextInt();
                            int cu = userInput.nextInt();
                            userInput.nextLine(); 
                            int result = storiesObject.techStackSwap(s1, s2, ci, cd, cu);
                            System.out.println("Minimum cost to swap tech-stack: " + result);
                        }

                        case "4" -> {
                            System.out.print("Enter number of students (N): ");
                            int n = userInput.nextInt();
                            System.out.print("Enter the difference (K): ");
                            int k = userInput.nextInt();
                            int[] skillLevels = new int[n];
                            System.out.print("Enter skill levels: ");
                            for (int i = 0; i < n; i++) {
                                skillLevels[i] = userInput.nextInt();
                            }
                            userInput.nextLine(); 
                            int result = storiesObject.placementMarathon(skillLevels, k);
                            System.out.println("Maximum length of placement marathon: " + result);
                        }

                        case "5" -> {
                            System.out.print("Enter number of servers (N): ");
                            int n = userInput.nextInt();
                            System.out.print("Enter number of clusters (K): ");
                            int k = userInput.nextInt();
                            int[] powers = new int[n];
                            System.out.print("Enter processing powers: ");
                            for (int i = 0; i < n; i++) {
                                powers[i] = userInput.nextInt();
                            }
                            userInput.nextLine();
                            int result = storiesObject.optimalServerLatency(powers, k);
                            System.out.println("Minimum total unbalance: " + result);
                        }

                        default -> System.out.println("\nWARNING !! : Invalid Input detected");
                    }
                    System.out.print("\nDo you want explore further (Y/N)?: ");
                    String userResponse = userInput.nextLine();
                    keepGoing = userResponse.equalsIgnoreCase("y");
                } while (keepGoing);

                System.out.println(".\n.\n.\n.\n.\n.\nBYE :)");                
    }
}