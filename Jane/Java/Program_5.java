import java.util.ArrayList;

class Program_5 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        ArrayList<Integer> lis = new ArrayList();
        for(int i=1; i<(n/2 + 1); i++){
            if (n % i == 0){
                lis.add(i);
            }
        }

        for(int i=0; i<lis.size(); i++){
            String res = "";
            String tmp = s.substring(0,lis.get(i));
            for(int j=0;j<n/lis.get(i); j++){
                res += tmp;
            }
            if(res.equals(s)){
                return true;
            }
        }
        return false;
    }
}