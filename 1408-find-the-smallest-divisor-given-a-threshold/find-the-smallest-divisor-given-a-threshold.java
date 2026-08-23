class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1,high=Integer.MIN_VALUE;
        for(int num:nums){
            high=Math.max(num,high);
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(calculate(nums,mid,threshold)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean calculate(int[]nums,int mid,int threshold){
        int ans=0;
        for(int num:nums){
            ans+=(num+mid-1)/mid;
        }
        return ans<=threshold;
    }
}