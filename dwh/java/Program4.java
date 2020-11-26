package com.java.test_20_11_23;

import java.util.ArrayList;
import java.util.List;

public class Program4 {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4};
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node root = new Node();
        Node p = root;
        for (int i = 0; i < arr.length; i++){
            p.val = arr[i];
            if (i == arr.length - 1){
                p.next = null;
            }else {
                p.next = new Node();
                p = p.next;
            }
        }
        //size 表明有多少个成员
        //用例1
//        List<Node> list = splitList(root, 5);
        //用例2
        List<Node> list = splitList(root, 3);
    }

    private static List<Node> splitList(Node root, int k){
        List<Node> list = new ArrayList<>();
        int length = 0;
        Node p = root;
        while (p != null){
            length++;
            p = p.next;
        }
        if (length <= k){
            //分割1
            for (int i = 0; i < k; i++){
                Nodes nodes = cutOff(root, 1);
                list.add(nodes.q);
                root = nodes.p;
            }
        }else {
            //分割2以上 m为初次长度 n为 m+1 的个数
            int m = length / k;
            int n = length % k;
            for (int i = 0; i < k; i++){
                Nodes nodes = null;
                if (i < n){
                    nodes = cutOff(root, m+1);
                }else {
                    nodes = cutOff(root, m);
                }
                list.add(nodes.q);
                root = nodes.p;
            }
        }
        return list;
    }

    static Nodes cutOff(Node root, int k){
        Nodes nodes = new Nodes();
        Node head = new Node();
        Node p = head;
        for (int i = 0; i < k; i++){
            if (root != null){
                p.next = new Node(root.val);
                p = p.next;
                root = root.next;
            }else {
                nodes.p = root;
                nodes.q = root;
                return nodes;
            }
        }
        nodes.p = root;
        nodes.q = head.next;
        return nodes;
    }

    static class Node{
        int val;
        Node next;
        Node(){

        }
        Node(int val){
            this.val = val;
        }
    }
    /**
     单独的对于链表表的截取并不能 同时修改传入的root链表 所以需要设置一个类同时返回两个链表
     */
    static class Nodes{
        Node p;
        Node q;
    }

}

