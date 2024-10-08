class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        fun(candidates, 0, target, new ArrayList<>(), 0);
        return ans;
    }

    public void fun(int[]candidates, int i, int target, List<Integer>lst, int sum) {
        if (sum==target) {
            ans.add(new ArrayList<>(lst));
            // System.out.println(ans);
            return;
        }
        if (sum > target) {
            return;
        }
        if (i>=candidates.length) {
            return;
        }

        lst.add(candidates[i]);
        sum += candidates[i];

        fun(candidates, i+1, target, lst, sum);
        sum -= candidates[i];
        lst.remove(lst.size()-1);
        while (i<candidates.length-1 && candidates[i]==candidates[i+1]) {
            i++;
        }
        fun(candidates, i+1, target, lst, sum);
        return;
    }
}
