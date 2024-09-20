class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int div = 0;
        StringBuilder str = new StringBuilder();
        for (int i=n-1; i>=0; i--) {
            if (pali(0, i, s)) {
                div = i;
                break;
            }
        }

        for (int i=n-1; i>div; i--) {
            str.append(s.charAt(i));
        }
        for (int i=0; i<n; i++) {
            str.append(s.charAt(i));
        }
        return str.toString();
    }

    public boolean pali(int start, int end, String s) {
        while (start<end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
