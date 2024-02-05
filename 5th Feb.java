class Solution {
    public int firstUniqChar(String s) {
        int []alpha = new int[27];
        for (int i=0; i<s.length(); i++) {
            alpha[s.charAt(i)-'a'] ++;
        }
        for (int i=0; i<s.length(); i++) {
            if (alpha[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
