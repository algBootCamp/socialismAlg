import java.util.LinkedList;

public class Program10 {
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

    //LinkedList队列实现层序遍历
    public static void levelOrderPrint(TreeNode root){
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()){
            TreeNode node = list.poll();
            System.out.print(node.val+" ");
            if(node.left != null){
                list.offer(node.left);
            }
            if(node.right != null){
                list.offer(node.right);
            }
        }
    }

    public static void main(String[] args){
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3,n6,null);
        TreeNode n1 = new TreeNode(1, n2, n3);
        levelOrderPrint(n1);
    }

}
