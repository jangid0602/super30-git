package Story_4;

import java.util.*;

class Person {
    int wealth;
    List<Person> children = new ArrayList<>();

    Person(int wealth) {
        this.wealth = wealth;
    }
}

public class Task_3 {

    public static int calculateLegacy(Person person) {
        int sum = person.wealth;
        for (Person child : person.children) {
            sum += child.wealth;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter root wealth: ");
        int rootWealth = sc.nextInt();
        Person root = new Person(rootWealth);

        System.out.print("Enter number of children: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter child wealth: ");
            root.children.add(new Person(sc.nextInt()));
        }

        System.out.println(calculateLegacy(root));
    }
}
