import java.util.Scanner;
class Node{
    String value;
    int count;
    Node next;
    Node(String value, int count){
        this.value = value;
        this.count = count;
    }
}
public class CollapsingCountList{
    // input list
    public static Node input(){
        Scanner userInput = new Scanner(System.in);
        Node head = new Node("", 0);
        Node temp = head;
        System.out.println("Enter values for nodes. for end list null.");
        while(true){
            System.out.print("Enter value : ");
            String value = userInput.nextLine();
            if(value.equals("null")) break;
            System.out.print("Enter count : ");
            int count = userInput.nextInt();
            Node temp1 = new Node(value, count);
            temp.next = temp1;
            temp = temp.next;
            userInput.nextLine();
        }
        return head.next;
    }
    public static void collapse(Node head){
        Node temp = head;
        while(temp.next != null){
            if(temp.value.equals(temp.next.value)){
                temp.count += temp.next.count;
                temp.next = temp.next.next;
            }
            else temp = temp.next;
        }
    }
    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print("("+temp.value+", "+temp.count + ")  ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        Node a = input();
        System.out.print("Original list : ");
        print(a);
        collapse(a);
        System.out.print("List after collapsed : ");
        print(a);
    }
}