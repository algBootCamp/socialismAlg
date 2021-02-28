import java.util.*;

/**
 * DESCRIPTION:
 * CLASS: Program16
 * DATE: 2021/2/28 10:14
 *
 * @author chengyujia
 */
public class Program16 {
    public static void main(String[] args) {
        Program16 program16 = new Program16();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(program16.medianSlidingWindow(nums, 3)));
        System.out.println(Arrays.toString(program16.medianSlidingWindow(nums, 2)));
        System.out.println(Arrays.toString(program16.medianSlidingWindow(new int[]{1,2,3,4,2,3,1,4,2}, 3)));
    }

    private double[] medianSlidingWindow(int[] nums, int k) {
        MedianQueue dh = new MedianQueue(k);
        for (int i = 0; i < k; ++i) {
            dh.insert(nums[i]);
        }
        double[] ans = new double[nums.length - k + 1];
        ans[0] = dh.getMedian();
        for (int i = k; i < nums.length; ++i) {
            dh.insert(nums[i]);
            dh.delete(nums[i - k]);
            ans[i - k + 1] = dh.getMedian();
        }
        return ans;
    }

    static class MedianQueue {
        private static final Comparator<Integer> COMPARATOR = Integer::compareTo;
        // small is a maximum-heap, large is a minimum-heap
        private final PriorityQueue<Integer> small;
        private final PriorityQueue<Integer> large;
        // for delay-remove
        private final Map<Integer, Integer> delayed;
        private final int k;
        private int smallSize, largeSize;

        public MedianQueue(int k) {
            this.small = new PriorityQueue<>(COMPARATOR.reversed());
            this.large = new PriorityQueue<>(COMPARATOR);
            this.delayed = new HashMap<>();
            this.k = k;
            this.smallSize = 0;
            this.largeSize = 0;
        }

        void insert(int num) {
            if (small.isEmpty() || num <= small.peek()) {
                smallSize++;
                small.offer(num);
            } else {
                largeSize++;
                large.offer(num);
            }
            makeBalance();
        }

        void delete(int num) {
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);
            if (!small.isEmpty() && num <= small.peek()) {
                smallSize--;
                if (small.peek() == num) {
                    prune(small);
                }
            } else if (!large.isEmpty()) {
                largeSize--;
                if (large.peek() == num) {
                    prune(large);
                }
            }
            makeBalance();
        }

        void makeBalance() {
            if (smallSize > largeSize + 1) {
                smallSize--;
                largeSize++;
                large.offer(small.poll());
                prune(small);
            } else if (largeSize > smallSize) {
                smallSize++;
                largeSize--;
                small.offer(large.poll());
                prune(large);
            }
        }

        void prune(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty()) {
                int num = heap.peek();
                if (delayed.containsKey(num)) {
                    delayed.put(num, delayed.get(num) - 1);
                    if (delayed.get(num) == 0) {
                        delayed.remove(num);
                    }
                    heap.poll();
                } else {
                    break;
                }
            }
        }

        double getMedian() {
            assert !small.isEmpty() && !large.isEmpty();
            return (k & 1) == 0 ? (small.peek() + large.peek()) / 2.0 : small.peek();
        }
    }
}
