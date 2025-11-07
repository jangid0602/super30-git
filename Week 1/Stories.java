/*
 * This is the Stories class which contain the definition to all the functions called inside the Main class as follows:
 * 
 * 1. farthestCity: Determine the farthest city index you can reach (0-based index) before running out of energy.
 * 2. sumComparison: Find the first index where the prefix sum equals the suffix sum (excluding that element).
 * 3. flipSwitch: Find the minimum number of flips required to make all elements equal.
 * 4. oddOneOut: Given an array where every element appears except one, find the single element.
 * 5. pairFinder: Given nums and a target k, check if there exists a pair (i,j) such that nums[i] + nums[j] == k.
 * 6. minTime: You are painting n walls, each taking time[i] minutes. You can skip one wall to minimize total painting time. Find the minimum total time after skipping one wall.
 * 
 * Owner: Ayush Joshi
 * Last Updated: 06/11/2025
 */
public class Stories {

    // 1. Returns the farthest city before running out of energy.

    public int farthestCity(int num[], int initialEnergy) {
        for (int index = 0; index < num.length; index++) {
            initialEnergy = initialEnergy - num[index];
            if (initialEnergy <= 0) {
                return index;
            }
        }
        return num.length;
    }

    // 2. Returns the Pivot element for which the sum of prefix is equal to the sum
    // of suffix.

    public int sumComparison(int arr[]) {
        int prefix = 0;
        int suffix;
        int totalSum = 0;
        for (int index = 0; index < arr.length; index++) {
            totalSum = totalSum + arr[index];
        }
        for (int index = 1; index < arr.length; index++) {
            prefix = prefix + arr[index - 1];
            suffix = totalSum - prefix - arr[index];
            if (prefix == suffix) {
                return index;
            }
        }
        return -1;
    }

    // 3. Returns the minimum number of flips required to make all the elements
    // equal (either 0's or 1's).

    public int flipSwitch(int arr[]) {
        int count1 = 0;
        int count0 = 0;
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == 0) {
                count0 += 1;
            } else {
                count1 += 1;
            }
        }
        return count1 > count0 ? count0 : count1;
    }

    // 4. Returns the elements that appears only once in the array.

    public int oddOneOut(int arr[]) {
        int sum = 0;
        for (int index = 0; index < arr.length; index++) {
            sum = sum ^ arr[index];
        }
        return sum;
    }

    // 5. Returns true/false based on whether a pair whose sum is equal to the
    // desired element is found or not inside the array.

    boolean pairFinder(int k, int arr[]) {
        for (int index = 0; index < arr.length; index++) {
            for (int indx = index + 1; indx < arr.length; indx++) {
                if ((arr[index] + arr[indx]) == k) {
                    return true;
                }
            }
        }
        return false;
    }

    // 6. Returns minimum total time required to paint all the walls after skipping
    // any one wall.

    public int minTime(int time[]) {
        int greatest = time[0];
        int totalTime = 0;
        for (int index = 0; index < time.length; index++) {
            if (greatest < time[index]) {
                greatest = time[index];
            }
            totalTime = totalTime + time[index];
        }
        totalTime = totalTime - greatest;

        return totalTime;
    }

    // 7. Runs the Geometry hierarchy story

    public String runGeometryStory(float x1, float y1, float x2, float y2, double radius, double side, float dx, float dy) {
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        double dist = p1.distance(p2);

        Shape circle = new Circle(radius);
        Shape square = new Square(side);

        double circleArea = circle.getArea();
        double squareArea = square.getArea();

        p1.translate(dx, dy);

        String nl = System.lineSeparator(); // For cross-platform new lines
        return "Distance: " + String.format("%.1f", dist) + nl +
                "Circle Area: " + String.format("%.2f", circleArea) + nl +
                "Square Area: " + String.format("%.1f", squareArea) + nl +
                "Translated Point1: " + p1.toString();
    }

    static class Point {
        private float x;
        private float y;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public double distance(Point other) {
            double dx = this.x - other.x;
            double dy = this.y - other.y;
            return Math.sqrt(dx * dx + dy * dy);
        }

        public void translate(float dx, float dy) {
            this.x += dx;
            this.y += dy;
        }

        @Override
        public String toString() {
            return "(" + String.format("%.1f", this.x) + ", " + String.format("%.1f", this.y) + ")";
        }
    }

    static abstract class Shape {
        public abstract double getArea();
    }

    static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * this.radius * this.radius;
        }
    }

    static class Square extends Shape {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double getArea() {
            return this.side * this.side;
        }
    }

}