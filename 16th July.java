/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 * 
 * 
 * ALGO
    1. FIND LCA of both nodes -> shortes path must run through this
    2. Calc direcitonal path via backtrack + record
    3. Update start path to reflect 'U's
    4. Join start and dest path and return

 */
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ancestor = lowestCommonAncestor(root, startValue, destValue);

        List<String> toStart = new ArrayList<>();
        getDirection(ancestor, startValue, new ArrayList<String>(), toStart);
        List<String> toDest = new ArrayList<>();
        getDirection(ancestor, destValue, new ArrayList<String>(), toDest);

        // start -> LCA
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < toStart.size(); i++)
            sb.append("U");
        // LCA -> dest
        for (String s : toDest)
            sb.append(s);
        return sb.toString();
    }

    // base LCA
    private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || p == root.val || q == root.val)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        else
            return left == null ? right : left;
    }

    public void getDirection(TreeNode node, int val, List<String> step, List<String> path) {
        if (node == null)
            return;

        if (node.val == val) {
            path.clear(); // Clear the path list
            path.addAll(step); // Copy the steps to the path
            return;
        }

        if (node.left != null) {
            step.add("L");
            getDirection(node.left, val, step, path);
        }

        if (node.right != null) {
            step.add("R");
            getDirection(node.right, val, step, path);
        }
        step.remove(step.size() - 1);
    }

    private boolean getDirection2(TreeNode ancestor, int value, List<String> steps) {
        if (ancestor == null)
            return false;
        if (ancestor.val == value)
            return true;
        steps.add("L");
        if (getDirection2(ancestor.left, value, steps))
            return true;
        steps.remove(steps.size() - 1);
        steps.add("R");
        if (getDirection2(ancestor.right, value, steps))
            return true;
        steps.remove(steps.size() - 1);
        return false;
    }
}
