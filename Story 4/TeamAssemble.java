import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TeamAssemble{
    public static void teamCombinations(List<String> teams, int ind, List<String> combinations){
        if (ind >= teams.size()) {
            System.out.print("[");
            for (int idx = 0; idx < combinations.size(); idx++) {
                if (idx == combinations.size() - 1)
                    System.out.print(combinations.get(idx));
                else
                    System.out.print(combinations.get(idx) + ", ");
            }
            System.out.println("]");
            return;
        }

        // skip current team
        teamCombinations(teams, ind + 1, combinations);

        // take current team
        combinations.add(teams.get(ind));
        teamCombinations(teams, ind + 1, combinations);
        combinations.remove(combinations.size() - 1); // backtrack
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter number of members : ");
        int number = userInput.nextInt();
        userInput.nextLine();
        ArrayList<String> members = new ArrayList<>();
        for(int i=0; i<number; i++){
            System.out.print("Enter "+(i+1)+" member : ");
            String member = userInput.nextLine();
            members.add(member);
        }
        ArrayList<String> combination = new ArrayList<>();
        teamCombinations(members, 0, combination);
    }
}
