class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n1 = edges1.length + 1;
        int n2 = edges2.length + 1;
        int[] first = find(edges1, n1);
        int[] second = find(edges2, n2);
        return Math.max(Math.max(first[1], second[1]), first[0]+second[0]+1);
    }

    private int[] find(int[][] edges, int n) {
        if (n<=2) {
            return new int[]{n-1, n-1};
        }
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n];
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            if (degree[i]==1) {
                q.add(i);
            }
        }
        int lastSize = 0;
        int height = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int node = q.poll();
                for (int e: graph.get(node)) {
                    degree[e]--;
                    if (degree[e]==1) {
                        q.add(e);
                    }
                }
            }
            lastSize = size;
            height++;
        }
        height--;
        int dia = height * 2;
        if (lastSize>=2) {
            dia++;
            height++;
        }

        return new int[] {height, dia};
    }
}
