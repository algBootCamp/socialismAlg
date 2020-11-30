public class program1 {
    public static void main(String[] args) {
        int[] arr1={1,3,5,7,4,6};
        System.out.println(lc(arr1));

        int[] arr2={1,3,7,4,6,7,8,9};
        System.out.println(lc(arr2));

        int[] arr3={1,1,1,1};
        System.out.println(lc(arr3));
    }

    public static int lc(int[] arr){
        int max=1;
        int now=1;
        int len=arr.length;
        for(int i=1;i<len;i++){
            if(arr[i]>arr[i-1])
            {
                now++;
            }else{
                max=Math.max(now,max);
                now=1;
            }
        }
        max = Math.max(now, max);//
        return max;
    }
}
