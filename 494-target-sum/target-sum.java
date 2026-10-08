class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(Math.abs(target)>sum||(target+sum)%2!=0)return 0;
        int[][]dp=new int[nums.length][(target+sum)/2+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return helper(nums,0,(target+sum)/2,dp);
    }
    private int helper(int[]nums,int index,int target,int[][]dp){
        if(target<0)return 0;
        if(index==nums.length)return target==0?1:0;
        if(dp[index][target]!=-1)return dp[index][target];
        int take=0;
        if(target-nums[index]>=0)take=helper(nums,index+1,target-nums[index],dp);
        int nottake=helper(nums,index+1,target,dp);
        return dp[index][target]=take+nottake;
    }
}