public class Program7 {
    public static void main(String[] args) {
        Program7 program7 = new Program7();
        // test case 1
        int[] nums1 = {1,3,4,2,5,3};
        System.out.println(program7.findDuplicated(nums1));
        // test case 2
        int[] nums2 = {3,4,2,1,3,6,4};
        System.out.println(program7.findDuplicated(nums2));
        // test case 3
        int[] nums3 = {2,2,2};
        System.out.println(program7.findDuplicated(nums3));
    }

    private int findDuplicated(int[] nums) {
        int res = -1;
        if(nums != null && nums.length > 0) {
            label:
            for(int i = 0; i < nums.length; ++i) {
                // make nums[i] = i+1
                while(i != nums[i]-1) {
                    int tmp = nums[i];
                    nums[i] = nums[tmp-1];
                    nums[tmp-1] = tmp;
                    if(nums[i] == tmp) {
                        /*
                         * for i, this means:
                         * 1.nums[num[i]-1] = num[i]-1
                         * 2.nums[i] = num[i]-1
                         * 3.i and nums[i]-1 is not same index
                         * so tmp is duplicated
                         */
                        res = tmp;
                        break label;
                    }
                }
            }
        }
        return res;
    }
}
