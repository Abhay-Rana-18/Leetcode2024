class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root==null) {
            return 0;
        }

        int sum = root.val>=low && root.val<=high ? root.val : 0;
        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);
        return sum + left + right;
    }
}
