import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class program10 {
    @Test
    public void test(){
      TreeNode root=new TreeNode(1);
      root.setLeft(new TreeNode(2));
      root.setRight(new TreeNode(3));
      root.getLeft().setLeft(new TreeNode(4));
      root.getLeft().setRight(new TreeNode(5));
      root.getRight().setLeft(new TreeNode(6));
      root.getRight().setRight(new TreeNode(7));

      printTree(root);
    }
    private void printTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            System.out.print(p.getVal()+ "-");
            if (p.getLeft() != null){
                queue.offer(p.getLeft());
            }
            if (p.getRight() != null){
                queue.offer(p.getRight());
            }
        }
    }
}
