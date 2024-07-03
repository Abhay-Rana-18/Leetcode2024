class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer>ans = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0;
        int i2 = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        while (i1<n1 && i2<n2) {
            if (nums1[i1]==nums2[i2]) {
                ans.add(nums1[i1]);
                i1++;
                i2++;
            }
            else {
                if (nums1[i1]<nums2[i2]) {
                    i1++;
                }
                else {
                    i2++;
                }
            }
        }
        int[]res = new int[ans.size()];
        for (int i=0; i<res.length; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}
