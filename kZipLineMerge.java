import java.util.Scanner;
class Node{
    String value;
    Node next;
    Node(String value){
        this.value = value;
    }
}
public class kZipLineMerge{
    // input list
    public static Node input(){
        Scanner userInput = new Scanner(System.in);
        Node head = new Node("");
        Node temp = head;
        System.out.println("Enter values for nodes. for end list null.");
        while(true){
            System.out.print("Enter value : ");
            String value = userInput.nextLine();
            if(value.equals("null")) break;
            Node temp1 = new Node(value);
            temp.next = temp1;
            temp = temp.next;
        }
        return head.next;
    }
    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static Node merge(Node head1, Node head2, int number){
        if(head1 == null) return head2;
        else if(head2 == null) return head1;
        Node temp1 = head1;
        Node temp2 = head2;
        int value;
        Node newNode = new Node("");
        Node result = newNode;
        while(temp1 != null && temp2 != null){
            value = number;
            while(value > 0 && temp1 != null){
                newNode.next = temp1;
                newNode = newNode.next;
                temp1 = temp1.next;
                value--;
            }
            value = number;
            while(value > 0 && temp2 != null){
                newNode.next = temp2;
                newNode = newNode.next;
                temp2 = temp2.next;
                value--;
            }
        }
        if(temp1 == null) newNode.next = temp2;
        else newNode.next = temp1;

        return result.next;
    }
    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter first list : ");
        Node a = input();
        System.out.println("Enter second list : ");
        Node b = input();
        print(a);
        print(b);
        System.out.print("Enter No. by which nodes are merging : ");
        int number = userInput.nextInt();
        Node result = merge(a, b, number);
        print(result);
    }
}