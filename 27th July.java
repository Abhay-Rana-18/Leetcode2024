class Solution {
    public int CHARLEN = 26;
    public int MAX_VAL = Integer.MAX_VALUE/2;
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][]graph = constructGraph(original, changed, cost);
        optimizeGraph(graph);
        return calculateAns(graph, source, target);
    }

    public int[][] constructGraph(char[]original, char[]changed, int[]cost) {
        int[][]graph = new int[CHARLEN][CHARLEN];
        for (int i=0; i<CHARLEN; i++) {
            Arrays.fill(graph[i], MAX_VAL);
            graph[i][i] = 0;
        }

        for (int i=0; i<original.length; i++) {
            int from = original[i]-'a';
            int to = changed[i]-'a';
            graph[from][to] = Math.min(graph[from][to], cost[i]);
        }
        return graph;
    }

    public void optimizeGraph(int[][]graph) {
        for (int k=0; k<CHARLEN; k++) {
            for (int i=0; i<CHARLEN; i++) {
                if (graph[i][k]<MAX_VAL) {
                    for (int j=0; j<CHARLEN; j++) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
    }

    public long calculateAns(int[][]graph, String original, String target) {
        long ans = 0;
        for (int i=0; i<original.length(); i++) {
            int ch1 = original.charAt(i);
            int ch2 = target.charAt(i);
            if (ch1 != ch2) {
                if (graph[ch1-'a'][ch2-'a']==MAX_VAL) {
                    return -1L;
                }
                ans += graph[ch1-'a'][ch2-'a'];
            }
        }
        return ans;
    }
}
