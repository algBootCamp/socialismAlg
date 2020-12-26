import base.TreeNode;

public class Program11 {
    public static void main(String[] args) {
        Program11 program11 = new Program11();
        // test case 1
        TreeNode root1 = new TreeNode(1), l = new TreeNode(2), r = new TreeNode(2),
                l1l = new TreeNode(3), l1r = new TreeNode(4),
                r1l = new TreeNode(4), r1r = new TreeNode(3);
        root1.left(l); root1.right(r);
        l.left(l1l); l.right(l1r);
        r.left(r1l); r.right(r1r);
        System.out.println(program11.isSymmetric(root1));
        // test case 2
        TreeNode root2 = new TreeNode(1);
        l = new TreeNode(2); r = new TreeNode(2);
        l1r = new TreeNode(3); r1r = new TreeNode(3);
        root2.left(l); root2.right(r);
        l.right(l1r);
        r.right(r1r);
        System.out.println(program11.isSymmetric(root2));
    }

    private boolean isSymmetric(TreeNode root) {
        boolean res = true;
        if(root != null) {
            res = isSymmetricRecursively(root, root);
        }
        return res;
    }

    private boolean isSymmetricRecursively(TreeNode left, TreeNode right) {
        // both null
        if (left == null && right == null) {
            return true;
        }
        // either left or right is null
        if (left == null || right == null) {
            return false;
        }
        // if equals, compare left's left and right's right, left's right and right's left
        if (left.val() == right.val()) {
            return isSymmetricRecursively(left.left(), right.right())
                    && isSymmetricRecursively(left.right(), right.left());
        }
        return false;
    }
}
