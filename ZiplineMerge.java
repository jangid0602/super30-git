import java.util.*;
public class ZiplineMerge{
    class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public Node Zipline(Node head1,Node head2,int k){
        if(head1==null) return head2;
        if(head2==null) return head1;
        Node curr1=head1;
        Node curr2=head2;
        while(curr1!=null && curr2!=null){
            Node temp1=curr1;
            Node temp2=curr2;
            for(int i=1;i<k&&temp1.next!=null;i++){
                temp1=temp1.next;
            }
            Node part1=temp1.next;
            for(int i=1;i<k&&temp2.next!=null;i++){
                temp2=temp2.next;
            }
            Node part2=temp2.next;
            temp1.next=curr2;
            temp2.next=part1;
            //Moving poiners to the next chunk
            curr1=part1;
            curr2=part2;
        }
        return head1;
    }
    public Node input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of nodes and if you want to stop then press -1");
        int data=sc.nextInt();
        Node head=null;
        Node tail=null;
        while(data!=-1){
            Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
            data=sc.nextInt();
        }
        return head;
    }
    public void print(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ZiplineMerge obj=new ZiplineMerge();
        System.out.println("Enter the element of first list:");
        Node n1=obj.input();
        System.out.println("Enter the element of second list");
        Node n2=obj.input();
        System.out.println("Enter the value of k");
        int k=sc.nextInt();
        Node result=obj.Zipline(n1,n2,k);
        obj.print(result);
    }
}
