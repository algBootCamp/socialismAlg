public class Program_7 {

	public int findOnlyDulNumber(int arr[]) {
		
		//获取数组N+1个数的和
		int sumArr = 0;
		for (int i = 0; i < arr.length; i++) {
			sumArr += arr[i];
		}
		
		//1-n N个数的和  N = arr.length-1
		int sumN = (1+arr.length-1)*(arr.length-1)/2;
		
		
		//差为重复的数
		return sumArr-sumN;
	}
}
