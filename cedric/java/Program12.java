import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Program12 {
    public static void main(String[] args) {
        Program12 program12 = new Program12();
        // test case 1
        TreeNode root1 = new TreeNode(3), l = new TreeNode(5), r = new TreeNode(1),
                l1l = new TreeNode(6), l1r = new TreeNode(2),
                r1l = new TreeNode(0), r1r = new TreeNode(8),
                l1r2l = new TreeNode(7), l1r2r = new TreeNode(4);
        root1.left(l); root1.right(r);
        l.left(l1l); l.right(l1r);
        r.left(r1l); r.right(r1r);
        l1r.left(l1r2l); l1r.right(l1r2r);
        System.out.println(program12.subtreeWithAllDeepest(root1).val());
        // test case 2
        TreeNode root2 = new TreeNode(1);
        System.out.println(program12.subtreeWithAllDeepest(root2).val());
        // test case 3
        TreeNode root3 = new TreeNode(0);
        l = new TreeNode(1); r = new TreeNode(3);
        l1r = new TreeNode(2);
        root3.left(l); root3.right(r);
        l.right(l1r);
        System.out.println(program12.subtreeWithAllDeepest(root3).val());
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        List<TreeNode> bucket = new ArrayList<>();
        List<List<TreeNode>> rc = new ArrayList<>();
        if (root != null) {
            int deepest = subtreeWithAllDeepestRecursively(root, bucket, rc);
            rc.removeIf(list -> list.size() != deepest);
            TreeNode common = null;
            for (int i = deepest - 1; i >= 0; i--) {
                for (List<TreeNode> list : rc) {
                    if (common == null) {
                        common = list.get(i);
                        continue;
                    }
                    if (list.get(i).val() != common.val()) {
                        common = null;
                        break;
                    }
                }
                if (common != null) {
                    return common;
                }
            }
        }
        return null;
    }

    public int subtreeWithAllDeepestRecursively(TreeNode node, List<TreeNode> bucket, List<List<TreeNode>> rc) {
        if (node == null) {
            int depth = bucket.size();
            // add a new list instead of bucket itself
            rc.add(new ArrayList<>(bucket));
            return depth;
        }
        bucket.add(node);
        int leftDepth = subtreeWithAllDeepestRecursively(node.left(), bucket, rc);
        int rightDepth = subtreeWithAllDeepestRecursively(node.right(), bucket, rc);
        // remove what we add at beginning
        bucket.remove(bucket.size() - 1);
        return Math.max(leftDepth, rightDepth);
    }
}
