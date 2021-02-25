import base.TreeNode;

/**
 * DESCRIPTION:
 * CLASS: Program14
 * DATE: 2021/2/21 16:28
 *
 * @author chengyujia
 */
public class Program14 {
    public static void main(String[] args) {
        Program14 program14 = new Program14();
        int[] preorder1 = new int[]{3, 9, 20, 15, 7};
        int[] inorder1 = new int[]{9, 3, 15, 20, 7};
        TreeNode root1 = program14.reconstruct(preorder1, inorder1);
        System.out.println(root1);
        int[] preorder2 = new int[]{1, 2};
        int[] inorder2 = new int[]{2, 1};
        TreeNode root2 = program14.reconstruct(preorder2, inorder2);
        System.out.println(root2);
    }

    private TreeNode reconstruct(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return reconstructRecursively(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode reconstructRecursively(int[] preorder, int[] inorder, int root, int s, int e) {
        if (s > e) {
            return null;
        }
        // find root in inorder
        int idx = -1;
        for (int i = s; i <= e; ++i) {
            if (preorder[root] == inorder[i]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            throw new IllegalArgumentException();
        }
        TreeNode rootNode = new TreeNode(preorder[root]);
        rootNode.left(reconstructRecursively(preorder, inorder, root + 1, s, idx - 1));
        rootNode.right(reconstructRecursively(preorder, inorder, root + 1 + idx - s , idx + 1, e));
        return rootNode;
    }
}
