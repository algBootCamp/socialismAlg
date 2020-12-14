import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program_8 {

	public List<List<Integer>> sum3(int[] arr) {

		Arrays.sort(arr);
		// System.out.println(Arrays.toString(arr));

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len = arr.length;

		if (arr == null || len < 3) {
			return result;
		}
		// 双指针
		for (int pivot = 0; pivot <= len - 3; pivot++) {
			if (arr[pivot] > 0) { // 最左边数>0,结束寻找
				break;
			}
			if (pivot > 0 && (arr[pivot] == arr[pivot - 1])) { // 去重
				continue;
			}

			int left = pivot + 1;
			int right = len - 1;

			while (left < right) {
				int sum = arr[pivot] + arr[left] + arr[right];
				// System.out.println(" " + arr[pivot] + " " + arr[left] + " " + arr[right]);
				// System.out.println("和为：" + sum);
				if (sum < 0) {
					left += 1;

				} else if (sum > 0) {
					right -= 1;

				} else {
					result.add(new ArrayList<Integer>(Arrays.asList(arr[pivot], arr[left], arr[right])));
					System.out.println("result:" + result);
					while (left < right && arr[left] == arr[left + 1]) { //去重
						left += 1;
					}
					while (left < right && arr[right] == arr[right - 1]) {//去重
						right -= 1;
					}
					left += 1;
					right -= 1;
				}
			}
		}

		return result;
	}
}
