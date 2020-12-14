package com.java.test_20_12_7;

public class Program7 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,5,3};
        System.out.println(findNum(nums));
    }

    /**
     * 思路： 将数组中的所有元素累加，然后减去 正常从1-n的和
     *         得到的结果就是数组中多出来的那个元素。
     *         注意:nums.length 的大小为 n+1
     */
    private static int findNum(int[] nums){
        int num = 0;
        for (int i = 0; i < nums.length; i++){
            num += nums[i];
        }
        num = num - (nums.length - 1) * nums.length / 2;
        return num;
    }
}
