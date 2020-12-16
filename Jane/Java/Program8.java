import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode-cn.com/problems/3sum/
public class Program8 {
    public static List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        Arrays.sort(nums); //排序
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){  //第一重循环
            if(i>0 && nums[i] == nums[i-1]){  //去重
                continue;
            }
            int k = n-1;
            int target = -nums[i];
            for(int j = i+1; j<n; j++){  //第二重循环  指针1
                if(j>i+1 && nums[j]==nums[j-1]){ // 去重：1. 保证arr[j]>arr[i] 2.相邻重复元素不重复遍历
                    continue;
                }
                while (j<k && nums[j]+nums[k]>target){  //指针2 倒序遍历
                    k--;
                }
                if(j == k){
                    break;
                }
                if(nums[j]+nums[k]==target){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    ans.add(tmp);
                }
            }
        }
        return ans;
    }


}
