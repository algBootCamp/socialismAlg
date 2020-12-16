public class program7 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,5,3};
        System.out.println(find(nums));
    }

    static int find(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int re=sum-(nums.length-1)*nums.length/2;
        return re;
    }
}
