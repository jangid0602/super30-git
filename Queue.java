import java.util.ArrayList;
import java.util.Scanner;
public class Queue{
    ArrayList<Integer> list = new ArrayList<>();
    int size;
    void sizeSetter(int val){
        size = val;
    }
    void enqueue(int value){
        if(list.size() < size){
            list.add(value);
        }
        else{
            list.removeFirst();
            list.add(value);
        }
    }
    void process(int value){
        for(int i=0; i<value; i++){
            System.out.print(list.get(0) + " ");
            list.removeFirst();
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter size of queue : ");
        Queue qu = new Queue();
        int size = userInput.nextInt();
        qu.sizeSetter(size);
        int value;
        String text = """
                        0. No operation.
                        1. Add element.
                        2. process.
                        """;
        System.out.println(text);
        while(true){
            System.out.print("Enter operation : ");
            int operation = userInput.nextInt();
            switch(operation){
                case 0: return;
                case 1: System.out.print("Enter value : ");
                        value = userInput.nextInt();
                        qu.enqueue(value);
                        break;
                case 2: System.out.print("No. of element to print : ");
                        value = userInput.nextInt();
                        qu.process(value);
                        break;
                default:System.out.println("Invalid Operation!");
                        break;
            }
        }
    }
}