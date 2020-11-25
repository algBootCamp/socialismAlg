package com.java.test_20_11_23;

import java.util.ArrayList;
import java.util.List;

public class Program3{
    public static void main(String[] args) {
//        int[] arr = {1, 3, 1, 5, 5, 7};
        int[] arr = {};
        Node header = null;
        if (arr.length > 0){
            header = new Node(arr[0]);
            Node p = header;
            for (int i = 1; i < arr.length; i++){
                p.next = new Node(arr[i]);
                p = p.next;
            }
        }
        //toString表示打印到控制台 并非实际输出
        header.toSting();
        removeDuplicate(header).toSting();
    }

    private static Node removeDuplicate(Node header){
        if (header == null){
            return header;
        }
        List<Integer> list = new ArrayList<Integer>();
        Node p = header;
        list.add(p.value);
        while (p.next != null){
            if (list.contains(p.next.value)){
                p.remove(p.next);
            }else {
                list.add(p.next.value);
                p = p.next;
            }
        }

        return header;
    }

    static class Node{
        int value;
        Node next;
        Node(){

        }
        Node(int value){
            this.value = value;
            this.next = null;
        }
        void remove(Node q){
            this.next = q.next;
        }
        void toSting(){
            Node p = this;
            while (p != null){
                System.out.print(p.value + " ");
                p = p.next;
            }
            System.out.println();
        }
    }
}