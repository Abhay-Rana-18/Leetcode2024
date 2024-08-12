class KthLargest {
    int pos;
    private PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.pos = k;
        pq = new PriorityQueue<>(k);
        for (int num : nums) {
            pq.offer(num);
        }
        while (pq.size()>pos) {
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        while (pq.size()>pos) {
            pq.poll();
        }
        // System.out.println(pq);
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
