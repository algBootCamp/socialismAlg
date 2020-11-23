package demo.test_20_11_16;

import java.util.Arrays;

/**
 * 给定一个无序整数 数组，求最长连续递增子序列的长度(子数组)
 */
public class Program2 {w
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 4, 7};
        int[] arr2 = {2, 2, 2, 2, 2};
        findNumberOfLIS(arr1);
        findNumberOfLIS(arr2);
        int[] nums3 = {1, 1, 1, 2, 2, 2, 3, 3, 3};
        findNumberOfLIS(nums3);
        // test case 4
        int[] nums4 = {1, 2, 4, 3, 5, 4, 7, 2};
        findNumberOfLIS(nums4);
    }

    private static int findNumberOfLIS(int[] nums){
        int n = nums.length;
        int maxLen = 1;
        int[] length = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        Arrays.fill(length, 1);
        length[0] = 1; count[0] = 1;
        for (int i = 1; i < n; i++){
            for (int j = i-1; j>=0; j--){
                if (nums[i] > nums[j]){
                    //以nums[i]结尾，当前一个数字nums[j]时  最大长度为：
                    //取最大长度 如果length[i]发生变动 count需要发生变动
                    if (length[j] + 1 > length[i]){
                        //长度加1 count不变
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                        continue;
                    }
                    if(length[i] == length[j] + 1) {
                        //length不变 count增加
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, length[i]);
        }
        //逻辑问题没有实时赋值length, 取maxLen代表最大  存在重复最大len 则累加
        int res = 0;
        for (int i = 0; i < n; i++){
            if (maxLen == length[i]){
                res += count[i];
                count[i] = res;
            }
        }
        //增加数组长度只会增大 length的长度
        System.out.print("length:" + maxLen);
        System.out.println("    count:" + res);

        return 0;
    }
/*
length:4    count:2
length:1    count:5
length:3    count:27
length:2    count:3
 */
}
