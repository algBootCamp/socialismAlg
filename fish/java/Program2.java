import java.util.HashMap;
import java.util.Map;

public class Program2 {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 2, 3, 3, 3,};
        System.out.println(nlis(nums1));
        int[] nums2 = {-1, 2, 4, 0, 5, 1, 6, 3, 4, 5, 7};
        System.out.println(nlis(nums2));
    }

    public static int nlis(int[] ints) {
        if (ints == null || ints.length == 0) {
            return 0;
        }
        int[] dp = new int[ints.length];
        int[] len = new int[ints.length];
        dp[0] = 1;
        len[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < ints.length; i++) {
            dp[i] = 1;
            Map<Integer, Integer> tmp = new HashMap<>();
            tmp.put(1, 1);
            for (int j = 0; j < i; j++) {
                if (ints[i] > ints[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (tmp.containsKey(dp[j] + 1)) {
                        tmp.put(dp[j] + 1, tmp.get(dp[j] + 1) + len[j]);
                    } else {
                        tmp.put(dp[j] + 1, len[j]);
                    }
                }
            }
            len[i] = tmp.get(dp[i]);
            maxLen = Math.max(dp[i], maxLen);
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxLen) {
                res += len[i];
            }
        }
        return res;
    }
}
