import java.util.Scanner;

class Doll {
    int size;
    boolean hasKey;
    Doll innerDoll;

    Doll(int size, boolean hasKey, Doll innerDoll) {
        this.size = size;
        this.hasKey = hasKey;
        this.innerDoll = innerDoll;
    }
}

public class DollMystery {

    void findKey(Doll doll) {
        if (doll == null) {
            System.out.println("Key not found!");
            return;
        }

        if (doll.hasKey) {
            System.out.println("Key Found!");
            return;
        }

        findKey(doll.innerDoll);
    }

    public static void main(String[] args) {
        DollMystery task = new DollMystery();
        Scanner userInput = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter number of dolls (-1 to exit): ");
                int n = Integer.parseInt(userInput.nextLine());
                if (n == -1) break;

                System.out.print("Enter size of doll key: ");
                int keySize = Integer.parseInt(userInput.nextLine());

                if (keySize < 1 || keySize > n) {
                    System.out.println("Invalid key size, No doll exists.");
                    continue;
                }

                Doll current = null;
                for (int size = 1; size <= n; size++) {
                    boolean hasKey = (size == keySize);
                    current = new Doll(size, hasKey, current);
                }

                task.findKey(current);

            } catch (NumberFormatException e) {
                System.out.println("Enter valid numbers only.");
            }
        }
        System.out.println("Thank you 😁");
    }
}
