class Solution {
    public int getLucky(String s, int k) {
        int n = s.length();
        String number = "";
        for (int i=0; i<n; i++) {
            number += (int)(s.charAt(i) - 'a') + 1 + ""; 
        }
        int ans = 0;
        for (int i=0; i<k; i++) {
            ans = 0;
            for (int j=0; j<number.length(); j++) {
                ans += number.charAt(j) - '0';
            }
            number = ans + "";
        }
        return ans;
    }
}
