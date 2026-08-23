class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0,high=0;
        for(int num:weights){
            low=Math.max(low,num);
            high+=num;
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(calculate(weights,mid,days)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean calculate(int[]nums,int mid,int days){
        int ans=1,sum=0;
        for(int num:nums){
            if(num+sum<=mid){
                sum+=num;
            }else{
                sum=num;
                ans++;
            }
        }
        return ans<=days;
    }
}