import java.util.ArrayList;
import java.util.List;

public class program3 {
    public static void main(String[] args) {
        //创造列表
        int[] arr ={1,3,1,5,5,7};
        Node head= new Node(arr[0]);
        Node flag=null;//游标
        flag=head;
        for(int i=1;i< arr.length;i++){
            flag.next=new Node(arr[i]);
            flag=flag.next;
        }
        head.tostring();//列表创建
        removeRep(head);
        head.tostring();
    }

    public static void removeRep(Node head){
        List<Integer> list = new ArrayList<>();
        list.add(head.value);
        Node n =head.next;//后坐标
        Node p = head;//前坐标
        while(n!=null){
            if(list.contains(n.value)){
                //重复
                p.next=n.next;//跳过重复节点
            }else{
                list.add(n.value);
                p=n;//前坐标后移
            }
            n=n.next;//后坐标后移
        }
    }
}

class Node{
    int value;
    Node next;
    Node(int val){
        this.value=val;
        this.next=null;
    }
    void tostring(){
        Node p= this;
        while(p!=null){
            if(p.next==null) {
                System.out.println(p.value );
            }else{
                System.out.print(p.value + "->");
            }
            p=p.next;
        }
    }
}