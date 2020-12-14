package com.java.test_20_12_7;

import java.util.*;

public class Program8 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<int[]> list = threeSum(nums);
        System.out.println(Arrays.toString(list.get(0)));
    }

    /**
     * 同一元素不能算作两次
     */
    private static List<int[]> threeSum(int[] nums){
        int n = nums.length;
        if (n < 3){
            return null;
        }
        //数组排序
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<int[]> list = new ArrayList<>();
        for (int i  = 0; i < n-1; i++){
            a:for (int j = i+1; j < n-1; j++){
                for (int k = j+1; k < n; k++){
                    //在三个数字相加为0的前提下
                    if (nums[i] + nums[j] + nums[k] == 0){
                        //判断list中是否存在对应的三个子元素都相同的元素
                        for (int l = 0; l < list.size(); l++){
                            if (list.get(l)[0] == nums[i] && list.get(l)[1] == nums[j]
                                    && list.get(l)[2] == nums[k]){
                                continue a;
                            }
                        }
                        //如果没有则往list中加入一个元素 而且跳到最外层循环
                        list.add(new int[]{nums[i], nums[j], nums[k]});
                        continue a;
                    }
                }
            }
        }
        return list;
    }
}
