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
    public int sumOfLeftLeaves(TreeNode root) {
        traversal(root);
        return ans;
    }

    private void traversal(TreeNode node) {
        if (node==null) return;
        if (node.left==null && node.right==null) return;
        if (node.left!=null && node.left.right==null && node.left.left==null) {
            ans+=node.left.val;
            traversal(node.right);
            return;
        }
        traversal(node.right);
        traversal(node.left);
    }
}
