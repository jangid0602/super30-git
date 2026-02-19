import java.awt.datatransfer.MimeTypeParameterList;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Stack{

    static class AverageStack{
        List<Integer> list= new ArrayList<>();
        //Checking whether the stack is empty or not
        public boolean isEmpty(){
            return list.size()==0;
        }
        //push operation
        public void push(int data){
            list.add(data);
        }
        //pop operation
        public int pop(int data){
            if(isEmpty()){
                return -1;
            }
            return list.remove(list.size()-1);
        }
        //top operation
        public int top(){
            return list.get(list.size()-1);
        }
        //average finder
        public long getAverage(){
            long avg=0;
            for(int i=list.size()-1;i>=0;i--){
               int element=list.get(i);
               avg+=element;
            }
            return avg/list.size();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        AverageStack obj=new AverageStack();
        System.out.println("Enter operations:(push,pop,top,getAverage,exit)");

        while(true){
            String input=sc.next();
            if(input.equals("push")){
                System.out.println("Enter the element to be pushed");
                try {
                    if (input.equals("push")) {
                        int n = sc.nextInt();
                        obj.push(n);
                        System.out.println("null");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter numbers only.");
                    sc.nextLine(); // Buffer clear karna zaroori hai
                }
            }
            else if(input.equals("pop")){
                System.out.println("Enter the element to be popped");
                int n=sc.nextInt();
                System.out.println(obj.pop(n));
            }
            else if(input.equals("top")){
                System.out.println(obj.top());
            }
            else if(input.equals("getAverage")){
                System.out.println(obj.getAverage());
            }
            else if(input.equals("exit")){
                break;
            }
            else{
                System.out.println("Not a valid choice");
            }
        }

    }
}

