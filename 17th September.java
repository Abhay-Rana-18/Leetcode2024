class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String>res = new ArrayList<>();
        String[]str1 = s1.split(" ");
        String[]str2 = s2.split(" ");
        Map<String, Integer>map = new HashMap<>();
        for (int i=0; i<str1.length; i++) {
            map.put(str1[i], map.getOrDefault(str1[i], 0) + 1);
        }
        for (int i=0; i<str2.length; i++) {
            map.put(str2[i], map.getOrDefault(str2[i], 0) + 1);
        }

        for (int i=0; i<str1.length; i++) {
            if (map.get(str1[i]) == 1) {
                res.add(str1[i]);
            }
        }
        for (int i=0; i<str2.length; i++) {
            if (map.get(str2[i]) == 1) {
                res.add(str2[i]);
            }
        }

        String[]ans = new String[res.size()];
        for (int i=0; i<ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
