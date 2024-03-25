class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[]arr = new int[nums.length+1];
        for (int num: nums) {
            arr[num]++;
        }

        List<Integer>ans = new ArrayList<>();
        for (int num: nums) {
            if (arr[num]==2) {
                ans.add(num);
                arr[num] = 0;
            }
        }

        return ans;
    }
}
