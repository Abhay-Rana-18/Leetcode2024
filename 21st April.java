class Solution {
    int[] uf;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       uf = new int[n];
       for(int i =0;i<n;i++)
            uf[i] = i;

        for(int[] e : edges){
            int p1 = find(e[0]);
            int p2 = find(e[1]);
            if(p1 != p2)
                uf[p1] = p2;//union
        }

        return find(source) == find(destination);

    }
    private int find(int a){
        while(uf[a] != a){
            uf[a] = uf[uf[a]];//compression
            a = uf[a];
        }
        return a;
    }
}
