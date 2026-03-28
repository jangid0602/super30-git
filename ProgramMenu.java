package Story2_5;

import java.util.*;

public class ProgramMenu{
    // Courier challenge
    public int Courier(int array[]){
        int size = array.length;
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        for(int i=0; i<size; i++){
            if(array[i] > max) max = array[i];
        }
        boolean flag = true;
        for(int i=0; i<size; i++){
            if(array[i] > smax && array[i] != max){
                smax = array[i];
                flag = false;
            }
        }
        if(flag) return max;
        else return smax;
    }

    // Digital Library Systems
    class Book{
        String name;
        static List<String> books = new ArrayList<>();
        Book(){};
        Book(String name){
            this.name = name;
            books.add(name);
        }
        public List<String> search(String name){
            List<String> result = new ArrayList<>();
            for(String book_name : books){
                if(book_name.contains(name)) result.add(book_name);
            }
            return result;
        }
    }
    public void Library(){
        Scanner userInput = new Scanner(System.in);
        Book book = new Book();
        while(true){
            System.out.print("Want to add book ? [1/0] ");
            int ask = userInput.nextInt();
            userInput.nextLine();
            if(ask == 0) break;
            System.out.print("Enter book name : ");
            String name = userInput.nextLine();
            Book b1 = new Book(name);
        }
        System.out.print("Enter book name which is to be search : ");
        String search = userInput.nextLine();
        System.out.println("Books are : " + book.search(search));
        System.out.println();
    }

    // Factory Floor Robot
    public String[] FactoryRobot(int array[]){
        int size = array.length;
        String labels[] = new String[size];
        for(int i=0; i<size; i++){
            if(array[i] % 15 == 0) labels[i] = "Hazardous";
            else if(array[i] % 3 == 0) labels[i] = "Heavy";
            else if(array[i] % 5 == 0) labels[i] = "Fragile";
            else labels[i] = "" + array[i];
        }
        return labels;
    }

