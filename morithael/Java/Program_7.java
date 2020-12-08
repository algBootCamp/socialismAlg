import java.util.Arrays;
import java.util.Collections;

public class Program_7 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 1, 2, 3};
        int min = Arrays.stream(arr).min().getAsInt();
        int u = -min;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1){
                int tmp = arr[arr[i]+u];
                if (arr[arr[i]+u] == arr[i]) {
                    System.out.println(arr[i]);
                    return;
                } else {
                    arr[i] = tmp;
                }
            }
        }
    }
}
