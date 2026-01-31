import java.util.Scanner;

class SecureVault {

    public void possibleCodes(StringBuilder codes, int index) {
        if (index >= codes.length()) {
            System.out.print(codes + " ");
            return;
        }

        for (int i = index; i < codes.length(); i++) {
            // swap
            char temp = codes.charAt(index);
            codes.setCharAt(index, codes.charAt(i));
            codes.setCharAt(i, temp);

            possibleCodes(codes, index + 1);

            // backtrack (swap back)
            temp = codes.charAt(index);
            codes.setCharAt(index, codes.charAt(i));
            codes.setCharAt(i, temp);
        }
    }

    public void secureVault() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter code string: ");
        String input = sc.nextLine();

        StringBuilder codes = new StringBuilder(input);
        possibleCodes(codes, 0);
        System.out.println();
    }
}

class TestSecureVault {
    public static void main(String[] args) {
        SecureVault vault = new SecureVault();
        vault.secureVault();
    }
}

