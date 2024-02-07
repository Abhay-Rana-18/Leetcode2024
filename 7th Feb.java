class Solution {
    public String frequencySort(String s) {
       char[] charArray = s.toCharArray();

        // Sort the character array
        Arrays.sort(charArray);

        // Convert the sorted character array back to a string
        String sortedStr = new String(charArray);

        List<String> strs = new ArrayList<>();
        for (int i=0; i<charArray.length; i++) {
            String str = ""+charArray[i];
            while (i+1<charArray.length && charArray[i+1] == charArray[i]) {
                str += charArray[i+1];
                i++;
            }
            strs.add(str);
        }

        String ans = "";
        while (strs.size()>0) {
            String max = strs.get(0);
            for (int i=1; i<strs.size(); i++) {
                if (strs.get(i).length() > max.length()) {
                    max = strs.get(i);
                }
            }
            strs.remove(max);
            ans += max;
        }

        return ans;
       
    }
}
