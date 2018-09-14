import Entry.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode node = TreeNode.init();
        List<List<Integer>> lists = zigzagLevelOrder(node);
        System.out.println(lists);
    }



    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return null;
        }
        List<List<Integer>> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean asc = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            int index = size;
            List<Integer> temp = new ArrayList<Integer>(size);
            while(index > 0){
                TreeNode node = queue.poll();
                if(asc){
                    temp.add(size - index,node.val);
                }else{
                    temp.add(index - 1,node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                index --;
                asc = !asc;
            }
            list.add(temp);
            asc = !asc;

        }
        return list;
    }
}
