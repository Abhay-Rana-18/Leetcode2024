class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int m = items.length;
        int n = queries.length;
        int[] ans = new int[n];
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        int[] prices = new int[m];
        int[] beauty = new int[m];
        prices[0] = items[0][0];
        beauty[0] = items[0][1];
        for (int i=1; i<m; i++) {
            prices[i] = items[i][0];
            beauty[i] = Math.max(items[i][1], beauty[i-1]);
        }

        for (int i=0; i<n; i++) {
            ans[i] = binarySearch(queries[i], prices, beauty);
        }
        return ans;
    }

    public int binarySearch(int x,int prices[],int beauty[]) {
        int l=0,r=prices.length-1,mid=0;
        int ans=0;
        while(l<=r){
            mid=l+(r-l)/2;
            if(prices[mid]<=x){
                ans=beauty[mid];
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans;
    }
}
