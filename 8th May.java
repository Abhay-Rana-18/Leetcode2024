class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[]original = Arrays.copyOf(score, n);;
        String[]ans = new String[n];
        Arrays.sort(score);
        // System.out.println(Arrays.toString(original));
        for (int i=0; i<n; i++) {
            int element = original[i];
            int index = -1;
            for (int j=0; j<n; j++) {
                if (score[j]==element) {
                    index = j;
                    break;
                }
            }

            if (index==n-1) {
                ans[i] = "Gold Medal";
            }
            else if (index==n-2) {
                ans[i] = "Silver Medal";
            }
            else if (index==n-3) {
                ans[i] = "Bronze Medal";
            }
            else {
                ans[i] = "" + (n-index);
            }
        }

        return ans;
    }
}
