import java.util.Scanner;

public class The_Word_Mirror {
    private boolean wordMirror(String s) throws Exception {
        if (s.isEmpty()) {
            throw new Exception("Your word is Empty");
        }
        if (s.length() < 2) {
            throw new Exception("Your word is short");
        }
        int i = 0;
        int j = s.length() - 1;
        return isMirror(i, j, s);
    }

    private boolean isMirror(int i, int j, String s) {
        if (i == j || (i + 1 == j && j - 1 == i)) {
            return true;
        }
        char ch = s.charAt(i);
        char ch1 = s.charAt(j);

        if (ch != ch1) {
            return false;
        }
        return isMirror(i + 1, j - 1, s);
    }

    public static void main(String[] args) {
        The_Word_Mirror task = new The_Word_Mirror();
        Scanner userInput = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("\u001B[33mEnter your word (-1 to exit ):- ");
                String s = userInput.nextLine();
                if (s.equals("-1")) break;
                System.out.println("\u001B[34m" + task.wordMirror(s));
            } catch (Exception e) {
                System.out.println("\u001B[31mError :- " + e.getMessage());

            }
        }
        System.out.println("\u001b[35mThank you");
    }
}
