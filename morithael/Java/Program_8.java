import java.util.*;

public class Program_8 {
    public static void main(String[] args) {
//        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, -4));
        Set<List<Integer>> res = new HashSet<>();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int len = nums.length;
        for(int i =0;i<len-3;i++){
            for (int j = i+1;j<len-2;j++){
                for(int k = j+1;k<len-1;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> tmp = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
                        tmp.sort(Comparator.comparing(Integer::intValue));
                        res.add(tmp);
                    }
                }
            }
        }

        System.out.println(res);



    }
}
