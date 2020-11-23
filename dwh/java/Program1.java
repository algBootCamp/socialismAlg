package demo.test_20_11_16;

public class Program1 {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 4, 7};
        int[] arr2 = {2, 2, 2, 2, 2};
        System.out.println(maxInt(arr2));
    }

    private static int maxInt(int[] arr){
        int count = 1;
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i + 1] > arr[i]){
                count++;
            }else {
                if(count > max){
                    max = count;
                    count = 0;
                }
            }
        }
        return max;
    }
}