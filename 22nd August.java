class Solution {
    public int findComplement(int num) {
        String strs=Integer.toBinaryString(num);
        int ans = 0;
        int n = strs.length()-1;
        for (char ch: strs.toCharArray()) {
            if (ch == '0') {
                ans += Math.pow(2, n);
            }
            n--;
        }
        return ans;
    }
}
