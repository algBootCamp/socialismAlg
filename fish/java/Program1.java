public class Program1 {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 5, 6, 7};
        System.out.println(lcis(nums1));
        int[] nums2 = {2, 4, 5, 1, 2, 3, 4, 5};
        System.out.println(lcis(nums2));
    }

    public static int lcis(int[] ints) {
        if (ints == null || ints.length == 0) {
            return 0;
        }
        int max = 1;
        int start = 0;
        int len = ints.length;
        for (int end = 1; end < len; end++) {
            if (ints[end] > ints[end - 1]) {
                continue;
            } else {
                max = Math.max(end - start, max);
                start = end;
            }
        }
        max = Math.max(len - start, max);
        return max;
    }
}
