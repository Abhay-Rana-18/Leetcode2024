class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer>map = new HashMap<>();
        int z = 0;
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            if (map.get(nums[i])!=null) {
                map.put(nums[i], map.get(nums[i])+1);
                if (map.get(nums[i])>k) {
                    max = Math.max(max, i-z);
                    while (z<i) {
                        map.put(nums[z], map.get(nums[z])-1);
                        if (nums[z]==nums[i]) {
                            z++;
                            break;
                        }
                        z++;
                    }
                }
            } else {
                map.put(nums[i], 1);
            }

        }

        return Math.max(max, nums.length-z);
    }
}
