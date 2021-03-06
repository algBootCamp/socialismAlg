/**
 * https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 * 滑动窗口
 */
public class Program15 {

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //记录不使用秘密技巧，不生气服务的顾客总数
        int sumbase = 0;
        //遍历一边，计算sumbase
        for(int i=0; i<customers.length ;i++){
            sumbase += (1-grumpy[i])*customers[i];
            //将不生气时对应的customer值改为0，便于后续滑动窗口计算
            if(grumpy[i]==0){
                customers[i] = 0;
            }
        }
        //记录在一个长度X的窗口内，使用秘密技巧后，新增不生气服务顾客数最大值
        int addMax = 0;
        //计算滑动窗口初始值
        for(int i=0;i<X;i++){
            addMax += customers[i];
        }
        //记录上一个窗口内，使用秘密技巧后，新增不生气服务顾客数最大值
        int addPre = addMax;
        for(int i=X; i<customers.length; i++){
            int addNew = addPre + customers[i] - customers[i-X];
            if(addNew > addMax){
                addMax = addNew;
            }
            addPre = addNew;
        }
        return sumbase + addMax;
    }

    //我自己写的 有点绕了
    public static int maxSatisfiedMy(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int sumbase = 0;
        int addMax = 0;
        for(int i=0;i<X;i++){
            addMax += grumpy[i]*customers[i];
        }
        int addPre = addMax;
        for(int i=0;i<len;i++){
            sumbase += (1-grumpy[i])*customers[i];
            if(i>0 && i<len-X+1){
                int sumaddNew = addPre + grumpy[i+X-1]*customers[i+X-1] - grumpy[i-1]*customers[i-1];
                addMax = addMax>=sumaddNew? addMax : sumaddNew;
                addPre = sumaddNew;
            }
        }
        return sumbase + addMax;
    }

    public static void main(String[] args){
        int[] customers = {5,8};
        int[] grumpy =    {0,1};
        int X = 1;
        int res = maxSatisfied(customers, grumpy, X);
    }
}