    // Spy's Cipher
    public char SpyCipher(String string1, String string2){
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i=0; i<string1.length(); i++){
            char ch = string1.charAt(i);
            if(freq.containsKey(ch)) freq.put(ch, freq.get(ch)+1);
            else freq.put(ch, 1);
        }
        for(int i=0; i<string2.length(); i++){
            char ch = string2.charAt(i);
            if(freq.containsKey(ch)) freq.put(ch, freq.get(ch)+1);
            else freq.put(ch, 1);
        }
        for(var i : freq.entrySet()){
            if(i.getValue()%2 != 0) return i.getKey();
        }
        return '\0';
    }

    // Corporate Hierarchy System.
    class Employee{
        int id;
        String name;
        protected float baseSalary;
        Employee(float baseSalary){
            this.baseSalary = baseSalary;
        }
        float bonus(){
            return (this.baseSalary*10)/100;
        }
    }
    class Manager extends Employee{
        Manager(float baseSalary){
            super(baseSalary);
        }
        float bonus(){
            return (this.baseSalary*25)/100 + 5000;
        }
    }
    class Executive extends Manager{
        Executive(float baseSalary){
            super(baseSalary);
        }
        float bonus(){
            return (this.baseSalary*50)/100 + 10000;
        }
    }
    public float CompanyBonus(Employee employee[]){
        float sum = 0;
        for(int i=0; i<employee.length; i++){
            sum += employee[i].bonus();
        }
        return sum;
    }

    // Security Log Analyzer
    public void SecurityLogAnalyzer(int array[]){
        Scanner userInput = new Scanner(System.in);
        int size = array.length;
        for(int i=1; i<size; i++){
            array[i] += array[i-1];
        }
        // queries
        // to ask query.
        while(true){
            System.out.print("Want to ask query[0/1] : ");
            int ask = userInput.nextInt();
            if(ask == 0) break;
            System.out.print("Starting index : ");
            int start = userInput.nextInt();
            System.out.print("ending index : ");
            int end = userInput.nextInt();
            if(start == 0) System.out.println("quries in this range : " + (array[end]));
            else System.out.println("quries in this range : " + (array[end]-array[start-1]));
        }
    }

    // Consert Seat Manager
    public String SeatManager(String seats[][]){
        int seat = seats.length;
        HashSet<String> SeatNumber = new HashSet<>();
        for(int i=0; i<seat; i++){
            if(SeatNumber.contains(seats[i][1])){
                return seats[i][0];
            }
            else SeatNumber.add(seats[i][1]);
        }
        return "-1";
    }

    // Weather Station
    public int HighTemprature(int[] Temp){
        int size = Temp.length;
        int count = 0;
        for(int i=1; i<size; i++){
            if(Temp[i] > Temp[0]) count++;
        }
        return count;
    }

    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        ProgramMenu object = new ProgramMenu();
        try{
            String text = """
                            0. If not perform any operation.
                            1. Courier challenge
                            2. Digital Library System.
                            3. Factory Floor Robot.
                            4. Spy's Cipher (Extra Character).
                            5. Corporate Hierarchy 
                            6. Security Log Analyzer.
                            7. Concer Seat Manager.
                            8. Weather Station.
                            """;
            System.out.println(text);
            while(true){
                System.out.print("Enter no. of operation : ");
                int operation = userInput.nextInt();
                int array[] = null;
                if(operation == 1 || operation == 3 || operation == 6 || operation == 8){
                    System.out.print("Enter a size of array : ");
                    int size = userInput.nextInt();
                    array = new int[size];
                    for(int i=0; i<size; i++){
                        System.out.print("Enter " + (i+1) + " element : ");
                        array[i] = userInput.nextInt();
                    }
                }
                if(operation == 0) return;
                switch(operation){
                    case 1 :System.out.println("New deadline : " + object.Courier(array));
                        break;
                    case 2 :object.Library();
                        break;
                    case 3 :String labels[] = object.FactoryRobot(array);
                        System.out.print("Labels : ");
                        for(int i=0; i<array.length; i++){
                            System.out.print(labels[i] + " ");
                        }
                        System.out.println();   // for next line.
                        System.out.println();   // for better readability.
                        break;
                    case 4 :System.out.print("Enter a String : ");
                        String string1 = userInput.nextLine();
                        userInput.nextLine();
                        System.out.print("Enter a Scramble String(with extra character) : ");
                        String string2 = userInput.nextLine();
                        System.out.println("Extra character : " + object.SpyCipher(string1, string2));
                        System.out.println();
                        break;
                    case 5 :System.out.print("Enter number of employees : ");
                        int size = userInput.nextInt();
                        Employee employee[] = new Employee[size];
                        for(int i=0; i<size; i++){
                            System.out.print("Enter employee type(1-Employee, 2-Manager, 3-Executive) : ");
                            int type = userInput.nextInt();
                            System.out.print("Enter base salary : ");
                            int salary = userInput.nextInt();
                            if(type == 1) employee[i] = object.new Employee(salary);
                            else if(type == 2) employee[i] = object.new Manager(salary);
                            else employee[i] = object.new Executive(salary);
                        }
                        System.out.println("Total Bonus : " + object.CompanyBonus(employee));
                        System.out.println();
                        break;
                    case 6 :object.SecurityLogAnalyzer(array);
                        break;
                    case 7 :System.out.print("Total no. of seats : ");
                        int seat = userInput.nextInt();
                        String seats[][] = new String[seat][2];
                        for(int i=0; i<seat; i++){
                            System.out.print("Customer ID : ");
                            seats[i][0] = userInput.next();
                            System.out.print("Seat number : ");
                            seats[i][1] = userInput.next();
                        }
                        System.out.println("Alloted Seat of customer : " + object.SeatManager(seats));
                        System.out.println();
                        break;
                    case 8 :System.out.println("There are " + object.HighTemprature(array) + " day higher Temprature than first day.");
                        break;
                    default :System.out.println("Enter Invalid Operation.");

                }
            }
        }
        catch(Exception e){
            System.out.print("Enter invalid input.");
        }
    }
}