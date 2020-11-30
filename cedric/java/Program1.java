public class Program1 {
    public static void main(String[] args) {
	Program1 program1 = new Program1();
        // test case 1
        int[] nums1 = {1, 3, 5, 4, 7};
        System.out.println(program1.lcis(nums1));
        // test case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println(program1.lcis(nums2));
    }

    private int lcis(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int size = nums.length, max = 1;
        int[] dp = new int[size];
        dp[0] = 1;
        for(int i = 1; i < size; ++i) {
            if(nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
