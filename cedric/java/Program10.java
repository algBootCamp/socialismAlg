import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Program10 {
    public static void main(String[] args) {
        Program10 program10 = new Program10();
        // test case:
        TreeNode root = new TreeNode(1), l = new TreeNode(2), r = new TreeNode(3),
                l1l = new TreeNode(4), l1r = new TreeNode(5),
                r1l = new TreeNode(6), r1r = new TreeNode(7);
        root.left(l); root.right(r);
        l.left(l1l); l.right(l1r);
        r.left(r1l); r.right(r1r);
        System.out.println(program10.layer(root));
    }

    private List<Integer> layer(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                TreeNode currNode = queue.poll();
                res.add(currNode.val());
                if(currNode.hasLeft()) {
                    queue.offer(currNode.left());
                }
                if(currNode.hasRight()) {
                    queue.offer(currNode.right());
                }
            }
        }
        return res;
    }
}
