import java.util.ArrayList;
import java.util.Scanner;
class Stack{
    int size = 0;
    int total = 0;
    ArrayList<Integer> list = new ArrayList<>();
    void push(int data){
        list.add(data);
        total += data;
        size++;
    }
    int pop() throws Exception{
        if(size == 0){
            throw new Exception();
        }
        int value = list.get(size-1);
        total -= value;
        list.remove(size-1);
        size--;
        return value;
    }
    int top() throws Exception{
        if(size == 0){
            throw new Exception();
        }
        return list.get(size-1);
    }
    double average() throws Exception{
        if(size == 0){
            throw new Exception();
        }
        return (double)total/size;
    }

}
public class AverageStack{
    public static void main(String args[]) throws Exception{
        Scanner userInput = new Scanner(System.in);
        Stack stack = new Stack();
        String text = """
                        0. Not perform any operation.
                        1. Insert Data.
                        2. Remove Element.
                        3. Top Element.
                        4. Average of the stack.
                        """;
        System.out.println(text);
        try{
            while(true){
                System.out.print("Enter operation : ");
                int ask = userInput.nextInt();
                switch(ask){
                    case 0: return;
                    case 1: System.out.print("Enter value : ");
                            int value = userInput.nextInt();
                            stack.push(value);
                            System.out.println();
                            break;
                    case 2: System.out.println(stack.pop() + " is removed from stack.");
                            System.out.println();
                            break;
                    case 3: System.out.println(stack.top() + " is top of the stack.");
                            System.out.println();
                            break;
                    case 4: System.out.println(stack.average() + " is average of the stack.");
                            System.out.println();
                            break;
                    default : System.out.println("Invalid operation");
                }
            }
        }
        catch(Exception e){
            System.out.println("Stack is empty!");
        }
    }
}