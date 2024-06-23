class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        LinkedList<Integer> increased = new LinkedList<>();
        LinkedList<Integer> decreased = new LinkedList<>();
        int left = 0;
        int ans = 0;

        for (int i=0; i<n; i++) {
            int element = nums[i];
            while (increased.size()>0 && element<increased.getLast()) {
                increased.removeLast();
            }
            increased.add(element);

            while (decreased.size()>0 && element>decreased.getLast()) {
                decreased.removeLast();
            }
            decreased.add(element);

            while (decreased.getFirst()-increased.getFirst() > limit) {
                if (increased.getFirst() == nums[left]) {
                    increased.removeFirst();
                }
                if (decreased.getFirst() == nums[left]) {
                    decreased.removeFirst();
                }
                left++;
            }

            ans = Math.max(ans, (i-left)+1);
        }
        return ans;

    }
}
