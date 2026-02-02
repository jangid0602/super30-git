import java.util.Scanner;

public class The_String_Tiling_Challenge {

    private String wordTiling(String s) throws Exception{
            if(s.isEmpty()){
                throw new Exception("Given data is Empty ");
            }
        return checkIt(0, s, "");
    }

        char temp = '_';
        int count = 0;
    String checkIt(int start, String s, String result) {
        if (start >= s.length()) {
            result = result+String.valueOf(count)+String.valueOf(temp);
            return result;
        }
        char ch = s.charAt(start);
        if (temp == '_') {
            temp = ch;
            count++;

        } else if (temp == ch) {
        count++;
        } else {
            result = result+String.valueOf(count)+String.valueOf(temp);
            temp = ch;
            count = 1;
        }
     return checkIt(start+1,s,result);
    }

    static void main() {
        The_String_Tiling_Challenge task = new The_String_Tiling_Challenge();
        Scanner userInput = new Scanner(System.in);
        while(true){
            try {
                System.out.print("\u001B[34mEnter only alphabetic word (-1 exit ) :- ");
                String word = userInput.nextLine();
                if(word.equals(-1)) break;

                boolean check = false;
                for (int i = 0; i < word.length() && !check; i++) {
                    if(!Character.isAlphabetic(word.charAt(i))){
                        if(word.charAt(i) == ' '){
                            System.out.println("\u001B[31mNO space between alphabet ");
                        }
                        else {
                            System.out.println("\u001B[31mOnly alphabet ");
                        }
                        check = true;
                    }
                }
                if(!check) {
                    System.out.println("\u001B[35m Result :- "+task.wordTiling(word));
                }
            } catch (Exception e) {
                System.out.println("\u001B[31m"+e.getMessage());
            }
        }
    }
}
