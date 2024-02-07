class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = -1;
        int index = -1;
        Arrays.sort(nums);
        for  (int i=0; i<nums.length-1; i++) {
            if (nums[i]==nums[i+1]) {
                dup = nums[i];
                index = i+1;
                break;
            }
        }
        
        boolean happens = false;
        for (int i=0; i<nums.length; i++) {
            if (i==index) {
                if (i+1<nums.length) {
                     i=i+1;
                    happens = true;
                }
               
            }

            if (!happens && nums[i]!=i+1) {
                return new int[]{dup, i+1};
                
            }
            if (happens && nums[i]!=i) {
                return new int[]{dup, i};
                
            }
          
        }
        
        return new int[]{dup, nums.length};
    }
}
