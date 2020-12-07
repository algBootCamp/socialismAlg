import java.util.ArrayList;
import java.util.List;

/**
 * author: baijie
 */
public class Program_4 {
    private static class Node{
        private Node next;
        private Object data;

        public Node(Object data){
            this.data = data;
        }
    }

    public static List<Node> splitLinkedList(Node first, int k) {
        Node cur = first;
        //计算链表长度
        int len = 0;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        len += 1;

        int div = len / k;//求商
        int rem = len % k;//取余
        List<Node> result = new ArrayList<>();
        cur = first;
        Node start = first;//存储当前构造子链表的头
        Node cur_tmp;
        Node start_tmp;
        int count_k = 0; //记数当前构造第几个子链表
        int count_div = 0;//记数当前子链表中的第几个节点
        if(k>len){
            //k大于链表长度时单独处理
            for (int i = 0; i < k; i++){
                if(i<len){
                    cur_tmp = cur;
                    cur = cur.next;
                    cur_tmp.next = null;
                    result.add(cur_tmp);
                }else {
                    result.add(new Node(null));
                }
            }
        }else {
            for (int i = 0; i < len; i++) {
                //前rem个子链表，节点数为div+1个;其余子链表节点数为div个
                if (count_k < rem) {
                    if (count_div < div) {
                        cur = cur.next;
                        count_div++;
                    } else {
                        cur_tmp = cur;
                        cur = cur.next;
                        cur_tmp.next = null;

                        start_tmp = start;
                        result.add(start_tmp);
                        start = cur;

                        count_div = 0;
                        count_k++;
                    }
                }else {
                    if (count_div < div-1) {
                        cur = cur.next;
                        count_div++;
                    } else {
                        cur_tmp = cur;
                        cur = cur.next;
                        cur_tmp.next = null;

                        start_tmp = start;
                        result.add(start_tmp);
                        start = cur;

                        count_div = 0;
                        count_k++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        //构造测试数据
//        int data[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int k = 3;
        int data[] = {1, 2, 3};
        int k = 5;
        Node first = new Node(data[0]);
        Node cur = first;
        for(int i=1; i<data.length; i++){
            cur.next = new Node(data[i]);
            cur = cur.next;
        }

        List<Node> res = splitLinkedList(first, k);

        //输出拆分结果
        System.out.print("[");
        for (int i =0; i<res.size();i++) {
            Node n = res.get(i);
            System.out.print("[");
            while(n!=null){
                if(n.data!=null){
                    System.out.print(n.data);
                }else {
                    System.out.print("");
                }
                if(n.next != null){
                    System.out.print(",");
                }
                n = n.next;
            }
            System.out.print("]");
            if(i<res.size()-1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

}
