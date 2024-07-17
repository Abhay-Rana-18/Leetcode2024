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
    public Map<Integer, Integer> map = new HashMap<>();
    public List<TreeNode>ans = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int e: to_delete) {
            map.put(e, 1);
        }
        dfs(root, true);
        return ans;
    }

    public TreeNode dfs(TreeNode node, boolean flag) {
        if (node == null) return null;
        if (map.containsKey(node.val)) {
            node.left = dfs(node.left, true);
            node.right = dfs(node.right, true);
        }
        else {
            node.left = dfs(node.left, false);
            node.right = dfs(node.right, false);
        }

        if (flag && !map.containsKey(node.val)) {
            ans.add(node);
        }
        return map.containsKey(node.val) ? null : node;
    }
}
