class Solution {
    public int maxDepth(String s) {
        int open = 0;
        int depth = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='(')  {
                open++;
            }
            if (s.charAt(i)==')') {
                depth = Math.max(depth, open);
                open--;
            }
        }

        return depth;
    }
}
