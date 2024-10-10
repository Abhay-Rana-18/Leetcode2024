class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] <= nums[stack.peek()]) {
                stack.push(i);
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if ((max >= i) || (stack.isEmpty())) {
                break;
            }

            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                max = Math.max(max, i - stack.peek());
                stack.pop();
            }
        }

        return max;
    }
}
