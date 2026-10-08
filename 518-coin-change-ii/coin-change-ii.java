class Solution {
    public int change(int amount, int[] coins) {
        int[]dp=new int[amount+1];
        dp[0]=1;
        for(int index=coins.length-1;index>=0;index--){
            for(int j=coins[index];j<=amount;j++){
                dp[j]=dp[j-coins[index]]+dp[j];
            }
        }
        return dp[amount]; 
    }
}