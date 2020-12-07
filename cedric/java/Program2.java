public class Program2 {
    public static void main(String[] args) {
        Program2 program2 = new Program2();
        // test case 1
        int[] nums1 = {1, 3, 5, 4, 7};
        System.out.println(program2.lis(nums1));
        // test case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println(program2.lis(nums2));
        // test case 3
        int[] nums3 = {1, 1, 1, 2, 2, 2, 3, 3, 3};
        System.out.println(program2.lis(nums3));
        // test case 4
        int[] nums4 = {1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(program2.lis(nums4));
    }

    private int lis(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // maxLen means the length of longest increasing sequence
        int size = nums.length, maxLen = 1;
        /*
         * dp[i] means the length of longest increasing sequence ending with i
         * count[i] means the count of sequences which equals to the length of longest increasing sequence ending with i
         * max[i] has same meaning with dp
         */
        int[] dp = new int[size], count = new int[size], max = new int[size];
        int res = 0;
        // initialize to 1
        for (int i = 0; i < size; ++i) {
            dp[i] = 1;
            count[i] = 1;
            max[i] = 1;
        }
        for (int i = 1; i < size; ++i) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    if(max[i] < dp[i]) {
                        max[i] = dp[i];
                        count[i] = count[j];
                        continue;
                    }
                    if(max[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        for(int i = 0; i < size; ++i) {
            if(dp[i] == maxLen) {
                res += count[i];
            }
        }
        return res;
    }
}
