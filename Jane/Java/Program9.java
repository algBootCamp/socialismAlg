import sun.reflect.generics.tree.Tree;

//https://leetcode-cn.com/problems/balanced-binary-tree
public class Program9 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //自顶向下 O(nlogn)
    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }else {
            return Math.abs(getHeight(root.left)-getHeight(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static int getHeight(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }else{
            return Math.max(getHeight(treeNode.left), getHeight(treeNode.right))+1;
        }
    }

    //自底向上  O(n)
    public static boolean isBalanced2(TreeNode root){
        return getHeight2(root)>=0;
    }

    public static int getHeight2(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }else {
            int leftHeight = getHeight2(treeNode.left);
            int rightHeight = getHeight2(treeNode.right);
            if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight)>1){
                return -1;
            }
            return Math.max(leftHeight, rightHeight)+1;
        }
    }
}
