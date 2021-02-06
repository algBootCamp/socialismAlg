package com.java.test_20_12_21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Program11 {
    public static void main(String[] args){
//        Integer[] arr = {1,2,2,3,4,4,3};
//        Integer[] arr = {1,2,2,null,3,null,3};
        Integer[] arr = {1,2,3};
        TreeNode root = new TreeNode(arr[0]);
        root.buildTree(arr, 0);
        System.out.println(root.val);
        System.out.println(isSymmetric(root));
    }

    /**
     * index 0
     * depth n 从1开始，去除根节点  total: 2^(n+1) -1
     * left  2^n -1 -- 2^n-1+2^(n-1)
     * right 2^n + 2^(n-1)  -- 2^(n+1) -1
     * tree -- root
     * left and right is exist
     * left.left or right exist
     *
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        List<Integer> list = print(root);
        //index
        int i = 1;
        int n = 1;
        while (i < list.size()){
            n++;
            int left = i;
            int right = (int) (Math.pow(2, n) -2);
            for (int j = 0; j < Math.pow(2, n-2); j++){
                if (list.get(left + j) != null && list.get(right - j) != null
                        || list.get(left + j) == null && list.get(right - j) == null) {
                    continue;
                } else {
                    return false;
                }
            }
            i = (int) (i + Math.pow(2, n-1));
        }

        return true;
    }
    public static List<Integer> print(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            if (p == null){
                list.add(null);
                System.out.print(null + " ");
                continue;
            }
            list.add(p.val);
            System.out.print(p.val + " ");
            if (p.left != null || p.right != null){
                queue.offer(p.left);
                queue.offer(p.right);
            }
        }
        int n = (int) Math.sqrt(list.size()) +1;
        int i = list.size();
        while (i < Math.pow(2, n) -1){
            list.add(null);
            i++;
        }
        return list;
    }
}
