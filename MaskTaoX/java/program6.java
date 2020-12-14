import java.util.LinkedList;

public class program6 {
    public static void main(String[] args) {
        String a = "abcabcbb";
        String b ="pwwkew";
        System.out.println(judge(a));
        System.out.println(judge(b));
    }

    /**
     * 用一个队列 新元素加在队尾 重复元素从队头开始删除 删除至重复位置 后将重复元素加入队尾组成新子串
     * @param a
     * @return
     */
    static int judge(String a){
        int max=0;
        LinkedList<Character> list = new LinkedList<>();
        for(int i =0 ;i<a.length();i++){
            if(!list.contains(a.charAt(i))){
                //如果队列里没有这个元素 添加到队尾
                list.addLast(a.charAt(i));
            }else{
                //如果有这个元素
                //首先更新一下最大值
                max=Math.max(max,list.size());
                while(list.peekFirst()!=a.charAt(i)){
                    //删除队列中该元素之前的全部元素
                    list.removeFirst();
                }
                //删除到重复元素位置 跳出循环 再将该元素删除
                list.removeFirst();
                //将该元素加入队尾 作为新子串的一部分
                list.addLast(a.charAt(i));
            }
        }
        max=Math.max(max,list.size());
        return max;
    }

}
