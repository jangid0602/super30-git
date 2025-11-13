import java.util.*;
public class OperationsMenu {

    class point {
        
        private double x;
        private double y;

        public point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distance(point other) {
             double dx = this.x - other.x;
             double dy = this.y - other.y;
             return Math.sqrt(dx * dx + dy * dy);
        }  
        public void translate(double dx, double dy) {
            this.x += dx;
            this.y += dy;
        }
        public String toString() {
            return "(" + this.x + "," + this.y + ")";
        }
      }

    abstract class Shape {
        abstract double getArea();
      }

    class Circle extends Shape {
        private double radius;

        Circle (double radius) {
            this.radius = radius;
        } 
        @Override
        double getArea() {
            return Math.PI * radius * radius;
        }
      }
      
    class Square extends Shape {
        private double side;

        Square(double side) {
            this.side = side;
        }
        double getArea() {
            return side * side;
        }
    }

    public int TravelerEnergyCostCalculate() {
        Scanner UserInput = new Scanner(System.in);
        try{
        System.out.print("Enter total cities: ");    
        int size = UserInput.nextInt();

        int nums[] = new int[size];

        System.out.print("Enter cost: ");
        int initialEnergy = UserInput.nextInt();

        System.out.print("Enter the all citites cost: ");
        for(int i=0; i<size; i++) {
             nums[i] = UserInput.nextInt();
        }

          for(int i=0; i<size; i++) {
            initialEnergy -= nums[i];
            if(initialEnergy < 0) {
                return i;
            }
          }
          return size -1;
        }catch(Exception e){
            System.out.println("Your input was wrong");
            System.exit(0);
        }
        return -1;
    }

    public int findpivot() {

        Scanner UserInput = new Scanner(System.in);
        try{
        System.out.print("Enter the size of array: ");
        int size = UserInput.nextInt();

        System.out.println("Enter element of the array: ");
        int [] nums = new int[size];
        for(int i=0; i<size; i++) {
           nums[i] = UserInput.nextInt();
        }

        int rightsum = 0, leftsum = 0;
        for(int i=0; i<nums.length; i++) {
            rightsum += nums[i];
        }

        for(int i=0; i<nums.length; i++) {
            
        rightsum -= nums[i];

        if(leftsum == rightsum) {
            return i;
        }
        leftsum += nums[i];     
        }   
        return -1;
        }catch(Exception e){
            System.out.println("Your input was wrong");
            System.exit(0);
        }
        return -1;
     }

