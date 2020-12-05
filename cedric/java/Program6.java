import java.util.HashMap;
import java.util.Map;

public class Program6 {
    public static void main(String[] args) {
        Program6 program6 = new Program6();
        // test case 1
        System.out.println(program6.lengthOfLongestSubstring("abcabcbb"));
        // test case 2
        System.out.println(program6.lengthOfLongestSubstring("bbbbb"));
        // test case 3
        System.out.println(program6.lengthOfLongestSubstring("pwwkew"));
    }

    private int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int size = s.length(), left = -1, maxLen = 0;
        Map<Character, Integer> indexes = new HashMap<>();
        for(int i = 0; i < size; ++i) {
            if(indexes.containsKey(s.charAt(i))) {
                int j = indexes.get(s.charAt(i));
                left = Math.max(left, j);
            }
            indexes.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i-left);
        }
        return maxLen;
    }
}
