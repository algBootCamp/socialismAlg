
//无重复最长子串
public class Program_6 {
    public static void main(String[] args) {
        String str = "bbbbba";
        int max =0;
        int length = str.length();
        int start = 0;
        int end = 0;
        while (end <length){
            char tmp = str.charAt(end);
            if(!subContain(str,tmp,start,end)){
                end++;
                if(end == length){
                    int continued = end - start;
                    if(continued > max){
                        max = continued;
                    }
                }
            }else {
                int continued = end - start;
                if(continued > max){
                    max = continued;
                }
                start += 1;
            }
        }
        System.out.println(max);
    }

    private static boolean subContain(String str,char chr, int start, int end){
        for(int i =start; i< end; i++){
            if(chr == str.charAt(i)){
                return true;
            }
        }
        return false;
    }

}
