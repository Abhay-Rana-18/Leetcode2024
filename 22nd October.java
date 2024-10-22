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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> st = new PriorityQueue<>(k);
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        while(!pq.isEmpty()){
            long sm = 0;
            int n = pq.size();
            for(int i=0; i<n; i++){
                TreeNode node = pq.poll();
                sm += node.val;
                if(node.left!=null) pq.add(node.left);
                if(node.right!=null) pq.add(node.right);
            }
            st.add(sm);
            if(st.size()>k) st.poll();
        }
        if(st.size()<k) return -1;
        return st.poll();
    }
}
