//

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/ <br>
 *     如果同时满足下面的条件，两个树互为镜像：<br>
 *         1. 它们的两个根结点具有相同的值 <br>
 *         2. <b>每个树</b>的右子树都与另一个树的左子树镜像对称 <br>
 */
public class Program11 {
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

    //方法1： 递归
    public static boolean isSymmetric(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        if(root.left == null || root.right==null){
            return false;
        }
        return check(root.left, root.right);
    }

    public static boolean check(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null){
            return true;
        }
        if(n1 == null || n2 == null){
            return false;
        }
        return n1.val == n2.val && check(n1.left, n2.right) && check(n1.right, n2.left);
    }


    //方法2： 用队列实现迭代
    public static boolean isSymmetric2(TreeNode root){
        return check2(root, root);
    }

    public static boolean check2(TreeNode n1, TreeNode n2){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(n1);
        queue.offer(n2);
        while(!queue.isEmpty()){
            n1 = queue.poll();
            n2 = queue.poll();
            if(n1 == null && n2 == null){
                continue;
            }
            if((n1 == null || n2 == null) || n1.val != n2.val){
                return false;
            }
            queue.offer(n1.left);
            queue.offer(n2.right);

            queue.offer(n1.right);
            queue.offer(n2.left);
        }
        return true;
    }

}
