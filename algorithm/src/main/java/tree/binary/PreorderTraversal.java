package tree.binary;

import java.util.LinkedList;

/**
 *先序遍历
 */
public class PreorderTraversal {
    /**
     *递归
     * @param root
     */
    public void withRecursion(BinaryTreeNode root){
        if(root != null){
            System.out.print(root.getValue() + " ");
            withRecursion(root.getLeft());
            withRecursion(root.getRight());
        }
    }

    /**
     * 非递归
     * @param root
     */
    public void withoutRecursion(BinaryTreeNode root){
        LinkedList<BinaryTreeNode> stack = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                System.out.print(root.getValue() + " ");
                stack.addFirst(curr);
                curr = curr.getLeft();
            }else {
                BinaryTreeNode node = stack.poll();
                curr = node.getRight();
            }
        }
    }
}
