import java.util.*;

public class Program_1 {
    public static void main(String[] args){
        ArrayList<Integer> rea =new ArrayList<>(Arrays.asList(1,3,5,4,7));
        int longestCountMark = 0;
        int countMark = 0;
        int numberMark = 0;

        for(Integer i :rea){
            if (i>numberMark){
                countMark +=1;
                numberMark = i;
                if(countMark>longestCountMark){
                    longestCountMark = countMark;
                }
            }else{
                countMark = 1;
                numberMark = i;
            }
        }
        System.out.println(longestCountMark);
    }
}
