public class Solution {
    public ListNode removeDuplicates(ListNode head) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        ListNode node = new ListNode(0);
        ListNode newHead = node;
        while(head != null){
            if(!set.contains(head.val)){
                set.add(head.val);
                node.next = head;        
                node = node.next;
            }
            head = head.next;
        }    
        node.next = null;
        return newHead.next;
    }
}
