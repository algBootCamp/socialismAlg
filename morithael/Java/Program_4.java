import java.util.*;

public class Program_4 {
    public static void main(String[] args){
        class Node {
            Node next;//指向下一个节点
            Integer e;//数据域
        }
        //从数组构建出一个链表
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,3,1,1,5,5,7,3,1,2,4));
        Node head = new Node();
        for(int i =0; i<arrayList.size(); i++){
            Node tmpNode = new Node();
            tmpNode.e = arrayList.get(i);
            if(i==0){
                head.next = tmpNode;
            }else {
                Node pp = head.next;
                while (pp.next != null){
                    pp = pp.next;
                }
                pp.next = tmpNode;
            }
        }

            Node cur = head;//记录当前链表的首地址
            int len = 0;

            //计算链表的长度
            while(cur!=null){
                len++;
                cur=cur.next;
            }

            int k = arrayList.size();
            //如果整除均分每段长度
            int part = len/k;
            //会有一些段数的长度大一如果不整除，这就正好是mod
            int mod = len%k;

            //进行拆分链表
            //建立一个新的链表数组
            Node[]list = new Node[k];
            //cur重新指向首地址
            cur = head;

            //两层for循环，外层是循环k段，而里面是循环每一段究竟该多长
            for(int i = 0; i<k && cur!=null; i++){
                //总共k段，每一段的开头结点是list[i]，也是cur
                list[i] = cur;
                //每次减一这个操作很骚
                int realpart = part+(mod-- >0?1:0);
                //这一步是来找到每一段的最后结点
                for(int j = 0; j<realpart-1; j++){
                    cur = cur.next;
                }
                //改变最后结点指向为Null,完成分割
                Node next = cur.next;
                cur.next = null;
                //移动cur开启下一个分段
                cur = next;
            }

            System.out.println(list);



    }
}
