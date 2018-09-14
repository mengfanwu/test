package tree.binary;

import java.util.LinkedList;

/**
 * 中序遍历
 */
public class InorderTraversal {
    /**
     * 递归
     * @param root
     */
    public void withRecursion(BinaryTreeNode root){
        if(root != null){
            withRecursion(root.getLeft());
            System.out.print(root.getValue()+" ");
            withRecursion(root.getRight());
        }
    }
    public void withoutRecursion(BinaryTreeNode root){
        LinkedList<BinaryTreeNode> stack = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.addFirst(curr);
                curr = curr.getLeft();
            }else {
                BinaryTreeNode node = stack.poll();
                System.out.print(node.getValue() + " ");
                curr = node.getRight();
            }
        }
    }
}
