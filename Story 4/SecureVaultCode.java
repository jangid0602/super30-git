import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class SecureVaultCode{
    public static void possibleCode(String code, int number, List<Integer> list){
        if(code.equals("")){
            list.add(number);
            return;
        }
        for(int i=0; i<code.length(); i++){
            int digit = code.charAt(i) - '0';
            String left = code.substring(0, i);
            String right = code.substring(i+1);
            String rem = left + right;
            possibleCode(rem, number*10 + digit, list);
        }
    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter code string : ");
        String code = userInput.nextLine();
        possibleCode(code, 0, list);
        System.out.print("Possible code is : " + list);
    }
}