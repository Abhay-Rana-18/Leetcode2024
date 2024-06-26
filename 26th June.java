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
    List<Integer> list = new ArrayList<>();
    public void dfs(TreeNode node) {
        if (node==null) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }

    public TreeNode createBst(int l, int r) {
        if (l>r) {
            return null;
        }
        int m = (l+r)/2;
        return new TreeNode(list.get(m), createBst(l, m-1), createBst(m+1, r));
    }

    public TreeNode balanceBST(TreeNode root) {
        dfs(root);
        return createBst(0, list.size()-1);
    }
}
