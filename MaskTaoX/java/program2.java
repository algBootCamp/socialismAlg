import java.util.Arrays;

public class program2 {
    public static void main(String[] args) {
        int[] a={1,2,3,5,4,6,3,4};//{1,2,3,5,6}{1,2,3,4,6}
        System.out.println(lrr(a));
        int[] b={1,3,5,4,7};
        System.out.println(lrr(b));
        int[] c={1,1,1,1,1};
        System.out.println(lrr(c));
    }

    public static int lrr(int[] arr){
        int len = arr.length;
        int[] dp=new int[len];//最大长度
        int[] count = new int[len];//该长度出现次数
        int maxlen=0;
        int num=0;
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i =1;i<len;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j]){
                    //第一次出现
                    if(dp[j]+1>dp[i])
                    {
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }
                    //再次出现 count记录
                    else if(dp[j]+1==dp[i]){
                        count[i]+=count[j];
                    }
                }
            }
            maxlen=Math.max(maxlen,dp[i]);//最大长度
        }
        //统计所有最大长度的个数相加
        for(int i=0;i<len;i++){
            if(dp[i]==maxlen)
            {
                num+=count[i];
            }
        }
        return num;
    }
}
