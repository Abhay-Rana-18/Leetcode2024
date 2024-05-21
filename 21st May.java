class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums, new ArrayList<>(), 0);
    }

    public List<List<Integer>> helper(int[]nums, List<Integer> lst, int index) {
        if (index==nums.length) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(lst));
            return ans;
        }

        List<List<Integer>> arr = new ArrayList<>();
        lst.add(nums[index]);
        arr.addAll(helper(nums, lst, index+1));
        lst.remove(lst.size()-1);
        arr.addAll(helper(nums, lst, index+1));

        return arr;
    }
}
