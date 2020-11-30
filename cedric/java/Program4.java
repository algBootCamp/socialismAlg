import base.ListNode;

import java.util.Arrays;

public class Program4 {
    public static void main(String[] args) {
        Program4 program4 = new Program4();
        ListNode node1 = new ListNode(1), node2 = new ListNode(2), node3 = new ListNode(3),
                node4 = new ListNode(4), node5 = new ListNode(5), node6 = new ListNode(6),
                node7 = new ListNode(7), node8 = new ListNode(8), node9 = new ListNode(9), node10 = new ListNode(10);
        // test case 1
        node1.addNext(node2).addNext(node3).addNext(node4);
        System.out.println(Arrays.toString(program4.splitListToParts(node1, 5)));
        // test case 2
        node1.addNext(node2).addNext(node3).addNext(node4).addNext(node5).addNext(node6).addNext(node7).addNext(node8).addNext(node9).addNext(node10);
        System.out.println(Arrays.toString(program4.splitListToParts(node1, 3)));
    }

    private ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if(root != null) {
            int len = getLength(root);
            int idx = 0;
            ListNode curr = root, pre = null;
            if(len <= k) {
                while(curr != null) {
                    res[idx++] = curr;
                    ListNode next = curr.next();
                    curr.next(null);
                    curr = next;
                }
            } else {
                int q = len / k;
                int r = len - k * q;
                while(curr != null) {
                    res[idx++] = curr;
                    int cq = q;
                    while(cq-- > 0) {
                        pre = curr;
                        curr = curr.next();
                    }
                    if(r-- > 0) {
                        pre = curr;
                        curr = curr.next();
                    }
                    if(pre != null) {
                        pre.next(null);
                    }
                }
            }
        }
        return res;
    }

    private int getLength(ListNode root) {
        int len = 0;
        ListNode curr = root;
        while(curr != null) {
            len++;
            curr = curr.next();
        }
        return len;
    }
}
