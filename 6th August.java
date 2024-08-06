class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer>map = new HashMap<>();
        int n = word.length();
        int count = 0;
        for (int i=0; i<n; i++) {
            char ch = word.charAt(i);
            if (!map.containsKey(ch)) {
                count++;
            }
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int[]arr = new int[count];
        int k = 0;
        for (int i=0; i<26; i++) {
            if (map.containsKey((char)('a'+i))) {
                arr[k++] = map.get((char)('a' + i));
            }
        }
        Arrays.sort(arr);
        int ans = 0;
        int key = 1;
        int t = 0;
        for (int i=count-1; i>=0; i--) {
            t++;
            ans += arr[i] * key;
            if (t==8) {
                t = 0;
                key++;
            }
        }
        return ans;
    }
}
