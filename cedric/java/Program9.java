import base.TreeNode;

public class Program9 {
    public static void main(String[] args) {
        Program9 program9 = new Program9();
        // test case 1
        TreeNode root1 = new TreeNode(3), l = new TreeNode(9), r = new TreeNode(20),
                r1l = new TreeNode(15), r1r = new TreeNode(7);
        r.left(r1l); r.right(r1r); root1.left(l); root1.right(r);
        System.out.println(program9.isBalanced(root1));
        // test case 2
        TreeNode root2 = new TreeNode(1), l1l = new TreeNode(3), l1r = new TreeNode(3),
                l1l2l = new TreeNode(4), l1l2r = new TreeNode(4);
        l = new TreeNode(2); r = new TreeNode(2);
        l1l.left(l1l2l); l1l.right(l1l2r); l.left(l1l); l.right(l1r); root2.left(l); root2.right(r);
        System.out.println(program9.isBalanced(root2));
        // test case 3
        TreeNode root3 = null;
        System.out.println(program9.isBalanced(root3));
    }

    private boolean isBalanced(TreeNode root) {
        boolean res = true;
        if(root != null) {
            res = isBalancedRecursively(root, new int[1]);
        }
        return res;
    }

    private boolean isBalancedRecursively(TreeNode node, int[] height) {
        boolean res;
        if(!node.hasLeft() && !node.hasRight()) {
            // leaf
            height[0] = 1;
            return true;
        }
        else if(!node.hasLeft() && node.hasRight()) {
            res = isBalancedRecursively(node.right(), height) && height[0] <= 1;
            height[0]++;
        } else if(node.hasLeft() && !node.hasRight()) {
            res = isBalancedRecursively(node.left(), height) && height[0] <= 1;
            height[0]++;
        } else {
            // post-traversal
            boolean isLeftBalanced = isBalancedRecursively(node.left(), height);
            int left = height[0];
            if(isLeftBalanced) {
                boolean isRightBalanced = isBalancedRecursively(node.right(), height);
                int right = height[0];
                res = isRightBalanced && Math.abs(left - right) <= 1;
                height[0] = Math.max(left, right) + 1;
            } else {
                res = false;
            }
        }
        return res;
    }
}
