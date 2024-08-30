class Solution {

    private void solveDijkstra(List<int[]>[] adj, int[][] edges, int[][] dist, int source, int diff, int run) {
        int n = adj.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] { source, 0 });
        dist[source][run] = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.remove();

            int currNode = top[0];
            int currDist = top[1];
            if (currDist > dist[currNode][run]) {
                continue;
            }

            for (int[] ad : adj[currNode]) {
                int nextNode = ad[0], idx = ad[1];

                int wt = edges[idx][2];
                if (wt == -1) {
                    wt = 1;
                }

                if (run == 1 && edges[idx][2] == -1) {
                    int newWeight = diff + dist[nextNode][0] - dist[currNode][1];
                    if (newWeight > wt) {
                        edges[idx][2] = wt = newWeight;
                    }
                }

                if (dist[nextNode][run] > dist[currNode][run] + wt) {
                    dist[nextNode][run] = dist[currNode][run] + wt;
                    pq.offer(new int[] { nextNode, dist[nextNode][run] });
                }
            }
        }
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(new int[] { edges[i][1], i });
            adj[edges[i][1]].add(new int[] { edges[i][0], i });
        }

        int[][] dist = new int[n][2];
        Arrays.fill(dist[source], 0);
        for (int i = 0; i < n; i++) {
            if (i != source) {
                dist[i][0] = dist[i][1] = Integer.MAX_VALUE;
            }
        }

        solveDijkstra(adj, edges, dist, source, 0, 0);

        int diff = target - dist[destination][0];
        if (diff < 0) {
            return new int[][] {};
        }

        solveDijkstra(adj, edges, dist, source, diff, 1);
        if (dist[destination][1] < target) {
            return new int[][] {};
        }

        for (int[] edge : edges) {
            if (edge[2] == -1) {
                edge[2] = 1;
            }
        }
        return edges;
    }
}
