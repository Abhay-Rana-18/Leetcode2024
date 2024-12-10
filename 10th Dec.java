class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int max = -1;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            char ch = s.charAt(i);
            StringBuilder sb = new StringBuilder();
            int j = i;
            while (i<n && s.charAt(i)==ch) {
                sb.append(s.charAt(i));
                i++;
                String str = sb.toString();
                if (map.get(str)>=3) {
                    max = Math.max(max, str.length());
                }
            }
            i = j;
        }
        return max;
    }
}
