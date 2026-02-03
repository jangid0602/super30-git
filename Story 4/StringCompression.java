import java.util.Scanner;
public class StringCompression{
    public static String compression(StringBuilder string1, String string, int ind, int count){
        if(ind == string.length()){
            string1.append(count);
            string1.append(string.charAt(ind-1));
            return new String(string1);
        }
        if(string.charAt(ind) == string.charAt(ind-1)){
            count += 1;
        }
        else{
            string1.append(count);
            string1.append(string.charAt(ind-1));
            count = 1;
        }
        return compression(string1, string, ind+1, count);
    }
    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter string : ");
        String string = userInput.nextLine();
        StringBuilder string1 = new StringBuilder("");
        String newString = compression(string1 , string, 1, 1);
        System.out.print("Compressed string : " + newString);
    }
}