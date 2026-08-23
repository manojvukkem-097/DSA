class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length)return -1;
        int low=Integer.MAX_VALUE,high=Integer.MIN_VALUE;
        for(int num:bloomDay){
            low=Math.min(num,low);
            high=Math.max(high,num);
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(calculate(bloomDay,mid,m,k)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean calculate(int[]nums,int mid,int m,int k){
        int flowers=0,countm=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]<=mid){
                flowers++;
                if(flowers==k){
                    countm++;
                    flowers=0;
                    if(countm==m){
                        return true;
                    }
                }
            }else{
                flowers=0;
            }
        }
        return false;
    }
}