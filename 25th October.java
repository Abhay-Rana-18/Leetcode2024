class Solution {
    public List<String> removeSubfolders(String[] folder) {
        int n = folder.length;
        Set<String>set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        for (int i=0; i<n; i++) {
            set.add(folder[i]);
        }
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            boolean add = true;
            for (int j=0; j<folder[i].length(); j++) {
                char ch = folder[i].charAt(j);
                if (ch == '/') {
                    if (set.contains(sb.toString())) {
                        add = false;
                        break;
                    }
                }
                sb.append(ch);
            }
            if (add) {
                ans.add(sb.toString());
            }
        }

        return ans;
    }
}
