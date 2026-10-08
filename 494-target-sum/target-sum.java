class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(Math.abs(target)>sum||(target+sum)%2!=0)return 0;
        int[][]dp=new int[nums.length+1][(target+sum)/2+1];
        dp[nums.length][0]=1;
        for(int index=nums.length-1;index>=0;index--){
            for(int j=(target+sum)/2;j>=0;j--){
                int take=0;
                if(j-nums[index]>=0)take=dp[index+1][j-nums[index]];
                int nottake=dp[index+1][j];
                dp[index][j]=take+nottake;
            }
        }
        return dp[0][(target+sum)/2];
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