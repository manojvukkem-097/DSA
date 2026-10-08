class Solution {
    public int change(int amount, int[] coins) {
        int[][]dp=new int[coins.length+1][amount+1];
        dp[coins.length][0]=1;
        for(int index=coins.length-1;index>=0;index--){
            for(int j=0;j<=amount;j++){
                int take=0;
                if(j-coins[index]>=0)take=dp[index][j-coins[index]];
                int nottake=dp[index+1][j];
                dp[index][j]=take+nottake;
            }
        }
        return dp[0][amount]; 
    }
    private int helper(int[]coins,int index,int amount,int[][]dp){
        if(amount<0)return 0;
        if(index==coins.length)return amount==0?1:0;
        if(dp[index][amount]!=-1)return dp[index][amount];
        int take=0;
        if(amount-coins[index]>=0)take=helper(coins,index,amount-coins[index],dp);
        int nottake=helper(coins,index+1,amount,dp);
        return dp[index][amount]=take+nottake;
    }
}