import java.util.*;

public class Program_9 {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,2,3,3,null,null,4,4));
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

        int sideMark =0;

        for (Integer i : input) {
            if (treeNodeCache.size() >= 1) {
                TreeNode tmpNode = treeNodeCache.get(0);
                if (i!= null){
                    if (tmpNode.leftSon == null && sideMark == 0) {
                        tmpNode.leftSon = new TreeNode(i);
                        treeNodeCache.add(tmpNode.leftSon);
                        sideMark = 1;
                    } else if (tmpNode.rightSon == null && sideMark == 1) {
                        tmpNode.rightSon = new TreeNode(i);
                        treeNodeCache.add(tmpNode.rightSon);
                        treeNodeCache.remove(0);
                        sideMark = 0;
                    }
                }else if(sideMark ==0){

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
