public class Program12 {

    /**
     * https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/
     * 深度优先递归搜索；每次返回当前节点与最深节点的距离，以及当前子树中满足题设要求的节点。
     */

    public TreeNode subtreeWithAllDeepest(TreeNode root){
        return dfs(root).node;
    }

    public Result dfs(TreeNode cur){
        if(cur == null){
            return new Result(null, 0);
        }
        Result ls = dfs(cur.left);
        Result rs = dfs(cur.right);
        if(ls.depth > rs.depth){
            return new Result(ls.node, ls.depth+1);
        }
        if(ls.depth < rs.depth){
            return new Result(rs.node, rs.depth+1);
        }
        return new Result(cur, ls.depth+1);
    }

    public class Result{
        TreeNode node;
        int depth;
        Result(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }

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

}
