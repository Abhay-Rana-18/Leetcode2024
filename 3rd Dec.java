class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int m = spaces.length;
        int idx = 0;
        for (int i=0; i<m; i++) {
            String str = s.substring(idx, spaces[i]);
            idx = spaces[i];
            sb.append(str);
            sb.append(" ");
        }
        String str = s.substring(idx, n);
        sb.append(str);
        return sb.toString();
    }
}
