public class Program7 {

    public static void main(String[] args) {
        int[] ints1 = new int[]{1, 2, 3, 4, 5, 4};
        System.out.println(findPair(ints1));
        int[] ints2 = new int[201];
        for (int i = 0; i < 200; i++) {
            ints2[i] = i + 1;
        }
        ints2[200] = 5;
        System.out.println(findPair(ints2));
    }

    static int findPair(int[] ints) {
        int len = ints.length;
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            res = res ^ i;
            res = res ^ ints[i - 1];
        }
        return res ^ ints[len - 1];
    }
}
