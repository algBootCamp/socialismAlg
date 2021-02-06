package yajuan.xiao;

//本题的题意为 求最深叶子节点 的最近公共祖先结点
//从高度高的子树方向向下递归， 如果子树的高度相等，则 该结点为所求结点
public class Program_12 {

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
			
		if(root==null || (root.left == null && root.right == null)){
			return root;
		}
		int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
		
		if(leftHeight == rightHeight ) {
			return root;
		}else if(leftHeight>rightHeight){ //如果有一边高度大于另一边 高的这边必然不为空
			return subtreeWithAllDeepest(root.left);
		}else {
			return subtreeWithAllDeepest(root.right);
		}
		
	}

	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
}
