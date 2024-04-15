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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        traversal(root, 0);
        return ans;
    }

    private void traversal(TreeNode node, int n) {
        if (node==null) {
            return;
        }
        if (node.left==null && node.right==null) {
            ans += n*10 + node.val;
            return;
        }
        n = n*10 + node.val;
        traversal(node.left, n);
        traversal(node.right, n);
    }
}
