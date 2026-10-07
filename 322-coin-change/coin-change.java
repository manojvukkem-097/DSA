class Solution {
    public int coinChange(int[] coins, int amount) {
        int[]dp=new int[amount+1];
        Arrays.fill(dp,(int)1e9);
        dp[0]=0;
        for(int index=coins.length-1;index>=0;index--){
            for(int j=coins[index];j<=amount;j++){
                dp[j]=Math.min(1+dp[j-coins[index]],dp[j]);
            }
        }
        int ans=dp[amount];
        return ans>=(int)1e9?-1:ans;
    }
}