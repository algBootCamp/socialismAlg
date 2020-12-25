package yajuan.xiao;

import java.util.ArrayList;
import java.util.List;

/*class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
*/
public class Program_11 {
	
	
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (root.left != null && root.right != null) {
			
			TreeNode origRoot = root;
			Mirror(root);
			List<Integer> listOrigRoot=new ArrayList<Integer>();
			preOrder(origRoot,listOrigRoot);
			List<Integer> listRoot=new ArrayList<Integer>();
			preOrder(root,listRoot);
			
			System.out.println(listRoot.toString());
			System.out.println(listOrigRoot.toString());
			return listRoot.toString().equals(listOrigRoot.toString());
		}
		return false;
	}

	// 镜像
	public void Mirror(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		Mirror(root.left);
		Mirror(root.right);
	}

	
	public void preOrder(TreeNode root,List<Integer> list) {
		if (root!=null) {
			list.add(root.val);
			preOrder(root.left,list);
			preOrder(root.right,list);
		}
	}
}
