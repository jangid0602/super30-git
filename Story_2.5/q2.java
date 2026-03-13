//Aim of Question 2 is to create a simple digital library using classes and search books using exact and partial matching.
class book {
    String name;

    book(String n) {
        name = n;
    }
}

class q2 {

    book arr[] = new book[10];
    int c = 0;

    void addbook(String s) {
        arr[c] = new book(s);
        c++;
    }

    void searchbook(String word, int mode) {

        for (int i = 0; i < c; i++) {

            if (mode == 1) {
                if (arr[i].name.equals(word)) {
                    System.out.println(arr[i].name);
                }
            } else {
                if (arr[i].name.contains(word)) {
                    System.out.println(arr[i].name);
                }
            }
        }
    }

    public static void main(String[] args) {

        q2 ob = new q2();

        ob.addbook("War");
        ob.addbook("Data");
        ob.addbook("Database");

        ob.searchbook("War", 1);
        ob.searchbook("Data", 2);
    }
}
