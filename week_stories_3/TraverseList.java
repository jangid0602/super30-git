import java.util.*;

public class TraverseList {


    static void print(LinkedList<LinkedList<Integer>> list) {

        for(int i=0; i<list.size(); i++) { // list.size() = 2;
        LinkedList<Integer> row = list.get(i);
        for(int j=0; j<row.size(); j++) {
            System.out.print(row.get(j)+" ");
        }
        System.out.println();
    }
    }

    static LinkedList<LinkedList<Integer>> traverse 
    (LinkedList<LinkedList<Integer>> list) {
  
        int row = list.size();
        int col = list.get(0).size();

        LinkedList<LinkedList<Integer>> result = new LinkedList<>();

        for(int j = 0 ; j < col; j++) {
            LinkedList<Integer> newRow = new LinkedList<>();
            for(int i = 0; i < row; i++) {
                newRow.add(list.get(i).get(j));
            }
            result.add(newRow);
        }

        return result;
    }

    public static void main(String[] args) {
        
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();

        LinkedList<Integer> row1 = new LinkedList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);

        LinkedList<Integer> row2 = new LinkedList<>();
        row2.add(4);
        row2.add(5);
        row2.add(6);

        list.add(row1);
        list.add(row2);

        System.out.println("Original: ");
        
        print(list);

        list = traverse(list);

        System.out.println("Traverse: ");

        print(list);

    }
    
}
