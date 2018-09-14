package slowAndFast;

import Entry.Node;

public class Middle {
    public static void main(String[] args) {
        Node p = Node.init(20);
        Node middle = middle(p);
        System.out.println(middle.value);
    }
    public static Node middle(Node node){
        if(node == null || node.next == null){
            return node;
        }
        Node fast = node;
        Node slow = node;
        while ((fast = fast.next) != null && (fast = fast.next) != null){
            slow = slow.next;
        }
        return slow;
    }
}
