package com.java.test_20_12_14;

import java.util.LinkedList;
import java.util.Queue;

public class Program9 {
    public static void main(String[] args){
        Integer[] arr = {1,2,2,3,3,null,null,4,4};
//        Integer[] arr = {3,9,20,null,null,15,7};
        Node root = new Node(arr[0]);
        root = buildTree(arr, root, 0);
        System.out.println(isTree(root));

    }
    private static boolean isTree(Node root){
        if (root == null){
            return true;
        }

        if (Math.abs(deptTree(root.left) - deptTree(root.rigth)) >= 2){
            return false;
        }
        return isTree(root.left) && isTree(root.rigth);
    }
    private static int deptTree(Node root){
        if (root == null){
            return 0;
        }
        return Math.max(deptTree(root.left), deptTree(root.rigth)) + 1;
    }

    //index 从0开始，左节点2i+1 ; 右节点 2i+2

    private static Node buildTree(Integer[] arr, Node root, int index){
        if (root == null){
            return null;
        }
        if (arr.length > 2 * index + 1){
            if (arr[2*index+1] == null){
                root.left = null;
            }else {
                root.left = new Node(arr[2*index+1]);
                buildTree(arr, root.left, 2*index +1);
            }
        }
        if (arr.length > 2 * index + 2){
            if (arr[2*index+2] == null){
                root.rigth = null;
            }else {
                root.rigth = new Node(arr[2*index+2]);
                buildTree(arr, root.rigth, 2*index +2);
            }
        }
        return root;
    }


    static class Node{
        int val;
        Node left;
        Node rigth;
        Node(Integer val){
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", rigth=" + rigth +
                    '}';
        }
    }
}


