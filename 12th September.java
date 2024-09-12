class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int n = words.length;
        HashMap<Character, Integer>map = new HashMap<>();
        for (int i=0; i<allowed.length(); i++) {
            map.put(allowed.charAt(i), 1);
        }
        int ans = 0;
        boolean add;
        for(int i=0; i<n; i++) {
            add = true;
            String str = words[i];
            for (int j=0; j<str.length(); j++) {
                if (!map.containsKey(str.charAt(j))) {
                    add = false;
                    break;
                }
            }
            if (add) {
                ans++;
            }
        }
        return ans;
    }
}
