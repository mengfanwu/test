package Entry;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode init(){
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node17 = new TreeNode(17);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node17;
        return node3;
    }
}
