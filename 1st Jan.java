class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(s);
        Arrays.sort(g);

        if (s.length == 0) { return 0; }

        int cookieIndex = s.length - 1;
        int childIndex = g.length - 1;

        while (cookieIndex>=0 && childIndex >= 0) {
            if (g[childIndex] <= s[cookieIndex]) {  
                count++;
                cookieIndex--;
                childIndex--;
            } else {
                childIndex--;
            }
        }

        return count;
    }
}
