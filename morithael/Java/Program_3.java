import java.lang.reflect.Array;
import java.util.*;

public class Program_3 {
    public static void main(String[] args){
        //定义链表类
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

        //定义一个存放已经存在的数值的数组
        ArrayList<Integer> collected = new ArrayList<>();

        Node searchPoint = head;
        while (searchPoint.next != null){
            if (collected.contains(searchPoint.next.e)){
                if(searchPoint.next.next != null){
                    searchPoint.next = searchPoint.next.next;
                }
            }else {
                collected.add(searchPoint.next.e);
            }
            searchPoint = searchPoint.next;
        }
        System.out.println(collected);

        //打印链表的数值域
        Node printPoint = head;
        while (printPoint.next!=null){
            System.out.println(printPoint.next.e);
            printPoint = printPoint.next;
        }
    }
}
