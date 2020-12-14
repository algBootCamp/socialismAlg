public class Program7 {
    //n+1个数组元素求和，减去sum(1,2,3...n)
    public static int find(int [] arr){
        for(int i =0; i< arr.length-1; i++){
            arr[arr.length-1] += arr[i];
        }
        arr[arr.length-1] -= (arr.length-1)*arr.length/2;
        return arr[arr.length-1];
    }

    //以索引0为入口，将访问的元素值作为下一个索引，将已访问元素标记为相反数，重复访问某元素时的索引即为所求
    public static int find2(int [] arr){
        int index = 0;
        while (true){
            if(arr[index] < 0){ //判断元素是否被访问过
                return index;
            }
            arr[index] *= (-1); //将已访问元素标记为相反数
            index = arr[index] * (-1); //将访问的元素值作为下一个索引
        }
    }

    public static void main(String[] args){
        int[] arr={1,3,4,2,5,3};
        int res1 = find(arr);
        int res2 = find2(arr);
        System.out.println(res1 + "  " + res2);
    }
}
