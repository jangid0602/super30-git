package Codeup.Story_3;

import CRT.A;
import Codeup.Oops_task.Task_1_ParkingSystem.Input;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Task_1 {
     static class AverageStack{
        static List<Integer>list = new ArrayList<>();

        //empty check
         public static boolean isEmpty(){
             return list.size() == 0;
         }

        //push
        public static void push(int data){
            list.add(data);
            System.out.println("Null");
        }

        //pop
        public static int pop(){
             if(isEmpty()){
                 return -1;
             }

//            int top = list.size()-1;
            return list.remove(list.size()-1);
//            return top;
        }

        //peek or top
        public static int peek(){

             if(isEmpty()){
                 return -1;
             }

            return list.get(list.size()-1);
        }

        //Average
         public static double getAverage(){
             if (isEmpty()){
                 return -1;
             }

             double sum = 0;
             for (double num : list){
                 sum += num;
             }
             return sum/list.size();
         }
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       AverageStack obj = new AverageStack();
        System.out.println("""
                ========Choose Operations========
                        1.push
                        2.pop
                        3.peek
                        4.getAverage
                        5.exit
                """);
        while (true){
            String input = sc.next();
            if (input.equals("push")){
                System.out.println("Enter element you want to push: ");
                int n = sc.nextInt();
                AverageStack.push(n);
            }

            else if(input.equals("pop")){
                System.out.println(AverageStack.pop() + " " + "Is pop out of the stack.");
            }

            else if(input.equals("peek")){
                System.out.println(AverageStack.peek() + " " + "Is the peek element of the stack.");
            }

            else if(input.equals("getAverage")){
                System.out.println(AverageStack.getAverage() + " " + "Is the average of the stack elements.");
            }

            else if(input.equals("exit")){
                break;
            }

            else {
                System.out.println("Not a valid input.");
            }
        }

    }
}
