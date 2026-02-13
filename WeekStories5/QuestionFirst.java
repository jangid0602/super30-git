import java.util.*;

public class QuestionFirst {
    List<Character> list = new ArrayList<>();

    public int getPaliPathFinder(CharTreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        list.add(root.ch);
        count++;
        if (isPalindrome(list)) {
            count++;
        }
        count += getPaliPathFinder(root.left);
        count += getPaliPathFinder(root.right);
        list.remove(list.size() - 1);

        return count;

    }

    public boolean isPalindrome(List<Character> list) {
        if (list.size() == 1) {
            return true;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        QuestionFirst task = new QuestionFirst();
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.print(Message.startInput);

            String start = userInput.nextLine();
            if (start.isEmpty()) {
                break;
            }

            System.out.println(Message.firstCase);
            List<Character> list = new ArrayList<>();
            while (true) {
                System.out.print(Message.userInstruction);

                String input = userInput.nextLine();

                if (input.isEmpty()) {
                    break;
                }

                if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                    list.add(Character.toLowerCase(input.charAt(0)));
                } else {
                    System.out.println(Message.error);
                }
            }

            CharTreeNode root = CharTreeNode.buildTree(list, 0);
            System.out.println(task.getPaliPathFinder(root));
            System.out.println(Message.separator);
        }

    }
}
