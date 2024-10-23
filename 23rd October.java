class Pair {
    TreeNode node;
    int siblingsSum;
    public Pair(TreeNode node, int siblingsSum) {
        this.node = node;
        this.siblingsSum = siblingsSum;
    }
}

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
     Queue<Pair> queue = new ArrayDeque<>(new ArrayList<>(List.of(new Pair(root, root.val))));
     int currLevelSum = root.val;
     while (!queue.isEmpty()) {
         int size = queue.size();
         int nextLevelSum = 0;
         for (int i = 0; i < size; i++) {
             Pair pair = queue.remove();
             TreeNode curr = pair.node;
             int childrenSum = getChildrenSum(curr);
             if (curr.left != null) {
                 queue.add(new Pair(curr.left, childrenSum));
                 nextLevelSum += curr.left.val;
             }
             if (curr.right != null) {
                 queue.add(new Pair(curr.right, childrenSum));
                 nextLevelSum += curr.right.val;
             }
             curr.val = currLevelSum - pair.siblingsSum;
         }
         currLevelSum = nextLevelSum;
     }
     return root;
    }

    private int getChildrenSum(TreeNode parent) {
        int sum = 0;
        if (parent.left != null) sum += parent.left.val;
        if (parent.right != null) sum += parent.right.val;
        return sum;
    }
}
