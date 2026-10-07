class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][]dp=new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++){
            Arrays.fill(dp[i],(int)1e9);
        }
        for(int i=0;i<coins.length+1;i++){
            dp[i][0]=0;
        }
        for(int index=coins.length-1;index>=0;index--){
            for(int j=1;j<=amount;j++){
                int take=(int)1e9;
                if(j-coins[index]>=0)take=1+dp[index][j-coins[index]];
                int nottake=dp[index+1][j];
                dp[index][j]=Math.min(take,nottake);
            }
        }
        int ans=dp[0][amount];
        return ans>=(int)1e9?-1:ans;
    }
}