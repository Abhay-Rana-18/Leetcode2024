class Solution {
    public int largestCombination(int[] c) {
        int n = c.length;
        int[] size = new int[24];
        
        for (int i=0; i<n; i++) {
            int idx = 0;
            String bi = Integer.toBinaryString(c[i]);
            for (int j=bi.length()-1; j>=0; j--) {
                if (bi.charAt(j)=='1') {
                    size[idx]++;
                }
                idx++;
            }
        }
        int max = 0;
        for (int i=0; i<size.length; i++) {
            max = Math.max(max, size[i]);
        }
        return max;
    }
}
