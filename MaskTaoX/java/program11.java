import org.junit.Test;

public class program11 {
    @Test
    public void test(){
        TreeNode node = new TreeNode(1);
        node.setLeft(new TreeNode(2));
        node.setRight(new TreeNode(2));
        node.getLeft().setLeft(new TreeNode(3));
        node.getLeft().setRight(new TreeNode(4));
        node.getRight().setLeft(new TreeNode(4));
        node.getRight().setRight(new TreeNode(3));
        System.out.println(check(node.getLeft(),node.getRight()));
    }

    @Test
    public void test1(){
        TreeNode node = new TreeNode(1);
        node.setLeft(new TreeNode(2));
        node.setRight(new TreeNode(2));
        node.getLeft().setRight(new TreeNode(3));
        node.getRight().setRight(new TreeNode(3));
        System.out.println(check(node.getLeft(),node.getRight()));
    }

    public boolean check(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null){
            return true;
        }
        if(node1==null||node2==null){
            return false;
        }
        if(node1.getVal()==node2.getVal()){
            return check(node1.getLeft(),node2.getRight())&&check(node2.getLeft(),node1.getRight());
        }
        return false;
    }
}
