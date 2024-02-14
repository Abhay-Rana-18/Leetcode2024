class Solution {
    public String firstPalindrome(String[] words) {
        for (int i=0; i<words.length; i++) {
            if (check(words[i])) {
                return words[i];
            }
        }
        return "";
    }
    public boolean check(String str) {
        for (int i=0; i<=str.length()/2; i++) {
            if (str.charAt(i)!=str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
