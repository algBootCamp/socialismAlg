import java.util.Arrays;

public class Program4 {
    public static void main(String[] args) {

        Node node1 = new Node(1), node2 = new Node(2), node3 = new Node(3),
                node4 = new Node(4), node5 = new Node(5), node6 = new Node(6),
                node7 = new Node(7), node8 = new Node(8), node9 = new Node(9), node10 = new Node(10);
        // test case 1
        node1.addNext(node2).addNext(node3).addNext(node4);
        printNode(node1);
        Arrays.stream(splitListToParts(node1, 5)).forEach(o -> printNode(o));

        // test case 2
        node1.addNext(node2).addNext(node3).addNext(node4).addNext(node5).addNext(node6).addNext(node7).addNext(node8).addNext(node9).addNext(node10);
        printNode(node1);
        Arrays.stream(splitListToParts(node1, 5)).forEach(o -> printNode(o));


        // test case 2
        node1.addNext(node2).addNext(node3).addNext(node4).addNext(node5).addNext(node6).addNext(node7).addNext(node8).addNext(node9).addNext(node10);
        printNode(node1);
        Arrays.stream(splitListToParts(node1, 6)).forEach(o -> printNode(o));
    }

    static void printNode(Node root) {
        Node cur = root;
        if(cur==null){
            System.out.println("null");
        }
        while (cur != null) {
            System.out.print(cur.val());
            cur = cur.next();
            if (cur != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    static private Node[] splitListToParts(Node root, int k) {
        Node[] res = new Node[k];
        if (root != null) {
            int len = getLength(root);
            int idx = 0;
            Node curr = root, pre = null;
            if (len <= k) {
                while (curr != null) {
                    res[idx++] = curr;
                    Node next = curr.next();
                    curr.next(null);
                    curr = next;
                }
            } else {
                int q = len / k;
                int r = len - k * q;
                while (curr != null) {
                    res[idx++] = curr;
                    int cq = q;
                    while (cq-- > 0) {
                        pre = curr;
                        curr = curr.next();
                    }
                    if (r-- > 0) {
                        pre = curr;
                        curr = curr.next();
                    }
                    if (pre != null) {
                        pre.next(null);
                    }
                }
            }
        }
        return res;
    }

    static int getLength(Node root) {
        int len = 0;
        Node curr = root;
        while (curr != null) {
            len++;
            curr = curr.next();
        }
        return len;
    }

    static class Node {
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
