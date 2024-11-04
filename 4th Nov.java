class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        int n = word.length();
        int start = 0;
        int i = 0;
        while (i<n) {
            int count = 0;
            while (i<n && word.charAt(i)==word.charAt(start) && count<9) {
                count++;
                i++;
            }
            ans.append(count).append(word.charAt(start));
            start = i;
        }

        return ans.toString();
    }
}
