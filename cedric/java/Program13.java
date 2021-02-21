/**
 * DESCRIPTION:
 * CLASS: Program13
 * DATE: 2021/2/21 16:14
 *
 * @author chengyujia
 */
public class Program13 {
    public static void main(String[] args) {
        Program13 program13 = new Program13();
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(program13.findTarget(matrix, 5));
        System.out.println(program13.findTarget(matrix, 20));
    }

    private boolean findTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1;
        while (r < rows && c >= 0) {
            if (matrix[r][c] < target) {
                r++;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                return true;
            }
        }
        return false;
    }
}
