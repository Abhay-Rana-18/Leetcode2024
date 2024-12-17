class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for (char ch: s.toCharArray()) {
            freq[ch-'a']++;
        }
        int rem = -1;
        for (int i=25; i>=0; i--) {
            if (freq[i]==0) continue;
            if (rem != -1) {
                sb.append((char)('a'+i));
                freq[i]--;
                i = rem;
                rem = -1;
            }
            else {
                for(int j=0; j<repeatLimit && freq[i]>0; j++, freq[i]--) {
                    sb.append((char)('a'+i));
                }
                if (freq[i]>0) {
                    rem = i+1;
                }
            }
        }

        return sb.toString();
    }
}
