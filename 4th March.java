class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int count = 0;
        int i = 0;
        int n = tokens.length;
        while (i<n && (power>=tokens[i] || count!=0)) {
            if(i==n-1 && power<tokens[i]) {
                return count;
            }
            if (power<tokens[i]) {
                count--;
                n--;
                power+= tokens[n];
            }
            else {
                count++;
                power -= tokens[i];
                i++;
            }
            
        }

        return count;
    }
}
