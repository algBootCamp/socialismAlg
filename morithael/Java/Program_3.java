import java.util.*;

public class Program_3 {

    public static void main(String[] args){
        //从数组构建出一个链表
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,3,1,1,5,5,2,2,2,4,2,4,3,5));
        Node head = buildList(arrayList);

        //处理重复的值
        sift(head);

        //打印链表的数值域
        printList(head);
    }
    //定义链表类
    private static class Node {
        Node next;//指向下一个节点
        Integer e;//数据域
    }

    private static Node buildList(ArrayList<Integer> arrayList){
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
        return head;
    }

    private static void sift(Node head){
        //定义一个存放已经存在的数值的数组
        ArrayList<Integer> collected = new ArrayList<>();
        //head 不能动，回头得传回去呢
        Node searchPoint = head;
        while (searchPoint.next != null){
            if (collected.contains(searchPoint.next.e)){
                if(searchPoint.next.next != null ){
                    searchPoint.next = searchPoint.next.next;
                    continue;
                }else {
                    searchPoint.next = null;
                    break;
                }
            }else {
                collected.add(searchPoint.next.e);
            }
            searchPoint = searchPoint.next;
        }
    }

    private static void printList(Node head){
        Node printPoint = head;
        while (printPoint.next!=null){
            System.out.println(printPoint.next.e);
            printPoint = printPoint.next;
        }
    }
}
