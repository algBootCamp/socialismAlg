public class Program5 {
    public static void main(String[] args) {
        String s = "";
        System.out.println(repeatedSubstringPattern(s));
    }

    static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int t, i;
        for (t = 1; t <= len / 2; ++t) {
            if (len % t != 0)
                //不能整除肯定不是
                continue;
            i = 0;
            while ((i < len - t) && (s.charAt(i) == s.charAt(i + t)))
                i++;
            if (i == len - t)//全部符合
                return true;
        }
        return false;
    }

}
