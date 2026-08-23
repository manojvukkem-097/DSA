class Solution {
    public int splitArray(int[] nums, int k) {
        if(k>nums.length)return -1;
        int low=Integer.MIN_VALUE,high=0;
        for(int num:nums){
            low=Math.max(low,num);
            high+=num;
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(calculate(nums,mid,k)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean calculate(int[]nums,int mid,int k){
        int count=1,sum=0;
        for(int num:nums){
            if(sum+num>mid){
                count++;
                sum=num;
                if(count>k){
                    return false;
                }
            }else{
                sum+=num;
            }
        }
        return true;
    }
}