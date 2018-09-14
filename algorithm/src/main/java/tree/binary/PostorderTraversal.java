package tree.binary;

import java.util.LinkedList;

/**
 * 中序遍历
 */
public class PostorderTraversal {
    /**
     * 递归
     * @param root
     */
    public void withRecursion(BinaryTreeNode root){
        if(root != null){
            withRecursion(root.getLeft());
            withRecursion(root.getRight());
            System.out.print(root.getValue()+" ");
        }
    }
    public void withoutRecursion(BinaryTreeNode root){

    }
}
