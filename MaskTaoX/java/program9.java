import org.junit.Test;

public class program9 {
    @Test
    public void test(){
        TreeNode root=new TreeNode(3);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(20));
        root.getRight().setLeft(new TreeNode(15));
        root.getRight().setRight(new TreeNode(7));
        System.out.println(check(root));
    }

    public boolean check(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.getLeft()) - height(root.getRight())) <= 1
                    && check(root.getLeft()) && check(root.getRight());
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
        }
    }

}
