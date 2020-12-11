import java.util.HashMap;
import java.util.Map;

public class Program6 {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));

        System.out.println(lengthOfLongestSubstring("bbbbb"));

        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character,String> set = new HashMap();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.containsKey(s.charAt(j))) {
                set.put(s.charAt(j++),"");
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
