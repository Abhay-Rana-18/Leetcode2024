class Solution {
    public int minimumLength(String s) {

        int st = 0;
        int e = s.length()-1;
        int len = s.length();
        
        while (st<e) {
            int start = 0;
            int end = 0;
            if (s.charAt(st) != s.charAt(e)) {
                return len;
            }
            while(s.charAt(st) == s.charAt(st+1) && st+1<e) {
                len--;
                st++;
            }
            while(s.charAt(e) == s.charAt(e-1) && e-1>st) {
                len--;
                e--;
            }
            st++;
            e--;
            len -= 2;
        }
        
        return len;
    }
}
