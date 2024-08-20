class Solution {
    int n=0;
      private int[][][] t = new int[2][101][101];
    public int stoneGameII(int[] piles) {
        n = piles.length;
          for (int[][] arr2D : t) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }
        
     return findAlice(piles,1,0,1);   
    }

    int findAlice(int[] piles, int person,int i,int m)
    {
         if(i>=n)
         return 0;
         if (t[person][i][m] != -1) {
            return t[person][i][m];
        }
        
         int result = (person==1) ? -1 : Integer.MAX_VALUE;
         int stones = 0;
         for(int x=1;x<=Math.min(2*m,n-i);x++)
         {
            stones += piles[i + x - 1];
            if(person==1)
            result = Math.max(result, stones+findAlice(piles,0,i+x,Math.max(m,x)));
            else
            result = Math.min(result, findAlice(piles,1,i+x,Math.max(m,x)));
         }
        return t[person][i][m] = result;
    }
}
