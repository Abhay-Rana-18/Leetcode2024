class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int e: gifts) {
            pq.add(e);
        }
        while (k-->0) {
            int add = (int)(Math.sqrt(pq.poll()));
            pq.add(add);
        }
        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}
