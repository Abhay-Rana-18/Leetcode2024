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
    public int minimumOperations(TreeNode root) {
        if (root==null) return 0;
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left!=null) {
                    q.add(node.left);
                }
                if (node.right!=null) {
                    q.add(node.right);
                }
            }
            List<Integer> sorted = new ArrayList<>(level);
            Collections.sort(sorted);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i=0; i<size; i++) {
                map.put(level.get(i), i);
            }
            for (int i=0; i<size; i++) {
                int a = sorted.get(i);
                int b = level.get(i);
                int idx = map.get(a);
                if (idx!=i) {
                    ans++;
                    map.put(b, idx);
                    map.put(a, i);
                    Collections.swap(level, i, idx);
                }
            }
        }
        return ans;
    }
   
}
