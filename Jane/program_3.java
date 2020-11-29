import java.util.HashSet;

/**
   author: Baijie
 */
public class program_3 {
    private static class Node{
        private Node next;
        private Object data;

        public Node(Object data){
            this.data = data;
        }
    }

    public static void remove(Node first){
        HashSet hashSet = new HashSet<>();
        Node pre = first;
        Node cur = first.next;
        while(cur != null){
            if(hashSet.contains(cur.data)){
                pre.next = cur.next;
                cur = pre.next;
                continue;
            }else{
                hashSet.add(cur.data);
            }
            pre = pre.next;
            cur = cur.next;
        }
    }

    public static void main(String[] args){
        int data[] = {1,3,1,5,5,7};
        Node first = new Node(null);
        Node cur = first;
        for(int i=0; i<data.length; i++){
            cur.next = new Node(data[i]);
            cur = cur.next;
        }
        remove(first);
        Node node = first.next;
        while (node!=null){
            System.out.println(node.data);
            node = node.next;
        }
    }
}
