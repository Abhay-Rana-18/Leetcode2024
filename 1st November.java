class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        if (n<3) return s;
        int c = 1;
        char prev = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(prev);
        for (int i=1; i<n; i++) {
            char ch = s.charAt(i);
            if (ch==prev) {
                c++;
            }
            else {
                c = 1;
                prev = ch;
            }
            if (c<3) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
