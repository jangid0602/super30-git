public class MenuDescription {
    
    // 1. 

    public int countUniquePalindromes(String str) {
        int n = str.length();
        String[] palindromes = new String[n * n];  // store found palindromes
        int count = 0;  // total palindromes found

        // Expand around all possible centers
        for (int center = 0; center < n; center++) {

            // Check odd-length palindromes
            int left = center, right = center;
            while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                int len = right - left + 1;
                if (len > 1) {
                    // manually extract substring
                    String temp = "";
                    for (int i = left; i <= right; i++) {
                        temp += str.charAt(i);
                    }
                    palindromes[count++] = temp;
                }
                left--;
                right++;
            }

            // Check even-length palindromes
            left = center;
            right = center + 1;
            while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                int len = right - left + 1;
                if (len > 1) {
                    String temp = "";
                    for (int i = left; i <= right; i++) {
                        temp += str.charAt(i);
                    }
                    palindromes[count++] = temp;
                }
                left--;
                right++;
            }
        }

        // Count unique palindromes manually (no HashSet)
        int unique = 0;
        for (int i = 0; i < count; i++) {
            boolean duplicate = false;
            for (int j = 0; j < i; j++) {
                String a = palindromes[i];
                String b = palindromes[j];

                // Compare manually
                if (a.length() == b.length()) {
                    boolean same = true;
                    for (int k = 0; k < a.length(); k++) {
                        if (a.charAt(k) != b.charAt(k)) {
                            same = false;
                            break;
                        }
                    }
                    if (same) {
                        duplicate = true;
                        break;
                    }
                }
            }
            if (!duplicate) {
                unique++;
            }
        }

        return unique;
    }

    // 2.

    public int fibonacci(int input){
        int fib = 0;
        int a = 0;
        int b = 1;
        if(input < 1){
            System.out.print("Invalid input !! ");
            return 0;
        }else if(input == 1){
            System.out.print("The 1st fibonacci element is: ");
            return 0;
        }else if(input == 2){
            System.out.print("The 2nd fibonacci element is: ");
            return 1;
        }
        for(int counter = 3; counter <= input; counter++){
            fib = a + b;
            a = b;
            b = fib;
        }
        System.out.print (input == 3 ? ("The " + input + "rd fibonacci element is: ") : ("The " + input + "th fibonacci element is: "));
        return fib;
    }

    // 3. 

    public String snakeToCamelCase(String input){
        String result = "";
        for(int index = 0; index < input.length();){
            if(input.charAt(index) == '_'){
                result = result + Character.toUpperCase(input.charAt(index + 1));
                index += 2;
            }else{
                result = result + Character.toLowerCase(input.charAt(index));
                index++;
            }
        }
        System.out.print("camelCase: ");
        return result;
    }

    // 4.

    public int countConsonant(String input){
        int count = input.length();
        for(int index = 0; index < input.length(); index++){
            if(input.charAt(index) == 'a' || input.charAt(index) == 'e' || input.charAt(index) == 'i' || input.charAt(index) == 'o' || input.charAt(index) == 'u'){
                count--;
            }
        }
        System.out.print("The number of consonants in the given string is: ");
        return count;
    }

    // 5.

    public int binaryToDecimal(int input){
        int decimalResult = 0;
        int count =0;
        for(int copyInput = input; copyInput != 0; copyInput = copyInput/10 ){
            int last = copyInput % 10;
            if(last == 1){
                decimalResult = decimalResult + power(count);
            }
            count++;
        }
        System.out.print("The decimal value of " + input + " will be: ");
        return decimalResult;
    }

    public int power(int count){
        int raisedNumber = 1;
        for(int i = 1; i <= count; i++){
            raisedNumber = raisedNumber*2;
        }
        return raisedNumber;
    }
}
