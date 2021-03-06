/**
 * DESCRIPTION:
 * CLASS: Program15
 * DATE: 2021/2/28 10:09
 *
 * @author chengyujia
 */
public class Program15 {
    public static void main(String[] args) {
        Program15 program15 = new Program15();
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;
        System.out.println(program15.maxSatisfied(customers, grumpy, 3));
    }

    private int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int left = 0, right = 0;
        int max = 0, total = 0, window = 0;
        int n = grumpy.length;
        while (right < n) {
            // count in each "zero"
            total += (1 - grumpy[right]) * customers[right];
            window += grumpy[right] * customers[right];
            // slide window, keep size of X
            if (right - left == X) {
                window -= grumpy[left] * customers[left++];
            }
            max = Math.max(max, window);
            right++;
        }
        return total + max;
    }
}
