public class Program_5 {
    public static void main(String[] args) {
        String str = "abcdabcdabcdabc1";
        char head = str.charAt(0);
        label1:
        for(int i=1; i < str.length(); i++){
            label2:
            if(head == str.charAt(i)){
                //先确定这个i模之内是重合的
                for(int k=1;k<i;k++){
                    if(str.charAt(k) != str.charAt(k+i)){
                        System.out.println("从小循环错误判断,循环的摸不是"+i);
                        //怎么换个i继续战斗
                        break label2;
                    }
                }
                //再从能不能整除的角度看是不是这个i.
                if (str.length()%i != 0){
                    System.out.println("从不能整除角度判断,循环的摸不是"+i);
                    continue;
                }
                //再确定整个串都是在重复这个小序列
                int count = str.length()/i;
                for(int l = 1; l < count; l++){
                    for(int j = 0; j< i;j++) {
                        if (str.charAt(j) != str.charAt(j + l * i)) {
                            System.out.println("狗屁不是");
                            break label1;
                        }
                    }
                }
                System.out.println("模是"+i);
                return;

            }else if( i >= str.length()/2){
                System.out.println("狗屁不是");
                return;
            }
        }
    }
}
