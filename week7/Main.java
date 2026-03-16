/*
 * Ownwer -> Yadav Adarsh Ramesh
 * Date -> 10/03/2026
 * Stories Week 7
 * problems ->
 * 1. The Startup Revenue Maxima
 * 2. Codeup Mentorship Matching
 * 3. The Minimal Tech-Stack Swap
 * 4. Placement Marathon
 * 5. The Optimal Server Latency
 */
import java.util.Scanner;

public class Main {
    public static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        boolean keepGoing;
        Stories storiesObject = new Stories();
        String options = """
                1. The Startup Revenue Maxima
                2. Codeup Mentorship Matching
                3. The Minimal Tech-Stack Swap
                4. Placement Marathon
                5. The Optimal Server Latency
                """;
                do {
                    System.out.print("Which of these stories would you like to explore ? :\n" + options + "enter operation to perform: ");
                    String optionNumber = userInput.nextLine();
                    switch(optionNumber){

                        case "1" -> {
                            System.out.print("Total no of days: ");
                            int n = userInput.nextInt();
                            userInput.nextLine();
                            System.out.print("Enter revenue: ");
                            int[] revenue = new int[n];
                            for(int i = 0 ; i < n ; i++){
                                revenue[i] = userInput.nextInt();
                            }
                            userInput.nextLine();
                            System.out.println("Maximum revenue generated: " + storiesObject.maximumRevenue(revenue));
                        }

                        case "2" -> {
                            System.out.print("Enter number of Mentors/Students: ");
                            int n = userInput.nextInt();
                            int[][] scores = new int[n][n];
                            System.out.println("Enter the matrix (" + n + "x" + n + "):");
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                    scores[i][j] = userInput.nextInt();
                                }
                            }
                            userInput.nextLine();
                            int result = storiesObject.mentorshipMatch(n, scores);
                            System.out.println("Maximum total compatibility score: " + result);
                        }

                        case "3" -> {
                            System.out.print("Enter current stack S1: ");
                            String s1 = userInput.nextLine();
                            System.out.print("Enter target stack S2: ");
                            String s2 = userInput.nextLine();
                            System.out.print("Enter costs Insert Delete Upgrade: ");
                            int ci = userInput.nextInt();
                            int cd = userInput.nextInt();
                            int cu = userInput.nextInt();
                            userInput.nextLine(); 
                            int result = storiesObject.techStackSwap(s1, s2, ci, cd, cu);
                            System.out.println("Minimum cost to swap tech-stack: " + result);
                        }

                        case "4" -> {
                            System.out.print("Enter number of students: ");
                            int n = userInput.nextInt();
                            System.out.print("Enter the difference: ");
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
                            System.out.print("Enter number of servers: ");
                            int n = userInput.nextInt();
                            System.out.print("Enter number of clusters: ");
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

                        default -> System.out.println("Invalid Input!");
                    }
                    System.out.print("Do you want explore further (y/n)?: ");
                    String userResponse = userInput.nextLine();
                    keepGoing = userResponse.equalsIgnoreCase("y");
                } while (keepGoing);

                System.out.println("\nOperation Ends");                
    }
}