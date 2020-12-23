//层序遍历
public class Program_10 {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int size = queue.size();
			List<Integer> tmpList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll(); // 队列第一个元素
				tmpList.add(tmp.val);//添加同一层结点值
				
				if (tmp.left != null) {
					queue.add(tmp.left);
				}
				if (tmp.right != null) {
					queue.add(tmp.right);
				}
				
			}
			result.add(tmpList);
		}
		return result;

	}

}
