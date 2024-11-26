class Solution {
    public int findChampion(int n, int[][] edges) {
        int len = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<len; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        for (int i=0; i<n; i++) {
            Set<Integer> visited = new HashSet<>();
            int wins = dfs(adj, i, visited);
            // System.out.println("i: "+i+", wins: "+wins);
            if (wins==(n-1)) {
                return i;
            }
        }

        return -1;

    }

    private int dfs(List<List<Integer>> adj, int node, Set<Integer>set) {
        int wins = 0;
        set.add(node);
        for (int e: adj.get(node)) {
            if (set.contains(e)) continue;
            wins += 1+dfs(adj, e, set);
        }
        return wins;
    }
}
