import java.util.*;

public class Program_10 {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        TreeNode head = buildTree(input);
        ArrayList<TreeNode> treeNodeCache = new ArrayList<>();
        treeNodeCache.add(head);
        while (treeNodeCache.size() > 0) {
            TreeNode tmpNode = treeNodeCache.remove(0);
            System.out.println(tmpNode.nodeNumber);
            if (tmpNode.leftSon != null) {
                treeNodeCache.add(tmpNode.leftSon);
            }
            if (tmpNode.rightSon != null) {
                treeNodeCache.add(tmpNode.rightSon);
            }
        }
    }

    private static TreeNode buildTree(ArrayList<Integer> input) {
        ArrayList<TreeNode> treeNodeCache = new ArrayList<>();
        TreeNode head = new TreeNode(input.remove(0));
        treeNodeCache.add(head);

        for (Integer i : input) {
            if (treeNodeCache.size() >= 1) {
                TreeNode tmpNode = treeNodeCache.get(0);
                if (tmpNode.leftSon == null) {
                    tmpNode.leftSon = new TreeNode(i);
                    treeNodeCache.add(tmpNode.leftSon);
                } else if (tmpNode.rightSon == null) {
                    tmpNode.rightSon = new TreeNode(i);
                    treeNodeCache.add(tmpNode.rightSon);
                    treeNodeCache.remove(0);
                }
            }
        }
        return head;
    }

    static class TreeNode {
        Integer nodeNumber;
        TreeNode rightSon;
        TreeNode leftSon;

        public TreeNode(Integer nodeNumber) {
            this.nodeNumber = nodeNumber;
            this.rightSon = null;
            this.leftSon = null;
        }
    }

}
