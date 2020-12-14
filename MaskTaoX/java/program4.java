
import java.util.Arrays;

public class program4 {
    public static void main(String[] args) {
        Node header=buildList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        //Node header=buildList(new int[]{1, 2, 3});
        int k = 4;
        Node[] nodes= splitList(header,k);
        System.out.println(Arrays.toString(nodes));
    }

    static Node buildList(int[] list){
        Node head = new Node(list[0]);
        Node p = head;
        for(int i =1 ;i<list.length;i++){
            p.next=new Node(list[i]);
            p=p.next;
        }
        p=head;
        System.out.println(head.toString());
        return head;
    }

    static Node[] splitList(Node head, int k){
        //统计长度
        int count =0 ;
        Node p =head;
        while(p!=null){
            count++;
            p=p.next;
        }
        //确定分组
        Node[] nodes = new Node[k];
        Node q= null;
        p =head;
        //分割数大于节点数
        if(k>count){
            q=head;
            for(int i =0 ;i< k ;i++){
                if(p!=null)
                {
                    q=q.next;
                    p.next=null;
                    nodes[i]=p;
                    p=q;
                }else{
                    nodes[i]=null;
                }
            }
        }else{
            int m = count/k; //最小长度
            int n = count%k;
            int i=0;
            while(p!=null){
                nodes[i++]=p;
                int f=m;
                while(f-->0){
                    q=p;
                    p=p.next;
                }
                if(n-->0){
                    q=p;
                    p=p.next;
                }
                if(q!=null){//断开
                    q.next=null;
                }
            }
        }
        return nodes;
    }

    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next = null;
        }

        @Override
        public String toString() {
            Node p =this;
            StringBuffer str = new StringBuffer();
            while(p!=null){
                if(p.next==null){
                    str.append(p.val);
                }
                else {
                    str.append(p.val + "->");
                }
                p=p.next;
            }
            return str.toString();
        }
    }

}

