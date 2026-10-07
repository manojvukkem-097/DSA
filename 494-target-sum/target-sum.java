class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(Math.abs(target)>sum){
            return 0;
        }
        int[][]dp=new int[nums.length+1][2*sum+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return helper(nums,0,target,sum,dp);
    }
    private int helper(int[]nums,int index,int target,int sum,int[][]dp){
        if(index==nums.length)return target==0?1:0;
        if (Math.abs(target) > sum) {
            return 0;
        }
        int dptarget=target+sum;
        if(dp[index][dptarget]!=-1)return dp[index][dptarget];
        int positive=helper(nums,index+1,target-nums[index],sum,dp);
        int negative=helper(nums,index+1,target+nums[index],sum,dp);
        return dp[index][dptarget]=positive+negative;
    }
}