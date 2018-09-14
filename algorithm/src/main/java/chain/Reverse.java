package chain;

import Entry.Node;

public class Reverse {
    public static void main(String[] args) {
        Node p = Node.init();
        Node reverse = reverse(p);
        Node.print(reverse);
    }

    public static Node reverse(Node node){
        Node pre = null;
        Node curr = node;
        while(curr != null){
            Node next = curr.next;
            curr.next = pre;
            pre  = curr;
            curr = next;
        }
        return pre;
    }

    public static Node reverse2(Node node){
        if(node.next == null){
            return node;
        }
        Node next = node.next;
        node.next = null;
        Node p = reverse2(next);
        next.next = node;
        return p;
    }
}
