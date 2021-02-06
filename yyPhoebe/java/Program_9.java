class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Program_9 {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right); //对左右子树判断是否平衡二叉树   根据定义 每个结点都需要符合
	}

	// 计算二叉树高度
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
}

