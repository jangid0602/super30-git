import java.util.*;

public class Stories{

    //Problem 1:The Cosmic Courier Challenge

    public int cosmicCourier(int routes[]){
        try{
            int max = Integer.MIN_VALUE;
            int secondMax = Integer.MIN_VALUE;
            int countMax = 0;

            for (int time : routes) {
                if (time > max) {
                    secondMax = max;
                    max = time;
                    countMax = 1;
                } else if (time == max) {
                    countMax++;
                } else if (time > secondMax) {
                    secondMax = time;
                }
            }

            if (countMax > 1) {
                return max;
            }

            return secondMax;
        }catch(Exception e){
            System.out.println("Error in Cosmic Courier");
            return -1;
        }    
    }

    //Problem 2:The Digital Library System

    static class Library {
        String[] books = new String[100];
        int count = 0;

        void addBook(String title) {
            if (count < books.length) {
                books[count++] = title;
            }
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

    //problem 3:The Factory Floor Robot

    public String[] itemsWeight(int[] weights) {
        String[] result = new String[weights.length];
        for (int i = 0; i < weights.length; i++) {
            int w = weights[i];
            if (w % 15 == 0) result[i] = "Hazardous";
            else if (w % 3 == 0) result[i] = "Heavy";
            else if (w % 5 == 0) result[i] = "Fragile";
            else result[i] = String.valueOf(w);
        }
        return result;
    }

    //problem 4:The Spy’s Cipher

    public char extraCharacter(String original, String scrambled){
        try{
            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < original.length(); i++) {
                char ch = original.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            for (int i = 0; i < scrambled.length(); i++) {
                char ch = scrambled.charAt(i);
                if (!map.containsKey(ch)) return ch;
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) < 0) return ch;
            }
            return ' ';
        }catch(Exception e){
            System.out.println("Error in extraCharacter");
            return '?';
        }    
    }

    //problem 5:The Corporate Hierarchy System

    static class Employee {
        protected double baseSalary;
        Employee(double baseSalary) { this.baseSalary = baseSalary; }
        double calculateBonus() { return 0.10 * baseSalary; }
    }

    static class Manager extends Employee {
        Manager(double baseSalary) { super(baseSalary); }
        double calculateBonus() { return 0.25 * baseSalary + 5000; }
    }

    static class Executive extends Manager {
        Executive(double baseSalary) { super(baseSalary); }
        double calculateBonus() { return 0.50 * baseSalary + 10000; }
    }

    public double totalBonus(Employee[] emp) {
        double sum = 0;
        for (int i = 0; i < emp.length; i++)
            sum += emp[i].calculateBonus();
        return sum;
    }

    //problem 6:The Security Log Analyzer

    public int rangeSum(int time[],int range[]){
        if (range[0] < 0 || range[1] >= time.length || range[0] > range[1])return -1;
        try{
            int sum = 0;
            for(int i = range[0]; i <= range[1]; i++){
                sum = sum + time[i];
            }
            return sum;
        }catch(Exception e){
            System.out.println("Error in rangeSum");
            return -1;
        }
    }

    //problem 7:The Concert Seat Manager 

    public String firstDuplicateSeat(String[][] bookings) {
        HashSet<Integer> bookedSeats = new HashSet<>();
        for (int i = 0; i < bookings.length; i++) {
            int seat = Integer.parseInt(bookings[i][1]);
            if (bookedSeats.contains(seat)) return bookings[i][0];
            bookedSeats.add(seat);
        }
        return "-1";
    }

    //problem 8:The Weather Station Data Aggregator 
    public int countMaxTempDays(int temp[]) {
        if (temp.length == 0) return 0;
        int max = temp[0], count = 1;
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] > max) {
                max = temp[i];
                count++;
            }
        }
        return count;
    }
}