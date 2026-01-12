import java.util.*;

public class Program{
    static int[] prefix;
    public int cosmiccourier(int result[]) {
        int count=0;
        int largest=Integer.MIN_VALUE;
        int seclargest=Integer.MIN_VALUE;
        for(int times:result){
            if(times>largest){
                seclargest=largest;
                largest=times;
            }
            else if(times==largest){
                count++;
            }
            else if(times>seclargest && times<largest){
                seclargest=times;
            }
        }
        if(count!=0){
            return largest;
        }
        return seclargest;
    }

    static class Library {
        String[] books = new String[100];
        int count = 0;

        void addBook(String title) {
            books[count++] = title;
        }

        void searchExact(String title) {
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (equalsStr(books[i], title)) {
                    System.out.println("Book(\"" + books[i] + "\")");
                    found = true;
                }
            }
            if (!found) System.out.println("[]");
        }

        void searchPartial(String title) {
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (containsStr(books[i], title)) {
                    System.out.println("Book(\"" + books[i] + "\")");
                    found = true;
                }
            }
            if (!found) System.out.println("[]");
        }

        boolean equalsStr(String a, String b) {
            if (a.length() != b.length()) return false;
            for (int i = 0; i < a.length(); i++)
                if (a.charAt(i) != b.charAt(i)) return false;
            return true;
        }

        boolean containsStr(String a, String b) {
            for (int i = 0; i <= a.length() - b.length(); i++) {
                int j = 0;
                while (j < b.length() && a.charAt(i + j) == b.charAt(j)) j++;
                if (j == b.length()) return true;
            }
            return false;
        }
    }

    public String[] factoryfloor(int arr[]) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 15 == 0) result[i] = "Hazardous";
            else if (arr[i] % 3 == 0) result[i] = "Heavy";
            else if (arr[i] % 5 == 0) result[i] = "Fragile";
            else result[i] = String.valueOf(arr[i]);
        }
        return result;
    }

    public char findExtra(String original, String result) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < original.length(); i++) {
            char ch = original.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < result.length(); i++) {
            char ch = result.charAt(i);
            if (!map.containsKey(ch)) return ch;
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) < 0) return ch;
        }
        return ' ';
    }

    static class Employee {
        protected double baseSalary;
        Employee(double baseSalary) { this.baseSalary = baseSalary; }
        double Bonus() { return 0.10 * baseSalary; }
    }

    static class Manager extends Employee {
        Manager(double baseSalary) { super(baseSalary); }
        double Bonus() { return 0.25 * baseSalary + 5000; }
    }

    static class Executive extends Manager {
        Executive(double baseSalary) { super(baseSalary); }
        double Bonus() { return 0.50 * baseSalary + 10000; }
    }

    public double totalBonus(Employee[] emp) {
        double sum = 0;
        for (int i = 0; i < emp.length; i++)
            sum += emp[i].Bonus();
        return sum;
    }
        public static int[] prefixsum(int[] arr){
        int n=arr.length;
         prefix=new int[n];
        if(n>0){
            prefix[0]=arr[0]; 
            for(int i=1;i<arr.length;i++){
                prefix[i]=prefix[i-1]+arr[i];
            }
        }
        return prefix;
    }
        public  int login(int i,int j){
        if(i<0 || j>prefix.length) return 0;
        return prefix[j]-prefix[i-1]; 
    }

    public String ticketplat(String[][] bookings) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < bookings.length; i++) {
            int seat = Integer.parseInt(bookings[i][1]);
            if (hs.contains(seat)) return bookings[i][0];
            hs.add(seat);
        }
        return "-1";
    }

    public int maxTemp(int arr[]) {
        if (arr.length == 0) return 0;
        int max = arr[0], count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Program m = new Program();
        Library lib = new Library();

        while (true) {
            try {
                System.out.println("-----Program -----");
                System.out.println("1 Cosmic Courier");
                System.out.println("2 Digital Library");
                System.out.println("3 Factory Floor");
                System.out.println("4 Spy Cipher");
                System.out.println("5 Corporate Bonus");
                System.out.println("6 Security Log");
                System.out.println("7 Concert Seat");
                System.out.println("8 Weather Station");
                System.out.println("9 Exit");
                System.out.print("Select number from 1 to 9: ");

                int ch = sc.nextInt();

                if (ch < 1 || ch > 9) {
                    System.out.println("Please enter a number between 1 and 9");
                    continue;
                }

                switch (ch) {

                    case 1:
                        System.out.print("Enter size of array: ");
                        int n1 = sc.nextInt();
                        int[] t = new int[n1];
                        System.out.print("Enter elements: ");
                        for (int i = 0; i < n1; i++) t[i] = sc.nextInt();
                        System.out.println(m.cosmiccourier(t));
                        break;

                    case 2:
                        sc.nextLine();
                        System.out.print("How many books to add: ");
                        int nb = sc.nextInt();
                        sc.nextLine();
                        for (int i = 0; i < nb; i++) {
                            String title = sc.nextLine();
                            lib.addBook(title);
                        }
                        System.out.print("Enter search title: ");
                        String search = sc.nextLine();
                        lib.searchPartial(search);
                        break;

                    case 3:
                        System.out.print("Enter size of array: ");
                        int n3 = sc.nextInt();
                        int[] a = new int[n3];
                        System.out.print("Enter elements: ");
                        for (int i = 0; i < n3; i++) a[i] = sc.nextInt();
                        String[] r = m.factoryfloor(a);
                        for (int i = 0; i < r.length; i++) System.out.print(r[i] + " ");
                        System.out.println();
                        break;

                    case 4:
                        sc.nextLine();
                        System.out.print("Enter original string: ");
                        String o = sc.nextLine();
                        System.out.print("Enter result string: ");
                        String s = sc.nextLine();
                        System.out.println(m.findExtra(o, s));
                        break;

                    case 5:
                        System.out.print("Enter number of employees: ");
                        int c = sc.nextInt();
                        Employee[] emp = new Employee[c];
                        for (int i = 0; i < c; i++) {
                            System.out.print("Enter type (1-Employee,2-Manager,3-Executive): ");
                            int type = sc.nextInt();
                            System.out.print("Enter base salary: ");
                            double sal = sc.nextDouble();
                            if (type == 1) emp[i] = new Employee(sal);
                            else if (type == 2) emp[i] = new Manager(sal);
                            else emp[i] = new Executive(sal);
                        }
                        System.out.println(m.totalBonus(emp));
                        break;

                    case 6:
                        System.out.print("Enter size of login array: ");
                        int n6 = sc.nextInt();
                        int[] log = new int[n6];
                        System.out.print("Enter elements: ");
                        for (int i = 0; i < n6; i++) log[i] = sc.nextInt();
                        System.out.print("Enter i and j: ");
                        int i = sc.nextInt();
                        int j = sc.nextInt();
                        prefixsum(log);
                        System.out.println(m.login( i, j));
                        break;

                    case 7:
                        System.out.print("Enter number of bookings: ");
                        int n7 = sc.nextInt();
                        String[][] b = new String[n7][2];
                        for (int k = 0; k < n7; k++) {
                            b[k][0] = sc.next();
                            b[k][1] = sc.next();
                        }
                        System.out.println(m.ticketplat(b));
                        break;

                    case 8:
                        System.out.print("Enter size of temperature array: ");
                        int n8 = sc.nextInt();
                        int[] temp = new int[n8];
                        System.out.print("Enter elements: ");
                        for (int i2 = 0; i2 < n8; i2++) temp[i2] = sc.nextInt();
                        System.out.println(m.maxTemp(temp));
                        break;

                    case 9:
                        return;
                }

            } catch (Exception e) {
                System.out.println("Invalid Input");
                sc.nextLine();
            }
        }
    }
}
