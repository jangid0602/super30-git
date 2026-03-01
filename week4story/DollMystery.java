package week4story;

public class DollMystery {

    /**
     * Finds the key inside nested dolls using recursion.
     *
     * @param doll The outermost doll from where the search starts
     */
    public static void findKey(Doll doll) {

        // Base case: no doll left to open
        if (doll == null) {
            System.out.println("Key not found!");
            return;
        }

        // Base case: current doll contains the key
        if (doll.hasKey) {
            System.out.println("Key Found!");
            return;
        }

        // Recursive case: open the inner doll
        findKey(doll.innerDoll);
    }

    public static void main(String[] args) {

        Doll d1 = new Doll(1, true, null);
        Doll d2 = new Doll(2, false, d1);
        Doll d3 = new Doll(3, false, d2);
        Doll d4 = new Doll(4, false, d3);
        Doll d5 = new Doll(5, false, d4);

        findKey(d5);
    }
}

/**
 * This class represents a single doll.
 * Each doll may contain a key and another inner doll.
 */
class Doll {

    int size;
    boolean hasKey;
    Doll innerDoll;

    /**
     * Constructs a Doll object.
     *
     * @param size      Size of the doll
     * @param hasKey    Indicates whether the doll contains the key
     * @param innerDoll Reference to the inner doll
     */
    Doll(int size, boolean hasKey, Doll innerDoll) {
        this.size = size;
        this.hasKey = hasKey;
        this.innerDoll = innerDoll;
    }
}

