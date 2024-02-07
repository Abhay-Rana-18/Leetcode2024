class Solution {
    public int maxLength(List<String> arr) {
        return subSeq(arr, "", 0, 0);
    }

    public int subSeq(List<String> arr, String s, int ans, int index) {
        if (index == arr.size()) {
            ans = Math.max(ans, s.length());
            return ans;
        }

        String sub = arr.get(index);
        String add = "";
       
        if (toAdd(sub, s)) {
            add =  sub;
        }
        ans = subSeq(arr, s, ans, index+1);
        ans = subSeq(arr, s+add, ans, index+1);

        return ans;
    }

    public boolean toAdd(String sub, String s) {
         for (int i=0; i<sub.length(); i++) {
            if (sub.indexOf(sub.charAt(i)) != -1 && sub.indexOf(sub.charAt(i)) != i) {
                return false;
            }
        }

        for (int i=0; i<sub.length(); i++) {
            if (s.indexOf(sub.charAt(i)) != -1) {
                return false;
            } 
        }
        return true;
    }
}
