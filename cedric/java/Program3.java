import base.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Program3 {
    public static void main(String[] args) {
        Program3 program3 = new Program3();
        // test case
        ListNode node1 = new ListNode(1), node2 = new ListNode(3), node3 = new ListNode(1),
                node4 = new ListNode(5), node5 = new ListNode(5), node6 = new ListNode(7);
        node1.addNext(node2).addNext(node3).addNext(node4).addNext(node5).addNext(node6);
        program3.delDuplication(node1);
        System.out.println(node1);
    }

    private void delDuplication(ListNode node) {
        Set<Integer> set = new HashSet<>();
        set.add(node.val());
        ListNode parent = node, curr = node.next();
        while(curr != null) {
            if(set.contains(curr.val())) {
                parent.next(curr.next());
            } else {
                set.add(curr.val());
                parent = curr;
            }
            curr = curr.next();
        }
    }
}
