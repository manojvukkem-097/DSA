class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=0;
        for(int num:piles){
            high=Math.max(num,high);
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(counttime(piles,mid)<=h){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    private long counttime(int[]nums,int rate){
        long hours=0;
        for(int num:nums){
            hours+=(num+rate-1)/rate;
        }
        return hours;
    }
}