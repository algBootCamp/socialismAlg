package base;

public class ListNode {
    private ListNode next;
    private final int val;

    public ListNode(int val) {
        this.next = null;
        this.val = val;
    }

    public ListNode addNext(ListNode next) {
        this.next = next;
        return next;
    }

    public ListNode next() {
        return this.next;
    }

    public void next(ListNode next) {
        this.next = next;
    }

    public int val() {
        return this.val;
    }

    @Override
    public String toString() {
        ListNode curr = this;
        StringBuilder stringBuilder = new StringBuilder();
        while(curr != null) {
            stringBuilder.append(curr.val).append("->");
            curr = curr.next;
        }
        stringBuilder.append(".");
        return stringBuilder.toString();
    }
}
