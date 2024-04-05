class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i=1; i<sb.length(); i++) {
            while (i>0 && i<sb.length() && Math.abs(sb.charAt(i)-sb.charAt(i-1)) == 32) {
                sb.delete(i-1, i+1);
                i--;
            }
        }
        return sb.toString();
    }
}
