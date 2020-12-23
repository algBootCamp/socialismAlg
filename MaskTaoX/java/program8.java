import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class program8 {
    public static void main(String[] args) {
        int nums[]={-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result=find(nums);
        System.out.println(result.toString());
    }

    /**
     *
     * @param nums
     * @return
     */
    static List<List<Integer>> find(int[] nums){
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(nums);//由大到小排序
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;// i quchong
            int target=-nums[i];//
            int j=i+1;//头指针
            int k=nums.length-1;//尾指针
            while(j<k){
                if(nums[j]+nums[k]==target){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    result.add(curr);
                    //指针移动
                    j++;
                    k--;
                    //左指针 如果当前指针的值与上一个相同 指针左移
                    while(j<nums.length&&nums[j]==nums[j-1]){j++;}
                    while(k>j&&nums[k+1]==nums[k]){k--;}
                }else if(nums[j]+nums[k]>target){
                    //大于目标右指针左移让和变小
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }
}
