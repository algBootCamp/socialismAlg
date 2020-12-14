import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Program3 {

    public static void main(String[] args) {
        Node node1 = new Node(1), node2 = new Node(3), node3 = new Node(1),
                node4 = new Node(5), node5 = new Node(5), node6 = new Node(7);
        node1.addNext(node2).addNext(node3).addNext(node4).addNext(node5).addNext(node6);
        delDuplication(node1);
        printNode(node1);
    }
    static void printNode(Node root){
        Node cur = root;
        while (cur!=null){
            System.out.print(cur.val());
            cur=cur.next();
            if(cur!=null){
                System.out.print("->");
            }
        }
        System.out.println();
    }
    private static void delDuplication(Node node) {
        Map<Integer,String> set = new HashMap<>();
        set.put(node.val(),"");
        Node parent = node, curr = node.next();
        while(curr != null) {
            if(set.containsKey(curr.val())) {
                parent.next(curr.next());
            } else {
                set.put(curr.val(),"");
                parent = curr;
            }
            curr = curr.next();
        }
    }
    static class Node{
        private Node next;
        private final int val;
        public Node(int val) {
            this.next = null;
            this.val = val;
        }
        public Node addNext(Node next) {
            this.next = next;
            return next;
        }

        public Node next() {
            return this.next;
        }

        public void next(Node next) {
            this.next = next;
        }

        public int val() {
            return this.val;
        }
    }
}

