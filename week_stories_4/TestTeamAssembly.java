import java.util.ArrayList;
import java.util.Scanner;

class TeamAssembly {

    public ArrayList<String> inputTeams() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();

        ArrayList<String> teams = new ArrayList<>();

        System.out.println("Enter all teams:");
        for (int i = 0; i < n; i++) {
            teams.add(sc.next());
        }
        return teams;
    }

    public void teamCombinations(
            ArrayList<String> teams,
            int i,
            ArrayList<String> combinations
    ) {
        if (i >= teams.size()) {
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
        teamCombinations(teams, i + 1, combinations);

        // take current team
        combinations.add(teams.get(i));
        teamCombinations(teams, i + 1, combinations);
        combinations.remove(combinations.size() - 1); // backtrack
    }

    public void teamAssemble() {
        ArrayList<String> teams = inputTeams();
        ArrayList<String> combination = new ArrayList<>();
        teamCombinations(teams, 0, combination);
    }
}

class TestTeamAssembly {
    public static void main(String[] args) {
        TeamAssembly ta = new TeamAssembly();
        ta.teamAssemble();
    }
}

