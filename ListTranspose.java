import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Node{
    int data;
    Node right;
    Node down;
    Node(int data){
        this.data=data;
    }
}
public class ListTranspose{
    static Set<Node> visited=new HashSet<>();
    public  Node transpose(Node head){
        if(head==null|| visited.contains(head)){
            return null;}
        visited.add(head);
        //Stored the original value in 2 nodes
        Node origRight=head.right;
        Node origDown=head.down;
        //we will swap
        head.right=origDown;
        head.down=origRight;
        transpose(origRight);
        transpose(origDown);
        return head;
    }
    public void print(Node head){
        Node row=head;
        while(row!=null){
            Node col=row;
            while(col!=null){
                System.out.println(col);
                col=col.right;
            }
            row=row.down;
        }
    }
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    Node n1=new Node(1);
    Node n2=new Node(2);
    Node n3=new Node(3);
    Node n4=new Node(4);
    Node n5=new Node(5);
    n1.right=n2;n2.right=n3;n3.right=null;
    n1.down=n4;n4.right=n5;n5.right=null;

    ListTranspose obj=new ListTranspose();
    obj.transpose(n1);
    obj.print(n1);
    }
}
