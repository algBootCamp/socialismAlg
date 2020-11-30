import java.util.*;

public class Program_4 {
    public static void main(String[] args){
        //从数组构建出一个链表
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3,4));
        Node head = buildList(arrayList);

        //要输出的数量
        int n = 5;

        //构建目标列表
        List<Integer> list = buildList(head,n);

        System.out.println(list);
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

    private static List buildList(Node head,int n){
        //收集链表里的数据，构建一个数组
        ArrayList<Integer> collected = new ArrayList<>();
        Node searchPoint = head;
        while (searchPoint.next != null){
            collected.add(searchPoint.next.e);
            searchPoint = searchPoint.next;
        }
        //定义一个准备输出的数组
        ArrayList<Integer> list = new ArrayList<>();

        //计算目标数组中每个数组的长度
        int count = collected.size();
        int base = count/n;
        int buffed = count%n;

        for(int i =0;i<n;i++){
            if(i+1<=buffed){
                list.add(base+1);
            }else {
                list.add(base);
            }
        }
        return list;
    }
}
