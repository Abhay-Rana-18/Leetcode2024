class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n-1; i++) {
            adj.add(new ArrayList<>());
            adj.get(i).add(i+1);
        }
        adj.add(new ArrayList<>());
        int[] ans = new int[queries.length];
        int i=0;
        for (int[] arr: queries) {
            int f = queries[i][0];
            int s = queries[i][1];
            if (f==s) {
                ans[i] = i==0 ? n-1 : ans[i-1];
                i++;
                continue;
            }
            adj.get(f).add(s);
        
            ans[i++] = bfs(adj, n);
        }
        return ans;
    }

    private int bfs(List<List<Integer>> adj, int n) {
        boolean[] vis = new boolean[n];
        vis[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int lvl = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-->0) {
                int curr = queue.poll();
                if (curr==n-1) return lvl;
                for (int e: adj.get(curr)) {
                    if (vis[e]) {
                        continue;
                    }
                    else {
                        queue.add(e);
                        vis[e] = true;
                    }
                }
            }
            lvl++;
        }
        return -1;
    }
}
