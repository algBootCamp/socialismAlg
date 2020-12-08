import java.util.*;

//无重复最长子串
public class Program_6 {
    public static void main(String[] args){
        int max = 0;
        String str = "pwwkew";
        int length = str.length();
        int start = 0;
        int i = 0;
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (i = 0; i < length; i++){
            char tmp = str.charAt(i);
            if (lastIndex.containsKey(tmp)){
                int continued = i - start;
                if (continued > max){
                    max = continued;
                }
                start = lastIndex.get(tmp) + 1;
            }else if(i == (length -1)){
                int continued = i - start +1;
                if (continued > max){
                    max = continued;
                }
            }
            lastIndex.put(tmp, i);
        }
        System.out.println(max);
    }
}
