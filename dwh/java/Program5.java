package com.java.test_20_11_30;

public class Program5 {
    public static void main(String[] args) {
        String str = "abcabcabcabc";
        boolean flag = fun(str);
        System.out.println(flag);
        String str2 = "abab";
        System.out.println(fun(str2));
        System.out.println(fun("str2"));
    }

    private static boolean fun(String str){
        int n = str.length();
        //遍历到一半位置即可 中间位置需要遍历
        for (int i = 1; i <= n/2; i++){
            String s = str.substring(0, i);
            int start = i;
            int end = i;
            //在字符串长度范围内遍历，如果出现截取长度大于匹配项，无需进行之后的遍历
            while (end <= n && end - start <= s.length()){
                //查看当前截取的字符与匹配项相同，然后往下继续遍历
                if (s.equals(str.substring(start, end))){
                    start = end;
                }
                end++;
            }
            //当满足最后一个遍历也与匹配项相同时，输出true
            if (start == n){
                return true;
            }
        }
        return false;
    }

}

