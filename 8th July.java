class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer>queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            queue.add(i);
        }
        while(queue.size()>1) {
            for (int j=0; j<k-1; j++) {
                int temp = queue.remove();
                queue.add(temp);
            }
            queue.remove();
        }
        return queue.remove();
    }
}
