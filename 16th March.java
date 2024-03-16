class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        HashMap<Integer, Integer>map = new HashMap<>();
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            count += nums[i]==1 ? 1: -1;
            if (count==0) {
                maxLength = Math.max(maxLength, i+1);
            }
            else if(map.containsKey(count)) {
                maxLength = Math.max(maxLength, i-map.get(count));
            }
            else {
                map.put(count, i);
            }
        }

        return maxLength;
    }
}
