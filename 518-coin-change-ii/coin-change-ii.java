class Solution {
    public int change(int amount, int[] coins) {
        int[]dp=new int[amount+1];
        dp[0]=1;
        for(int coin:coins){
            if (coin > amount) continue;
            for(int j=coin;j<=amount;j++){
                dp[j]=dp[j-coin]+dp[j];
            }
        }
        return dp[amount]; 
    }
}