class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (int i=0; i<details.length; i++) {
            int first = (int)(details[i].charAt(11)-'0');
            if (first > 6 ) ans++;
            if (first == 6 && details[i].charAt(12) != '0') {
                ans++;
            }
        }
        return ans;
    }
}
