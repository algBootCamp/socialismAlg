import java.util.HashSet;
import java.util.Set;

public class Program3 {
    public static void main(String[] args) {
        Program3 program3 = new Program3();
        // test case
        Node node1 = new Node(1), node2 = new Node(3), node3 = new Node(1),
                node4 = new Node(5), node5 = new Node(5), node6 = new Node(7);
        node1.next(node2).next(node3).next(node4).next(node5).next(node6);
        program3.delDuplication(node1);
        System.out.println(node1);
    }

    private void delDuplication(Node node) {
        Set<Integer> set = new HashSet<>();
        set.add(node.val);
        Node parent = node, curr = node.next;
        while(curr != null) {
            if(set.contains(curr.val)) {
                parent.next = curr.next;
            } else {
                set.add(curr.val);
                parent = curr;
            }
            curr = curr.next;
        }
    }

    static class Node {
        Node next;
        int val;
        Node(int val) {
            this.next = null;
            this.val = val;
        }
        Node next(Node next) {
            this.next = next;
            return next;
        }
        @Override
        public String toString() {
            Node curr = this;
            StringBuilder stringBuilder = new StringBuilder();
            while(curr != null) {
                stringBuilder.append(curr.val).append("->");
                curr = curr.next;
            }
            stringBuilder.append(".");
            return stringBuilder.toString();
        }
    }
}
