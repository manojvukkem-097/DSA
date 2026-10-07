class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][]dp=new int[coins.length][amount+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        int ans=helper(coins,0,amount,dp);
        return ans==(int)1e9?-1:ans;
    }
    private int helper(int[]coins,int index,int amount,int[][]dp){
        if(amount==0)return 0;
        if(index==coins.length||amount<0)return (int)1e9;
        if(dp[index][amount]!=-1)return dp[index][amount];
        int take=(int)1e9;
        if(amount-coins[index]>=0)take=1+helper(coins,index,amount-coins[index],dp);
        int nottake=helper(coins,index+1,amount,dp);
        return dp[index][amount]=Math.min(take,nottake);
    }
}