class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> lst = new ArrayList<>();
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (lst.size()!=0 && lst.get(lst.size()-1) != nums1[i]) {
                    lst.add(nums1[i]);
                    i++;
                    j++;
                }
                else if(lst.size()==0) {
                    lst.add(nums1[i]);
                    i++;
                    j++;
                }
                else {
                    i++;
                    j++;
                    continue;
                }
                
            }
            else if (nums1[i]<nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        
        int[]ans = new int[lst.size()];
        for (int k=0; k<ans.length; k++) {
            ans[k] = lst.get(k);
        }

        return ans;
    }
}
