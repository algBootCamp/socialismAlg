import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/submissions/
 * 前序遍历的第一个节点为当前子树的根节点，中序遍历该节点左侧为左子树节点，右侧为右子树节点
 */
public class Program14 {
    public class TreeNode{
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

    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //事先遍历一遍记录inorder中元素索引
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode res = buildMyTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
        return res;
    }

    public TreeNode buildMyTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        if(preLeft>preRight){
            return null;
        }
        TreeNode cur = new TreeNode(preorder[preLeft]);
        int inorderIdx = map.get(preorder[preLeft]);
        int inleftLen = inorderIdx - inLeft;
        cur.left = buildMyTree(preorder, inorder, preLeft+1, preLeft+inleftLen, inLeft, inorderIdx-1);
        cur.right = buildMyTree(preorder, inorder, preLeft+inleftLen+1, preRight, inorderIdx+1, inRight);
        return cur;
    }



}
