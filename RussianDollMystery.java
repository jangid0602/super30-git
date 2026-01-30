package Story4.java;

class RussianDollMystery {

    static class Doll {
        boolean hasKey;
        Doll innerDoll;

        Doll(boolean hasKey, Doll innerDoll) {
            this.hasKey = hasKey;
            this.innerDoll = innerDoll;
        }
    }

    static boolean findKey(Doll doll) {
        if (doll == null) {
            return false;
        }

        if (doll.hasKey) {
            return true;
        }

        return findKey(doll.innerDoll);
    }
}
class StaircaseArchitect {

    static int countWays(int stepsRemaining) {
        if (stepsRemaining == 0) {
            return 1;
        }

        if (stepsRemaining < 0) {
            return 0;
        }

        return countWays(stepsRemaining - 1)
                + countWays(stepsRemaining - 2);
    }
}
class DigitalAncestryTree {

    static class Person {
        int wealth;
        Person[] children;

        Person(int wealth, Person[] children) {
            this.wealth = wealth;
            this.children = children;
        }
    }

    static int calculateTotalWealth(Person person) {
        if (person == null) {
            return 0;
        }

        int totalWealth = person.wealth;

        for (int i = 0; i < person.children.length; i++) {
            totalWealth += calculateTotalWealth(person.children[i]);
        }

        return totalWealth;
    }
}
class WordMirror {

    static boolean isPalindrome(String text) {
        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindrome(text.substring(1, text.length() - 1));
    }
}
class MazeRunner {

    static boolean pathExists(int[][] maze, int row, int column) {

        int size = maze.length;

        if (row == size - 1 && column == size - 1) {
            return true;
        }

        if (row >= size || column >= size || maze[row][column] == 0) {
            return false;
        }

        return pathExists(maze, row + 1, column)
                || pathExists(maze, row, column + 1);
    }
}
class PerfectTeamAssembly {

    static void generateTeams(
            String[] members,
            int index,
            String[] currentTeam,
            int teamSize) {

        if (index == members.length) {
            for (int i = 0; i < teamSize; i++) {
                System.out.print(currentTeam[i] + " ");
            }
            System.out.println();
            return;
        }

        generateTeams(members, index + 1, currentTeam, teamSize);

        currentTeam[teamSize] = members[index];
        generateTeams(members, index + 1, currentTeam, teamSize + 1);
    }
}
class SecureVaultCode {

    static void generateCodes(
            int[] digits,
            boolean[] used,
            int[] currentCode,
            int position) {

        if (position == digits.length) {
            for (int i = 0; i < digits.length; i++) {
                System.out.print(currentCode[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (!used[i]) {
                used[i] = true;
                currentCode[position] = digits[i];

                generateCodes(digits, used, currentCode, position + 1);

                used[i] = false;
            }
        }
    }
}
class StringTilingChallenge {

    static String compress(String text, int index, int count) {

        if (index == text.length()) {
            return "";
        }

        if (index == text.length() - 1
                || text.charAt(index) != text.charAt(index + 1)) {

            return count + "" + text.charAt(index)
                    + compress(text, index + 1, 1);
        }

        return compress(text, index + 1, count + 1);
    }
}
class BudgetCalculator {

    static void findCombinations(
            int[] prices,
            int index,
            int remainingBudget,
            int[] selected,
            int selectedCount) {

        if (remainingBudget == 0) {
            for (int i = 0; i < selectedCount; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }

        if (remainingBudget < 0 || index == prices.length) {
            return;
        }

        selected[selectedCount] = prices[index];
        findCombinations(
                prices,
                index,
                remainingBudget - prices[index],
                selected,
                selectedCount + 1);

        findCombinations(
                prices,
                index + 1,
                remainingBudget,
                selected,
                selectedCount);
    }
}
class ProjectBuilderBlueprint {

    static void printTasks(
            String taskName,
            String[] subTasks,
            int level) {

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }

        System.out.println(taskName);

        for (int i = 0; i < subTasks.length; i++) {
            printTasks(subTasks[i], new String[0], level + 1);
        }
    }
}
