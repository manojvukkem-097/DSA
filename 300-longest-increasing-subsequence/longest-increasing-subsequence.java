class Solution {
    public int lengthOfLIS(int[] nums) {
        int[]next=new int[nums.length+1];
        for(int index=nums.length-1;index>=0;index--){
            int[]curr=new int[nums.length+1];
            for(int j=index-1;j>=-1;j--){
                int take=0;
                if(j==-1||nums[index]>nums[j]){
                    take=1+next[index+1];
                }
                int nottake=next[j+1];
                curr[j+1]=Math.max(take,nottake);
            }
            next=curr;
        }
        return next[0];
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