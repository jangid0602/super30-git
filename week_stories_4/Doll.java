import java.util.Scanner;

class RussianDoll {

    public boolean russianDoll(int size) {
        if (size == 1) {
            return true;
        } 
        if (size < 1) {
            return false;
        }
        return russianDoll(size - 1);
    }
}

class Doll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = sc.nextInt();

        RussianDoll doll = new RussianDoll();

        if (doll.russianDoll(size))
            System.out.println("Key Found!");
        else
            System.out.println("Key Not Found!");
    }
}


