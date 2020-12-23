package com.java.test_20_12_14;

import java.util.LinkedList;
import java.util.Queue;

public class Program10 {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};
        Node root = new Node(arr[0]);
        root = buildTree(arr, root, 0);

        printTree(root);
    }

    private static void printTree(Node root){
        Queue<Node> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            Node p = queue.poll();
            System.out.print(p.val+ " ");
            if (p.left != null){
                queue.offer(p.left);
            }
            if (p.rigth != null){
                queue.offer(p.rigth);
            }
        }
    }

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
    }
}