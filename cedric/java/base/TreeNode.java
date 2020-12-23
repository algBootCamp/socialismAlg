package base;

/**
 * DESCRIPTION:
 * CLASS: TreeNode
 *
 * @author chengyujia
 */
public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode left() {
        return this.left;
    }

    public TreeNode right() {
        return this.right;
    }

    public int val() {
        return this.val;
    }

    public void left(TreeNode left) {
        this.left = left;
    }

    public void right(TreeNode right) {
        this.right = right;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }
}
