import java.util.*;

public class Program_2 {
    public static void main(String[] args){
        ArrayList<Integer> rea =new ArrayList<>(Arrays.asList(2,2,2));
        //记录最长的子列长度
        int longestCountMark = 0;
        //循环中，连续递增数量
        int countMark = 0;
        //循环中，刚刚经过的元素的数值
        int numberMark = 0;
        //有记录的，最长的子列长度，达到这个长度的子列个数
        int countLongestSub = 1;

        for(Integer i :rea){
            if (i>numberMark){
                countMark +=1;
                numberMark = i;
                if(countMark>longestCountMark){
                    longestCountMark = countMark;
                    countLongestSub = 1;
                }else if(countMark == longestCountMark){
                    countLongestSub += 1;
                }
            }else{
                countMark = 1;
                numberMark = i;
            }
        }
        if (countLongestSub ==1){
            countLongestSub = rea.size();
        }
        System.out.println(countLongestSub);
    }
}
