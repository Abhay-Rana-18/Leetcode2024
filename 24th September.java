class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer>hs = new HashSet<>();
        for (int n1:arr1) {
            while(n1>0) {
                hs.add(n1);
                n1/=10;
            }
        }

        int res = 0;
        for (int n2:arr2) {
            while(n2>0) {
                if (hs.contains(n2)) {
                    res = Math.max(res, n2);
                    break;
                }
                n2 /= 10;
            }
        }

        int ans = 0;
        while (res>0) {
            res /= 10;
            ans++;
        }
        return ans;
    }
}
