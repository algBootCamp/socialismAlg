package yajuan.xiao;

public class Program1 {
	public int findLengthOfLCIS(int[] nums) {

		if (nums.length == 0 || nums.length == 1 || nums == null) {
			return nums.length;
		}

		//要注意 递增序列长度 要在最开始算上第一个元素的长度
		int maxLen = 1;
		int tmp = 1;  
		int i = 0;
		while (i < nums.length - 1) {
			if (nums[i] < nums[i + 1]) {
				tmp += 1;
				i += 1;
				maxLen = (tmp > maxLen) ? tmp : maxLen;
			} else {
				tmp = 1; //理由同上
				i = i + 1;
			}
		}
		return maxLen;
	}
}
