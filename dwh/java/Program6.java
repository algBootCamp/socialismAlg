package com.java.test_20_11_30;

public class Program6 {
    public static void main(String[] args) {
        String str = "abcabcabcabc";
        System.out.println(fun(str));
        String str2 = "abab";
        System.out.println(fun(str2));
        System.out.println(fun("dyaidaiudh"));
    }
    //总str  子串s  匹配节点index

    private static int fun(String str){
        int n = str.length();
        if (n == 0){
            return 0;
        }
        //存储最大的子串长度， 最小值为1
        int maxStr = 1;
        for (int i = 0; i < n; i++){
            int maxL = 1;
            for (int j = i+1; j < n; j++){
                if (checkStr(str.substring(i, j), str.charAt(j))){
                    break;
                }else {
                    maxL++;
                }
            }
            // 用来存储从i开始的最长子串的长度 进行比较取最大值
            maxStr = Math.max(maxStr, maxL);
        }
        return maxStr;

    }
    //判断当前的字符是否与子串中相同

    private static boolean checkStr(String str, char c){
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == c){
                return true;
            }
        }
        return false;
    }
}

