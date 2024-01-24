/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int []nums = new int[10];
        return helper(root, nums);
    }
    public int helper(TreeNode node, int []nums) {
        if (node == null) {
            return 0;
        }
        nums[node.val]++;
        if (node.left == null && node.right == null) {
            int count = countOdd(nums);
            nums[node.val]--;
            return count<=1 ? 1 : 0;
        }

        int ans = 0;
        ans += helper(node.left, nums);
        ans += helper(node.right, nums);
        nums[node.val]--;

        return ans;
    } 

   private int countOdd(int[] digits) {
        int cnt = 0;
        for (int i = 1; i < 10; ++i) {
            if ((digits[i] & 1) == 1) cnt++;
        }
        return cnt;
    }
}
