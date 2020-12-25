
/*class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
*/

/*
 * 镜像二叉树特点：即根节点的左右子树为镜像对称。 以根节点为界（镜），相当于 外侧结点的值相等，内测结点的值相等
 * 对左右子树进行比较时 即 外侧（左子树-左  vs 右子树-右） 内侧（左子树-右 vs 右子树 - 左）
 * 从两棵子树 分别选出结点进行比较
 * 不对称： 比较的两个结点有一个为空  或者两结点值不相等    return false
 * 对称： 都为空  或者 相等（一直进行比较  直到为空）  return true
 * 
 */
public class Program_11 {
	
	
	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		return compare(root.left,root.right);
	}
	
	public boolean compare(TreeNode rootL,TreeNode rootR) {
		if(rootL==null && rootR == null) {
			return true;
		}
		
		if(rootL==null || rootR == null || rootL.val!=rootR.val) {
			return false;
		}
		return compare(rootL.left,rootR.right)&&compare(rootR.left,rootL.right);
	}
}
