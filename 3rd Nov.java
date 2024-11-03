class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if (n!=goal.length()) {
            return false;
        }
        for (int i=1; i<n; i++) {
            String first = s.substring(0, i);
            String second = s.substring(i, n);
            if (goal.indexOf(first)!=-1 && goal.indexOf(second)!=-1) {
                return true;
            }
        }
        return false;
    }
}
