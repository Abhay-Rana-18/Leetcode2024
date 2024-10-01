class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] map = new int[k];
        
        for(int n : arr) {
            int rem = (n % k + k) % k;
            map[rem]++;
        }
        
        if(map[0] % 2 != 0) {
            return false;
        }
        
        for(int rem = 1; rem <= k / 2; rem++) {
            int half = k - rem;
            if(map[half] != map[rem]) {
                return false;
            }
        }
        return true;
    }
}
