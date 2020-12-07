public class Program5 {
    public static void main(String[] args) {
        Program5 program5 = new Program5();
        // test case 1
        System.out.println(program5.repeatedSubstringPattern("abcabcabcabc"));
        // test case 2
        System.out.println(program5.repeatedSubstringPattern("aba"));
        // test case 3
        System.out.println(program5.repeatedSubstringPattern("aabcbaaabcbaaabcba"));
        // test case 4
        System.out.println(program5.repeatedSubstringPattern("ab"));
        // test case 5
        System.out.println(program5.repeatedSubstringPattern("a"));
    }

    private boolean repeatedSubstringPattern(String s) {
        if(s == null || s.equals("") || s.length() == 1) {
            return false;
        }
        String[] prefix = getPrefix(s);
        String[] suffix = getSuffix(s);
        for(int i = 0; i <= prefix.length/2; ++i) {
            if(prefix[i].equals(suffix[i]) && match(s, prefix[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean match(String source, String pattern) {
        if(source.length() % pattern.length() != 0) {
            return false;
        }
        int q = source.length() / pattern.length();
        String first = source.substring(0, pattern.length());
        for(int i = pattern.length(); i <= (q-1)*pattern.length(); i += pattern.length()) {
            if(!source.substring(i, i+pattern.length()).equals(first)) {
                return false;
            }
        }
        return true;
    }

    private String[] getPrefix(String s) {
        String[] res = new String[s.length() - 1];
        for(int i = 1; i < s.length(); ++i) {
            res[i-1] = s.substring(0, i);
        }
        return res;
    }

    private String[] getSuffix(String s) {
        String[] res = new String[s.length() - 1];
        for(int i = s.length()-1; i > 0; --i) {
            res[s.length()-1-i] = s.substring(i);
        }
        return res;
    }
}
