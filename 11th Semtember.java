class Solution {
    public int minBitFlips(int start, int goal) {
        int sm, lg = 0;
        if (start<goal) {
            sm = start;
            lg = goal;
        }
        else {
            sm = goal;
            lg = start;
        }

        String small = Integer.toBinaryString(sm);
        String large = Integer.toBinaryString(lg);
        int i = small.length()-1;
        int ans = 0;
        
        for (int k=large.length()-1; k>=0; k--) {
            if (i>=0) {
                if (large.charAt(k) != small.charAt(i)) {
                    ans++;
                }
                i--;
            }
            else {
                if (large.charAt(k) == '1') {
                    ans++;
                }
            }
        }

        return ans;
    }
}
