/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/submissions/
 * 从矩阵右上角元素开始搜索，若当前值>目标值，左移一列(当前列和右侧列必>目标值)；若当前值<目标值，下移一行(当前行和上侧行必<目标值)
 */
public class Program13 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null || matrix.length == 0 || matrix[0].length==0){
            return false;
        }
        int rIdx = 0;
        int cIdx = matrix[0].length-1;
        while (rIdx < matrix.length && cIdx >= 0){
            if(matrix[rIdx][cIdx] == target){
                return true;
            }else if(matrix[rIdx][cIdx] > target){
                cIdx --;
            }else {
                rIdx ++;
            }
        }
        return false;
    }

//    //并不会用到二分 - -
//    public static int binarySearch(int[] arr, int target, int start, int end){
//        int indx = (start+end)/2;
//        if(arr[indx] == target){
//            return indx;
//        }
//        if(start == end){
//            return arr[indx] < target? indx : indx-1;
//        }
//        if(arr[indx] > target){
//            return binarySearch(arr, target, start,indx-1);
//        }else {
//            return binarySearch(arr, target, indx+1, end);
//        }
//    }


}