     public int flipnums() {
        Scanner UserInput = new Scanner(System.in);
        try{
         System.out.print("Enter the size of array: ");
        int size = UserInput.nextInt();

        System.out.println("Enter element of the array: ");
        int [] nums = new int[size];

        for(int i=0; i<size; i++) {
           nums[i] = UserInput.nextInt();
        }

        int count0s = 0;
        int count1s = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                count0s++;
            } else {
                count1s++;
            }
        }
            if(count0s < count1s) {
                System.out.print(count0s);
            } else {
                System.out.print(count1s);
            }
        }catch(Exception e){
            System.out.println("input is taken only 0 or 1");
            System.exit(0);
        }
        return -1;
     }

     public int findSingle() {
      Scanner UserInput = new Scanner(System.in);
      try{
         System.out.print("Enter the size of array: ");
        int size = UserInput.nextInt();

        System.out.println("Enter element of the array: ");
        int [] nums = new int[size];

        for(int i=0; i<size; i++) {
           nums[i] = UserInput.nextInt();
        }

        int result = 0;
        for(int i = 0; i <nums.length; i++ ) {
            result ^= nums[i];
        }
        return result;
      }catch(Exception e){
          System.out.println("Your input was wrong");
          System.exit(0);
      }
      return -1;
     }

     public boolean PairFinder() {
        Scanner UserInput = new Scanner(System.in);
        try{
         System.out.print("Enter the size of array: ");
        int size = UserInput.nextInt();

        System.out.println("what's your target number: ");
        int target  = UserInput.nextInt();

        System.out.println("Enter element of the array: ");
        int [] nums = new int[size];

        for(int i=0; i<size; i++) {
           nums[i] = UserInput.nextInt();
        }

        for(int i = 0; i<nums.length - 1; i++) {
            if(nums[i] + nums[i+1] == target) {
                return true;
            }
        }
        return false;
        }catch(Exception e){
            System.out.println("Your input was wrong");
            System.exit(0);
        }
        return false;
     }

     public int MinTime() {

       Scanner UserInput = new Scanner(System.in);
       try{
        System.out.print("Enter the size of wall: ");
        int size = UserInput.nextInt();
        
        System.out.println("Enter numbers of walls: ");
        int time[] = new int[size];
        for(int i=0; i<time.length; i++) {
            time[i] = UserInput.nextInt();
        }

        int max = Integer.MIN_VALUE; 
        for(int i=0; i<time.length; i++) {
            if(max < time[i]) {
               max =  time[i];
            }
        }

        int sum = 0;

        for(int i=0; i<time.length; i++) {
            sum += time[i];
        }
        int result  = sum - max;

        return result;
       }catch(Exception e){
            System.out.println("Your input was wrong");
            System.exit(0);
        }
        return -1;
     }

    public static void main(String[] args) {

        Scanner UserInput = new Scanner(System.in);
        OperationsMenu Menu = new OperationsMenu();
    
        while (true) {
            try{
                System.out.println("\n========= Operations Menu =========");
                System.out.println("1. The Efficient Traveler");
                System.out.println("2. The Sum That stands out");
                System.out.println("3. Flip the switch");
                System.out.println("4. The Odd One Out");
                System.out.println("5. Smart Pair Finder");
                System.out.println("6. The Minimalist Painter");
                System.out.println("7. The Geometry Hierarchy");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");

                int choice = UserInput.nextInt();
                UserInput.nextLine();

                switch (choice) {
                    case 1: 
                    System.out.println(Menu.TravelerEnergyCostCalculate());
                   break;

                   case 2:
                    System.out.println(Menu.findpivot());  
                    break;

                    case 3:
                    Menu.flipnums();
                    break;

                    case 4:
                    System.out.println(Menu.findSingle());
                    break;

                    case 5:
                    System.out.println(Menu.PairFinder());
                    break;

                    case 6:
                    System.out.println(Menu.MinTime());
                    break;

                    case 7:
                    System.out.print("Enter Points x1 and y1: ");
                    double x1 = UserInput.nextDouble();
                    double y1 = UserInput.nextDouble();
                    System.out.print("Enter Points x2 and y2: ");
                    double x2 = UserInput.nextDouble();
                    double y2 = UserInput.nextDouble();

                    point p1 = Menu.new point(x1, y1);
                    point p2 = Menu.new point(x2, y2);

                    double dist = p1.distance(p2);
                    System.out.println("Distance: " + String.format("%.1f", dist));

                    System.out.print("Enter the radius of circle: ");
                    double radius = UserInput.nextDouble();
                    System.out.print("Enter side of Square: ");
                    double side = UserInput.nextDouble();

                    Circle c = Menu.new Circle(radius);
                    Square s = Menu.new Square(side);

                    System.out.println("Circle Area: " + String.format("%.2f", c.getArea()));
                    System.out.println("Square Area: " + String.format("%.1f", s.getArea()));

                    System.out.print("Enter dx and dy to move point: ");
                    double dx = UserInput.nextDouble();
                    double dy = UserInput.nextDouble();

                    p1.translate(dx, dy);
                    System.out.println("Translated Point1: " + p1);
                    break;

                    case 8:
                    System.exit(0);
                    break;

                    default:
                    System.out.println("Your input was wrong");
                    break;
                }
            }catch(Exception e){
                System.out.println("Your input was wrong");
                System.exit(0);
            }
    }
}
}

