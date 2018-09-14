package Entry;

public class Node {
    public Node next;
    public int value;
    public Node(Node next,int value){
        this.next = next;
        this.value = value;
    }
    public Node(){

    }
    public static Node init(){
        return new Node(new Node(new Node(new Node(new Node(null,5),4),3),2),1);
    }
    public static void print(Node node){
        Node curr = node;
        while (curr != null){
            System.out.println(curr.value);
            curr = curr.next;
        }
    }

    public static Node init(int index){
        Node head = new Node(null,1);
        Node curr = head;
        for (int i = 2;i <= index;i++){
            Node node = new Node(null,i);
            curr.next = node;
            curr = node;
        }
        return head;
    }
}
