class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][]dp=new int[n][2][k+1];
        for(int[][]row:dp){
            for(int[]col:row){
                Arrays.fill(col,-1);
            }
        }
        return helper(prices,0,1,k,dp);
    }
    private int helper(int[]prices,int day,int buy,int k,int[][][]dp){
        if(day==prices.length||k==0){
            return 0;
        }
        if(dp[day][buy][k]!=-1)return dp[day][buy][k];
        if(buy==1){
            int take=-prices[day]+helper(prices,day+1,0,k,dp);
            int nottake=helper(prices,day+1,1,k,dp);
            return dp[day][buy][k]=Math.max(take,nottake);
        }else{
            int sell=prices[day]+helper(prices,day+1,1,k-1,dp);
            int hold=helper(prices,day+1,0,k,dp);
            return dp[day][buy][k]=Math.max(sell,hold);
        }
    }
}