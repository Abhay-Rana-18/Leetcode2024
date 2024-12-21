class Solution {
    public int ans = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e: edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int parent = 0;
        for (int i=0; i<n; i++) {
            if (graph.get(i).size()==2) {
                parent = i;
            }
        }

        find(graph, values, n, parent, -1, k);
        return ans;
    }

    private long find(List<List<Integer>> tree, int[] values, int n, int child, int parent, int k) {
        long val = values[child];
        
        for (int e: tree.get(child)) {
            if (e != parent) {
                val += find(tree, values, n, e, child, k);
            }
        }
        if (val%k == 0) {
            ans++;
        }
        return val;

    }
}
