class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][]dp=new int[nums.length][nums.length];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return helper(nums,0,-1,dp);
    }
    private int helper(int[]nums,int index,int prev,int[][]dp){
        if(index==nums.length)return 0;
        if(prev!=-1&&dp[index][prev]!=-1)return dp[index][prev];
        int take=0;
        if(prev==-1||nums[index]>nums[prev]){
            take=1+helper(nums,index+1,index,dp);
        }
        int nottake=helper(nums,index+1,prev,dp);
        if(prev!=-1)dp[index][prev]=Math.max(take,nottake);
        return Math.max(take,nottake);
    }
}