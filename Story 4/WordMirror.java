import java.util.Scanner;
public class WordMirror{
    public static boolean check(String string, int front, int end){ // front and end are index.
        if(front >= end) return true;
        while(string.charAt(front) < 97 || string.charAt(front) > 122) front++;
        while(string.charAt(end) < 97 || string.charAt(end) > 122) end--;
        if(string.charAt(front) != string.charAt(end)) return false;
        return check(string, front+1, end-1);
    }
    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String string = userInput.nextLine();
        string = string.toLowerCase();
        System.out.print("is String Palindrome : " + check(string, 0, string.length()-1));
    }
}