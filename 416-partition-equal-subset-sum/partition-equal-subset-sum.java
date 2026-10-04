class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0)return false;
        Boolean[][]dp=new Boolean[nums.length][sum/2+1];
        return helper(nums,0,sum/2,dp);
    }
    private boolean helper(int[]nums,int index,int target,Boolean[][]dp){
        if(target==0)return true;
        if(target<0)return false;
        if(index==nums.length){
            return false;
        }
        if(dp[index][target]!=null)return dp[index][target];
        boolean take=helper(nums,index+1,target-nums[index],dp);
        boolean nottake=helper(nums,index+1,target,dp);
        return dp[index][target]=take||nottake;
    }
}