class Solution {
    public int smallestDistancePair(int[] nums, int k) {//O(nlogn)
        //Binary Search approach
        Arrays.sort(nums);
        int L=0;int R=nums[nums.length-1];
        while(L!=R){  //->log(n)*n
            int mid = L+(R-L)/2;
            //sliding window technique for o(n)
            //count no of pairs with diff <=mid
            int count=0;
            int l=0;int r=1;
            while(r<nums.length){  //o(n)
                int diff = nums[r]-nums[l];
                if(diff<=mid){
                    if(r==nums.length-1){
                        count+=r-l;
                        l++;
                    }else{
                        r++;
                    }
                }else if(diff>mid){
                    count+=r-l-1;//extra pair remove(-1)
                    l++;
                }
                if(l==r){
                    r++;
                }
            }
            if(count>=k){
                R=mid;
            }else if(count<k){
                L=mid+1;
            }
        }
        return L;
    }
}
