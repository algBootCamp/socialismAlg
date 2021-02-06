import java.util.*;

public class Program_9 {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,2,null,null,4,4,1));
        TreeNode head = buildTree(input);

        int level = 1;
        int firstUnFullLevel = 100;
        int deepest = 0;

        ArrayList<TreeNode> treeNodeCache = new ArrayList<>();
        treeNodeCache.add(head);
        while (treeNodeCache.size()>0){
            TreeNode tmpNode = treeNodeCache.remove(0);
            boolean newLevelAdded = false;
            if(tmpNode.leftSon != null){
                treeNodeCache.add(tmpNode.leftSon);
                level++;
                newLevelAdded = true;

            }else if(firstUnFullLevel > level){
                firstUnFullLevel = level;
            }
            if(tmpNode.rightSon != null){
                treeNodeCache.add(tmpNode.rightSon);
                if(!newLevelAdded){
                    level++;
                }
            }else if(firstUnFullLevel > level){
                firstUnFullLevel = level;
            }

            if (tmpNode.leftSon == null && tmpNode.rightSon == null){
                if(level-firstUnFullLevel>1){
                    System.out.println("false");
                    return;
                }
                if(level>deepest){
                    deepest = level;
                }
            }
        }
        if(deepest-firstUnFullLevel>1){
            System.out.println("false");
        }else {
            System.out.println("true");
        }

    }

    private static TreeNode buildTree(ArrayList<Integer> input){
        ArrayList<TreeNode> treeNodeCache = new ArrayList<>();
        TreeNode head = new TreeNode(input.remove(0));
        ArrayList<Integer> array = input;
        treeNodeCache.add(head);
        while (treeNodeCache.size()>0){
            TreeNode tmpNode = treeNodeCache.remove(0);
            if(array.size()>0){
                Integer tmpInt = array.remove(0);
                if(tmpInt!=null){
                    tmpNode.leftSon = new TreeNode(tmpInt);
                    treeNodeCache.add(tmpNode.leftSon);
                }
            }
            if(array.size()>0){
                Integer tmpInt = array.remove(0);
                if(tmpInt!=null){
                    tmpNode.rightSon = new TreeNode(tmpInt);
                    treeNodeCache.add(tmpNode.rightSon);
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
