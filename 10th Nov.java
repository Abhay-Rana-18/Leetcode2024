class Solution {
    public void add(int val,int[] arr){
        int p = 0;
        while(val>0){
            if((val&1) != 0)
                arr[p]++;
            val>>=1;
            p++;
        }
    }
    public int update(int val1,int or,int[] arr){
        int q = 0;   
        while(val1>0){
            if((val1&1) != 0){
                arr[q]--;
                if(arr[q] == 0)
                or = or^(1<<(q));
            }
            val1>>=1;
            q++;
        }
        return or;
    }
    public int minimumSubarrayLength(int[] nums, int k) {
       
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int start=0,end = 0;
        int or = 0;
        int[] arr = new int[32];
        while(end<n){
            or |=nums[end];
            add(nums[end],arr);
            while(or >= k && start<=end){
                ans = Math.min(ans,end-start+1);
                or = update(nums[start],or,arr);
                start++;
            }
            end++;
            
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
