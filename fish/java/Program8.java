import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program8 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums != null && nums.length >= 3) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > 0) {
                    break;
                }
                int target = -nums[i];
                int front = i + 1, rear = nums.length - 1;
                while (front < rear) {
                    if (nums[front] + nums[rear] < target) {
                        front++;
                    } else if (nums[front] + nums[rear] > target) {
                        rear--;
                    } else {
                        List<Integer> bucket = new ArrayList<>();
                        bucket.add(nums[i]);
                        bucket.add(nums[front]);
                        bucket.add(nums[rear]);
                        res.add(bucket);
                        while (front < rear && nums[front] == bucket.get(1)) front++;
                        while (front < rear && nums[rear] == bucket.get(2)) rear--;
                    }
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }
}
