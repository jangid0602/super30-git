import java.util.Scanner;
public class cStringInterWaver{
    public static StringBuilder merge(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        StringBuilder sb = new StringBuilder();
        int i=0, j=0;
        while(i<m && j<n){
            sb.append(s1.charAt(i));
            i++;
            sb.append(s2.charAt(j));
            j++;
        }
        while(i<m){
            sb.append(s1.charAt(i));
            i++;
        }
        while(j<n){
            sb.append(s2.charAt(j));
            j++;
        }
        return sb;
    }
    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter first string : ");
        String s1 = userInput.nextLine();
        System.out.print("Enter second string : ");
        String s2 = userInput.nextLine();
        System.out.print("New string : " + merge(s1, s2));
    }
}