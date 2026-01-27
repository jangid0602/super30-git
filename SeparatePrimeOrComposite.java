import java.util.Scanner;
class Node{
    int value;
    Node next;
    Node down;
    Node(int value){
        this.value = value;
    }
}
public class SeparatePrimeOrComposite{
    // input list
    public static Node input(){
        Scanner userInput = new Scanner(System.in);
        Node head = new Node(0);
        Node temp = head;
        System.out.println("Enter values for nodes. for end list -1.");
        while(true){
            System.out.print("Enter value : ");
            int value = userInput.nextInt();
            if(value < 0) break;
            Node temp1 = new Node(value);
            temp.next = temp1;
            temp = temp.next;
        }
        return head.next;
    }
    // check prime or not.
    public static boolean isPrime(int value){
        if(value < 2) return false;
        for(int i=2; i<=Math.sqrt(value); i++){
            if(value % i == 0) return false;
        }
        return true;
    }
    // print LL
    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    // Separate
    public static Node separate(Node head){
        Node prime = new Node(0);
        Node composite = new Node(0);
        Node one = new Node(1);
        Node head1 = prime;
        Node head2 = composite;
        while(head != null){
            if(head.value == 1){
                one = new Node(1);
            }
            else if(isPrime(head.value)){
                head1.next = head;
                head1 = head1.next;
            }
            else{
                head2.next = head;
                head2 = head2.next;
            }
            head = head.next;
        }
        head1.next = composite.next;
        head2.next = one;
        return prime.next;
    }
    public static void main(String args[]){
        // Node a = new Node(3);
        // Node b = new Node(4);
        // Node c = new Node(1);
        // Node d = new Node(2);
        // Node e = new Node(6);
        // Node f = new Node(5);
        // Node g = new Node(7);
        // a.next = b;
        // b.next = c;
        // c.next = d;
        // d.next = e;
        // e.next = f;
        // f.next = g;
        Node a = input();
        print(a);
        Node result = separate(a);
        print(result);
    }
}